package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.excel.ExcelException;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.excel.vo.ExcelImportResult;
import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.model.KamExcel;
import org.blazer.bigclient.model.KamExtUserUpload;
import org.blazer.bigclient.service.KamExcelService;
import org.blazer.bigclient.service.KamExtUserUploadService;
import org.blazer.bigclient.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by yyccb on 2016-10-28.
 */
@RequestMapping("/extUserUpload")
@Controller
public class KamExtUserUploadController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KamExtUserUploadController.class);

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
    private KamExtUserUploadService kamExtUserUploadService;

    @Autowired
    private KamExcelService kamExcelService;

    /**
     * 根据搜索条件分页查询
     * 添加了投顾权限控制
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findByPage")
    public PageInfo<KamExtUserUpload> findByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取前台传递过来的参数
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));

        //获取当前登录用户
        KamAdvisor advisor = super.getCurrentUser(request);
        System.out.println("当前登录用户: advisor = " + advisor);

        //判断当前登录用户如果为投顾,则添加投顾真实姓名作为查询参数
        if (advisor != null) {
            params.put("advisorName", advisor.getActualName());
        }

        return kamExtUserUploadService.findByPage(params);
    }


    /**
     * 单个保存
     *
     * @param request
     * @return
     */
/*    @ResponseBody
    @RequestMapping(value = "saveOne", method = RequestMethod.POST)
    public AjaxResult saveOne(HttpServletRequest request) {
        AjaxResult result = AjaxResult.success("保存用户成功。。。");
        //获取前台页面传递的参数
        Long id = LongUtil.getLongZero(request.getParameter("id"));
        String phoneNumber = StringUtil.getStrEmpty(request.getParameter("phoneNumber"));
        LOGGER.debug("正在保存的用户手机号是 :" + phoneNumber);
        String sysName = StringUtil.getStrEmpty(request.getParameter("sysName"));
        String sysIfRegister = StringUtil.getStrEmpty(request.getParameter("sysIfRegister"));
        String sysRegisterDate = StringUtil.getStrEmpty(request.getParameter("sysRegisterDate"));
        String sysIfRealName = StringUtil.getStrEmpty(request.getParameter("sysIfRealName"));
        String sysIfBindCard = StringUtil.getStrEmpty(request.getParameter("sysIfBindCard"));
        String sysIfTransaction = StringUtil.getStrEmpty(request.getParameter("sysIfTransaction"));
        String sysReferrer = StringUtil.getStrEmpty(request.getParameter("sysReferrer"));
        String sysRebateExpirationDate = StringUtil.getStrEmpty(request.getParameter("sysRebateExpirationDate"));

        try {
            //查询该手机号数据库中是否存在
            Boolean flag = this.kamExtUserUploadService.findByPhoneNumber(phoneNumber);
            // 如果id为空，则是新增，不为空，则为修改
            if (id == 0L && !flag) {
                //构建BcExternalUser对象
                KamExtUserUpload user = new KamExtUserUpload();
                user.setExcelId(0L);
                user.setPhoneNumber(Long.parseLong(phoneNumber));
                user.setSysName(sysName);
                user.setSysIfRegister(sysIfRegister);
                user.setSysRegisterDate(sysRegisterDate);
                user.setSysIfRealName(sysIfRealName);
                user.setSysIfBindCard(sysIfBindCard);
                user.setSysIfTransaction(sysIfTransaction);
                user.setSysReferrer(sysReferrer);
                user.setSysRebateExpirationDate(sysRebateExpirationDate);
                user.setCtime(new Date());
                user.setMtime(user.getCtime());
                //保存到数据库
                int num = this.bcExternalUserService.saveUserToTwo(user, bcExternalUserBackup);
                if (num < 0) {
                    result.setCode(AjaxResult.CODE_FAILURE);
                    result.setMsg("保存用户信息失败！");
                }
            } else {
                //修改用户，先根据id查询到用户
                KamExtUserUpload user = this.kamExtUserUploadService.selectByKey(id);
                user.setSysName(sysName);
                user.setSysIfRegister(sysIfRegister);
                user.setSysRegisterDate(sysRegisterDate);
                user.setSysIfRealName(sysIfRealName);
                user.setSysIfBindCard(sysIfBindCard);
                user.setSysIfTransaction(sysIfTransaction);
                user.setSysReferrer(sysReferrer);
                user.setSysRebateExpirationDate(sysRebateExpirationDate);
                user.setMtime(new Date());
                int num = this.bcExternalUserService.updateNotNull(user);
                if (num < 0) {
                    result.setCode(AjaxResult.CODE_FAILURE);
                    result.setMsg("修改用户信息失败！");
                }
            }
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("保存用户操作失败。。。" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("result = " + result);
        return result;
    }*/


    /**
     * 根据id逻辑删除单个
     *
     * @param request
     * @return
     */
    /*@ResponseBody
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public AjaxResult deleteUserById(HttpServletRequest request) {
        //获取用户id
        Long id = LongUtil.getLongZero(request.getParameter("id"));
        LOGGER.debug("正在被删除的用户id是 :" + id);
        AjaxResult result = AjaxResult.success("删除用户信息成功...");
        try {
            //第一张表删除
            BcExternalUser bcExternalUser = this.bcExternalUserService.selectByKey(id);
            int num1 = this.bcExternalUserService.delete(id);
            //第二张表删除
            BcExternalUserBackup externalUserBackup = new BcExternalUserBackup();
            externalUserBackup.setPhoneNumber(bcExternalUser.getPhoneNumber());
            BcExternalUserBackup bcExternalUserBackup = this.bcExternalUserBackupService.selcetOne(externalUserBackup);
            int num2 = this.bcExternalUserBackupService.delete(bcExternalUserBackup.getId());
            //判断是否成功删除
            if (num1 <= 0 || num2 <= 0) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("在两张表中删除用户失败。。。");
            }
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("删除用户操作失败。。。" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }*/


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

        LOGGER.debug("该上传excel文件的原文件名是 :" + file.getOriginalFilename());
        LOGGER.debug("当前登录用户为 :" + super.getCurrentUserName(request));

        // 获取当前登录用户信息，然后判断权限
        KamAdvisor advisor = super.getCurrentUser(request);
        System.out.println("advisor = " + advisor);

        AjaxResult result = AjaxResult.success("导入数据成功...");

        if (!file.isEmpty() && advisor != null) {

            //判断请求类型是否为文件上传类型
            if (!ServletFileUpload.isMultipartContent(request)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该请求上传文件失败。。。");
                return result;
            }

            //当文件超过设置的大小时，则不运行上传
            if (file.getSize() > fileSize) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该上传文件大小超限制。。。");
                return result;
            }

            //获取文件名后缀
            String OriginalFilename = file.getOriginalFilename();
            String fileSuffix = OriginalFilename.substring(OriginalFilename.lastIndexOf(".") + 1).toLowerCase();
            System.out.println("fileSuffix = " + fileSuffix);

            //判断该类型的文件是否在允许上传的文件类型内
            if (!Arrays.asList(TypeMap.get("file").split(",")).contains(fileSuffix)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("请检查上传文件的格式。。。");
                return result;
            }

            try {
                // 获取Excel对象
                KamExcel excel = ExcelHandlerUtil.getExcelFile(file, request);
                excel.setUserId(advisor.getId());//当前上传用户的id
                excel.setCtime(new Date());
                result.setObj(excel);

                // 读取excel文件
                String excelType = "kamExtUserUpload";
                ExcelImportResult readExcel = excelContext.readExcel(excelType, file.getInputStream());
                List<KamExtUserUpload> listBean = readExcel.getListBean();
                this.kamExtUserUploadService.importExcelData(listBean, excel);

                // 存储excel文件
                UploadUtil.copy(file, excel.getExcelRealPath(), excel.getExcelRealName());
            } catch (Exception e) {
                result.setCode(AjaxResult.CODE_FAILURE);
                if (e instanceof ExcelException) {
                    result.setMsg(e.getMessage());
                } else {
                    if (e instanceof InvalidFormatException) {
                        result.setMsg("错误的文件格式。。。");
                    } else {
                        result.setMsg(e.getMessage());
                        e.printStackTrace();
                        LOGGER.error(e.getMessage());
                    }
                }
            }
        } else {
            //上传文件为空，或者当前登录用户不是投资顾问，则无权限上传
            result.setCode(AjaxResult.CODE_DENIED);
            result.setMsg("无法上传，请检查该上传文件或您的登录账户权限！");
        }

        System.out.println("result = " + result);
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
            String template = StringUtil.getStrEmpty(request.getParameter("template"));
            LOGGER.debug("search:" + search + "，template:" + template);

            //xml配置中的ID
            String id = "kamExtUserUpload";
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();
            //excel文件名称,不需要任何后缀
            String excelName = null;
            // 要导出的数据
            List<KamExtUserUpload> list = new ArrayList<KamExtUserUpload>();

            //下载空模板的判断
            if (StringUtils.isNotEmpty(template) && template.equals("template")) {
                KamExtUserUpload user = new KamExtUserUpload();
                user.setPhoneNumber(13802108888L);
                user.setCustomerName("客户姓名");
                user.setInvestmentAdviser("投资顾问");
                list.add(user);

                excelName = "ExtUserUpload_Template_v1.0";

                specifyFields.add("phoneNumber");
                specifyFields.add("customerName");
                specifyFields.add("investmentAdviser");
            } else {
                //导出数据的表格
                list = kamExtUserUploadService.findBySearch(search);
                excelName = "ExtUserUpload_Export_" + DateUtil.thisDateTime();

                specifyFields.add("phoneNumber");
                specifyFields.add("customerName");
                specifyFields.add("userName");
                specifyFields.add("investmentAdviser");
                specifyFields.add("ifEffective");
                specifyFields.add("remark");
                specifyFields.add("ctime");
            }
            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }


}
