package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.excel.ExcelException;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.excel.vo.ExcelImportResult;
import org.blazer.bigclient.model.BcExcel;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.model.BcExternalUserBackup;
import org.blazer.bigclient.service.BcExternalUserBackupService;
import org.blazer.bigclient.service.BcExternalUserService;
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
 * Created by cuican on 2016-8-26.
 */
@RequestMapping("/ext")
@Controller
public class BcExternalUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcExternalUserController.class);

    @Autowired
    private BcExternalUserService bcExternalUserService;

    @Autowired
    private BcExternalUserBackupService bcExternalUserBackupService;

    //设置文件允许上传的类型
    private static final HashMap<String, String> TypeMap = new HashMap<String, String>();

    static {
        TypeMap.put("image", "gif,jpg,jpeg,png,bmp");
        TypeMap.put("flash", "swf,flv");
        TypeMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        TypeMap.put("file", "doc,docx,xls,xlsx,ppt,pptx,htm,html,txt,dwg,pdf");
    }

    // 设置文件上传大小
    public static long fileSize = 30 * 1024 * 1024;

    /**
     * 根据搜索条件分页查询列表
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("findByPage")
    public PageInfo<BcExternalUser> listAllUserByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return bcExternalUserService.findByPage(params);
    }


    /**
     * 保存单个用户
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addOneUser", method = RequestMethod.POST)
    public AjaxResult addOneUser(HttpServletRequest request) {
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
            Boolean flag = this.bcExternalUserService.findByPhoneNumber(phoneNumber);
            // 如果id为空，则是新增，不为空，则为修改
            if (id == 0L && !flag) {
                //构建BcExternalUser对象
                BcExternalUser bcExternalUser = new BcExternalUser();
                bcExternalUser.setExcelId(0L);
                bcExternalUser.setPhoneNumber(Long.parseLong(phoneNumber));
                bcExternalUser.setSysName(sysName);
                bcExternalUser.setSysIfRegister(sysIfRegister);
                bcExternalUser.setSysRegisterDate(sysRegisterDate);
                bcExternalUser.setSysIfRealName(sysIfRealName);
                bcExternalUser.setSysIfBindCard(sysIfBindCard);
                bcExternalUser.setSysIfTransaction(sysIfTransaction);
                bcExternalUser.setSysReferrer(sysReferrer);
                bcExternalUser.setSysRebateExpirationDate(sysRebateExpirationDate);
                bcExternalUser.setCtime(new Date());
                bcExternalUser.setMtime(bcExternalUser.getCtime());
                //构建BcExternalUserBackup对象
                BcExternalUserBackup bcExternalUserBackup = new BcExternalUserBackup();
                //当excelId为0时，则说明该条记录不是excel导入，是手动单条添加的。
                bcExternalUserBackup.setExcelId(bcExternalUser.getExcelId());
                bcExternalUserBackup.setPhoneNumber(Long.parseLong(phoneNumber));
                bcExternalUserBackup.setCtime(bcExternalUser.getCtime());
                bcExternalUserBackup.setMtime(bcExternalUserBackup.getCtime());
                //保存到数据库
                int num = this.bcExternalUserService.saveUserToTwo(bcExternalUser, bcExternalUserBackup);
                if (num < 0) {
                    result.setCode(AjaxResult.CODE_FAILURE);
                    result.setMsg("保存用户信息失败！");
                }
            } else {
                //修改用户，先根据id查询到用户
                BcExternalUser bcExternalUser = this.bcExternalUserService.selectByKey(id);
                bcExternalUser.setSysName(sysName);
                bcExternalUser.setSysIfRegister(sysIfRegister);
                bcExternalUser.setSysRegisterDate(sysRegisterDate);
                bcExternalUser.setSysIfRealName(sysIfRealName);
                bcExternalUser.setSysIfBindCard(sysIfBindCard);
                bcExternalUser.setSysIfTransaction(sysIfTransaction);
                bcExternalUser.setSysReferrer(sysReferrer);
                bcExternalUser.setSysRebateExpirationDate(sysRebateExpirationDate);
                bcExternalUser.setMtime(new Date());
                int num = this.bcExternalUserService.updateNotNull(bcExternalUser);
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
    }

    /**
     * 根据id查询单个用户信息
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectOneById")
    public AjaxResult selectOneById(HttpServletRequest request) {
        //获取用户id
        Long id = LongUtil.getLongZero(request.getParameter("id"));
        LOGGER.debug("当前查询的用户的ID编号是 :" + id);
        AjaxResult result = AjaxResult.success("查询单个用户信息成功。。。");
        try {
            //查询数据库
            BcExternalUser bcExternalUser = this.bcExternalUserService.selectByKey(id);
            result.setObj(bcExternalUser);
            if (bcExternalUser == null) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该用户信息不存在。。。");
            }
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("查询用户操作失败。。。" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("result = " + result);
        return result;
    }


    /**
     * 根据id删除单个用户
     *
     * @param request
     * @return
     */
    @ResponseBody
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
    }


    /**
     * Excel导入
     *
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public AjaxResult importExcel(@RequestParam("fileExcel") CommonsMultipartFile file, HttpServletRequest request) {

        LOGGER.debug("该上传的excel文件的原文件名是 :" + file.getOriginalFilename());

        AjaxResult result = AjaxResult.success("导入数据成功...");

	/*	User loginUser = (User) request.getSession().getAttribute("loginUser");
        // 判断SESSION是否失效
		if (loginUser == null || "".equals(loginUser)) {
			return "250";
		}
		int loginUserId = loginUser.getUserId();*/

        if (!file.isEmpty()) {

            //判断请求类型是否为文件上传类型
            if (!ServletFileUpload.isMultipartContent(request)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该请求上传文件失败，请联系技术支持。。。");
                return result;
            }

            //当文件超过设置的大小时，则不运行上传
            if (file.getSize() > fileSize) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该文件大小超限制，请更换较小的文件重新上传。。。");
                return result;
            }

            //获取文件名后缀
            String OriginalFilename = file.getOriginalFilename();
            String fileSuffix = OriginalFilename.substring(OriginalFilename.lastIndexOf(".") + 1).toLowerCase();
            System.out.println("fileSuffix = " + fileSuffix);

            //判断该类型的文件是否在允许上传的文件类型内
            Arrays.asList();
            if (!Arrays.asList(TypeMap.get("file").split(",")).contains(fileSuffix)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("请检查上传的Excle文件的格式是否正确。。。");
                return result;
            }

            try {
//                // 获取BcExcel对象
//                BcExcel bcExcel = ExcelHandlerUtil.getExcelFile(file, request);
//                bcExcel.setServiceId(1);
//                bcExcel.setUserId(1L);
//                bcExcel.setMtime(new Date());
//                bcExcel.setCtime(bcExcel.getMtime());
//                System.out.println("bcExcel = " + bcExcel);
//
//                result.setObj(bcExcel);
//
//                // 读取excel文件
//                String excelType = "bcExternalUserBackup";
//                ExcelImportResult readExcel = excelContext.readExcel(excelType, file.getInputStream());
//                List<BcExternalUserBackup> listBean = readExcel.getListBean();
//                bcExternalUserBackupService.importExcelData(listBean, bcExcel);
//
//                // 上传文件
//                UploadUtil.copy(file, bcExcel.getExcelRealPath(), bcExcel.getExcelRealName());
            } catch (Exception e) {
                result.setCode(AjaxResult.CODE_FAILURE);
                if (e instanceof ExcelException) {
                    result.setMsg(e.getMessage());
                } else {
                    if (e instanceof InvalidFormatException) {
                        result.setMsg("错误的文件格式。。。");
                    }
                    result.setMsg(e.getMessage());
                    e.printStackTrace();
                    LOGGER.error(e.getMessage());
                }
            }
        }

        System.out.println("result = " + result);
        return result;
    }

    /**
     * 根据查询条件导出excel文件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "export/excel", method = RequestMethod.POST)
    public ModelAndView exportExcel(HttpServletRequest request) {
        ModelAndView mv = null;

        try {
            //根据条件获取要导出的数据集合
            String search = StringUtil.getStrEmpty(request.getParameter("search"));
            LOGGER.debug("search:" + search);
            List<BcExternalUser> list = bcExternalUserService.findBySearch(search);
            //xml配置中的ID
            String id = "bcExternalUser";
            //excel文件名称,不需要任何后缀
            String excelName = "ExternalUser_Export_" + DateUtil.thisDateTime();
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();
            specifyFields.add("phoneNumber");
            specifyFields.add("sysName");
            specifyFields.add("sysIfRegister");
            specifyFields.add("sysRegisterDate");
            specifyFields.add("sysIfRealName");
            specifyFields.add("sysIfBindCard");
            specifyFields.add("sysIfTransaction");
            specifyFields.add("sysReferrer");
            specifyFields.add("sysRebateExpirationDate");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }


}
