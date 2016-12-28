package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.blazer.bigclient.body.AdvisorInfoBean;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.excel.ExcelException;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.excel.vo.ExcelImportResult;
import org.blazer.bigclient.model.ClExcel;
import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.model.KamAdvisorTeam;
import org.blazer.bigclient.service.KamAdvisorService;
import org.blazer.bigclient.service.KamAdvisorTeamService;
import org.blazer.bigclient.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by yyccb on 2016-10-12.
 * 投资顾问相关
 */
@RequestMapping("/advisor")
@Controller
@Slf4j
public class KamAdvisorController extends BaseController {

    //设置文件允许上传的类型
    private static final HashMap<String, String> TypeMap = new HashMap<String, String>();

    static {
        /*TypeMap.put("image", "gif,jpg,jpeg,png,bmp");
        TypeMap.put("flash", "swf,flv");
        TypeMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        TypeMap.put("file", "doc,docx,xls,xlsx,ppt,pptx,htm,html,txt,dwg,pdf");*/
        TypeMap.put("file", "xls,xlsx");
    }

    // 设置文件上传大小
    public static long fileSize = 30 * 1024 * 1024;

    @Autowired
    private KamAdvisorService kamAdvisorService;

    @Autowired
    private KamAdvisorTeamService kamAdvisorTeamService;

    /**
     * 根据搜索条件分页查询
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findByPage")
    public PageInfo<AdvisorInfoBean> findByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        log.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return kamAdvisorService.findByPage(params);
    }

    /**
     * 查询所有投顾
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public List<KamAdvisor> findAll(){
        Example example = new Example(KamAdvisor.class);
        return kamAdvisorService.selectByExample(example);
    }


    /**
     * 单个保存
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveOne", method = RequestMethod.POST)
    public AjaxResult saveOne(HttpServletRequest request) {

        AjaxResult result = AjaxResult.success("保存投顾信息成功...");

        //获取前台页面传递的参数
        Long id = LongUtil.getLongZero(request.getParameter("id"));
        String serialNumber = StringUtil.getStrEmpty(request.getParameter("serialNumber"));
        String level = StringUtil.getStrEmpty(request.getParameter("level"));
        String systemName = StringUtil.getStrEmpty(request.getParameter("systemName"));
        String actualName = StringUtil.getStrEmpty(request.getParameter("actualName"));
        String phoneNumber = StringUtil.getStrEmpty(request.getParameter("phoneNumber"));
        String email = StringUtil.getStrEmpty(request.getParameter("email"));
        String teamName = StringUtil.getStrEmpty(request.getParameter("teamName"));

        log.debug("当前保存的投顾的姓名是 :" + actualName);

        try {
            //查询该投顾编号是否存在
            Boolean flag = this.kamAdvisorService.selectBySerialNumber(serialNumber);

            //根据teamName，查询投顾组
            KamAdvisorTeam team = this.kamAdvisorTeamService.selectByName(teamName);

            // 如果id为空，则是新增，不为空，则为修改
            if (id == 0L && !flag) {
                //构建advisor对象
                KamAdvisor advisor = new KamAdvisor();
                advisor.setTid(team.getId());
                advisor.setSerialNumber(serialNumber);
                advisor.setLevel(level);
                advisor.setSystemName(systemName);
                advisor.setActualName(actualName);
                advisor.setPhoneNumber(phoneNumber);
                advisor.setRemark(email);
                advisor.setCtime(new Date());
                //保存到数据库
                this.kamAdvisorService.save(advisor);
            } else {
                //修改用户，先根据id查询到客户
                KamAdvisor advisor = this.kamAdvisorService.selectByKey(id);
                advisor.setTid(team.getId());
                advisor.setSerialNumber(serialNumber);
                advisor.setLevel(level);
                advisor.setSystemName(systemName);
                advisor.setActualName(actualName);
                advisor.setPhoneNumber(phoneNumber);
                advisor.setRemark(email);
                advisor.setMtime(new Date());
                this.kamAdvisorService.updateNotNull(advisor);
            }
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("保存客户信息失败..." + e.getMessage());
            e.printStackTrace();
        }
        log.debug("返回页面的结果对象：" + result);
        return result;
    }

    /**
     * Excel导入
     *
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "importExcel", method = RequestMethod.POST)
    public AjaxResult importExcel(@RequestParam("fileExcel") CommonsMultipartFile file, HttpServletRequest request) {

        log.debug("该上传excel文件的原文件名是 :" + file.getOriginalFilename());

        AjaxResult result = AjaxResult.success("导入数据成功...");

        if (!file.isEmpty()) {

            //判断请求类型是否为文件上传类型
            if (!ServletFileUpload.isMultipartContent(request)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该请求上传文件失败...");
                return result;
            }

            //当文件超过设置的大小时，则不运行上传
            if (file.getSize() > fileSize) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该上传文件大小超限制...");
                return result;
            }

            //获取文件名后缀
            String OriginalFilename = file.getOriginalFilename();
            String fileSuffix = OriginalFilename.substring(OriginalFilename.lastIndexOf(".") + 1).toLowerCase();
            log.debug("该上传文件的后缀名为 :" + fileSuffix);

            //判断该类型的文件是否在允许上传的文件类型内
            if (!Arrays.asList(TypeMap.get("file").split(",")).contains(fileSuffix)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("请检查上传文件的格式...");
                return result;
            }

            try {
                // 获取Excel对象
                ClExcel excel = ExcelHandlerUtil.getExcelFile(file, request);
                //当前上传用户的id
                excel.setUserId(0L);
                excel.setCtime(new Date());
                result.setObj(excel);

                // 读取excel文件
                String excelType = "kamAdvisor";
                ExcelImportResult readExcel = excelContext.readExcel(excelType, file.getInputStream());
                List<KamAdvisor> listBean = readExcel.getListBean();
                System.out.println("listBean = " + listBean);
                this.kamAdvisorService.importExcelData(listBean);

                // 存储excel文件
                UploadUtil.copy(file, excel.getExcelRealPath(), excel.getExcelRealName());
            } catch (Exception e) {
                result.setCode(AjaxResult.CODE_FAILURE);
                if (e instanceof ExcelException) {
                    result.setMsg(e.getMessage());
                } else {
                    if (e instanceof InvalidFormatException) {
                        result.setMsg("错误的文件格式...");
                    } else {
                        result.setMsg(e.getMessage());
                        e.printStackTrace();
                        log.error(e.getMessage());
                    }
                }
            }
        } else {
            //上传文件为空，或者当前登录用户不是投资顾问，则无权限上传
            result.setCode(AjaxResult.CODE_DENIED);
            result.setMsg("无法上传，请检查该上传文件或您的登录账户权限！");
        }

        System.out.println("返回页面的结果对象为result = " + result);
        return result;
    }

    /**
     * 条件查询导出excel文件
     * 或导出excel模板
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "exportExcel", method = RequestMethod.POST)
    public ModelAndView exportExcel(HttpServletRequest request) {
        ModelAndView mv = null;
        try {
            //根据条件获取要导出的数据集合
            String search = StringUtil.getStrEmpty(request.getParameter("search"));
            log.debug("search:" + search);

            //xml配置中的ID
            String id = "advisorInfoBean";
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();
            //excel文件名称,不需要任何后缀
            String excelName = "Advisor_Export_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);;

            //导出数据的表格
            List<AdvisorInfoBean> list = this.kamAdvisorService.findBySearch(search);

            specifyFields.add("serialNumber");
            specifyFields.add("level");
            specifyFields.add("systemName");
            specifyFields.add("actualName");
            specifyFields.add("phoneNumber");
            specifyFields.add("email");
            specifyFields.add("teamName");
            specifyFields.add("teamLeaderName");
            specifyFields.add("totalNumber");
            specifyFields.add("area");
            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
