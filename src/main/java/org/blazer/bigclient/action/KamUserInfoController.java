package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.excel.ExcelException;
import org.blazer.bigclient.excel.vo.ExcelImportResult;
import org.blazer.bigclient.model.KamExcel;
import org.blazer.bigclient.model.KamExtUserUpload;
import org.blazer.bigclient.model.KamUserInfo;
import org.blazer.bigclient.service.KamExtUserUploadService;
import org.blazer.bigclient.service.KamUserInfoService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yyccb on 2016-10-11.
 */
@RequestMapping("/user")
@Controller
public class KamUserInfoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KamUserInfoController.class);

    @Autowired
    private KamUserInfoService kamUserInfoService;

    @Autowired
    private KamExtUserUploadService kamExtUserUploadService;

    //设置文件允许上传的类型
    private static final HashMap<String, String> TypeMap = new HashMap<String, String>();

    static {
        TypeMap.put("image", "gif,jpg,jpeg,png,bmp");
        TypeMap.put("flash", "swf,flv");
        TypeMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        TypeMap.put("file", "doc,docx,xls,xlsx,ppt,pptx,htm,html,txt,dwg,pdf");
    }

    // 设置文件上传大小
    public static long fileSize = 50 * 1024 * 1024;



    /**
     * 根据搜索条件分页查询
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findUserByPage")
    public PageInfo<KamUserInfo> findUserByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return kamUserInfoService.findUserByPage(params);
    }


    /**外部拓展客户*/

    /**
     * 保存单个用户
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ext/addOneUser", method = RequestMethod.POST)
    public AjaxResult addOneUser(HttpServletRequest request) {
        AjaxResult result = AjaxResult.success("保存用户成功。。。");
        //获取前台页面传递的参数
        Long id = LongUtil.getLongZero(request.getParameter("id"));
        String phoneNumber = StringUtil.getStrEmpty(request.getParameter("phoneNumber"));
        LOGGER.debug("正在保存的用户手机号是 :" + phoneNumber);
        String investmentAdviser = StringUtil.getStrEmpty(request.getParameter("investmentAdviser"));
        String userName = StringUtil.getStrEmpty(request.getParameter("userName"));
        String ifRegister = StringUtil.getStrEmpty(request.getParameter("ifRegister"));
        String registerDate = StringUtil.getStrEmpty(request.getParameter("registerDate"));
        String ifRealName = StringUtil.getStrEmpty(request.getParameter("ifRealName"));
        String ifBindCard = StringUtil.getStrEmpty(request.getParameter("ifBindCard"));
        String ifTransaction = StringUtil.getStrEmpty(request.getParameter("ifTransaction"));
        String referrer = StringUtil.getStrEmpty(request.getParameter("referrer"));

        try {
            //查询该手机号数据库中是否存在
            Boolean flag = this.kamUserInfoService.findByPhoneNumber(phoneNumber);
            // 如果id为空，则是新增，不为空，则为修改
            if (id == 0L && !flag) {
                //构建BcExternalUser对象
                KamUserInfo kamUserInfo = new KamUserInfo();
                kamUserInfo.setExcelId(0L);//0为手动添加
                kamUserInfo.setPhoneNumber(Long.parseLong(phoneNumber));
                kamUserInfo.setInvestmentAdviser(investmentAdviser);
                kamUserInfo.setUserName(userName);
                kamUserInfo.setIfRegister(ifRegister);
                kamUserInfo.setRegisterDate(registerDate);
                kamUserInfo.setIfRealName(ifRealName);
                kamUserInfo.setIfBindCard(ifBindCard);
                kamUserInfo.setIfTransaction(ifTransaction);
                kamUserInfo.setReferrer(referrer);
                kamUserInfo.setCtime(new Date());
                //构建KamExtUserUpload对象
                KamExtUserUpload kamExtUserUpload = new KamExtUserUpload();
                //当excelId为0时，则说明该条记录不是excel导入，是手动单条添加的。
                kamExtUserUpload.setExcelId(kamUserInfo.getExcelId());
                kamExtUserUpload.setPhoneNumber(kamUserInfo.getPhoneNumber());
                kamExtUserUpload.setCtime(kamUserInfo.getCtime());
                //保存到数据库
                int num = this.kamUserInfoService.saveUserToTwo(kamUserInfo, kamExtUserUpload);
                if (num < 0) {
                    result.setCode(AjaxResult.CODE_FAILURE);
                    result.setMsg("保存用户信息失败！");
                }
            } else {
                //修改用户，先根据id查询到用户
                KamUserInfo kamUserInfo = this.kamUserInfoService.selectByKey(id);
                kamUserInfo.setInvestmentAdviser(investmentAdviser);
                kamUserInfo.setUserName(userName);
                kamUserInfo.setIfRegister(ifRegister);
                kamUserInfo.setRegisterDate(registerDate);
                kamUserInfo.setIfRealName(ifRealName);
                kamUserInfo.setIfBindCard(ifBindCard);
                kamUserInfo.setIfTransaction(ifTransaction);
                kamUserInfo.setReferrer(referrer);
                kamUserInfo.setMtime(new Date());
                int num = this.kamUserInfoService.updateNotNull(kamUserInfo);
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
     * Excel导入
     *
     * @param file
     * @param request
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "upload", method = RequestMethod.POST)
//    public AjaxResult importExcel(@RequestParam("fileExcel") CommonsMultipartFile file, HttpServletRequest request) {
//
//        LOGGER.debug("该上传的excel文件的原文件名是 :" + file.getOriginalFilename());
//
//        AjaxResult result = AjaxResult.success("导入数据成功...");
//
//	/*	User loginUser = (User) request.getSession().getAttribute("loginUser");
//        // 判断SESSION是否失效
//		if (loginUser == null || "".equals(loginUser)) {
//			return "250";
//		}
//		int loginUserId = loginUser.getUserId();*/
//
//        if (!file.isEmpty()) {
//
//            //判断请求类型是否为文件上传类型
//            if (!ServletFileUpload.isMultipartContent(request)) {
//                result.setCode(AjaxResult.CODE_FAILURE);
//                result.setMsg("该请求上传文件失败，请联系技术支持。。。");
//                return result;
//            }
//
//            //当文件超过设置的大小时，则不运行上传
//            if (file.getSize() > fileSize) {
//                result.setCode(AjaxResult.CODE_FAILURE);
//                result.setMsg("该文件大小超限制，请更换较小的文件重新上传。。。");
//                return result;
//            }
//
//            //获取文件名后缀
//            String OriginalFilename = file.getOriginalFilename();
//            String fileSuffix = OriginalFilename.substring(OriginalFilename.lastIndexOf(".") + 1).toLowerCase();
//            System.out.println("fileSuffix = " + fileSuffix);
//
//            //判断该类型的文件是否在允许上传的文件类型内
//            Arrays.asList();
//            if (!Arrays.asList(TypeMap.get("file").split(",")).contains(fileSuffix)) {
//                result.setCode(AjaxResult.CODE_FAILURE);
//                result.setMsg("请检查上传的Excle文件的格式是否正确。。。");
//                return result;
//            }
//
//            try {
//                // 获取BcExcel对象
//                KamExcel bcExcel = ExcelHandlerUtil.getExcelFile(file, request);
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
//                List<KamExtUserUpload> listBean = readExcel.getListBean();
//                kamExtUserUploadService.importExcelData(listBean, bcExcel);
//
//                // 上传文件
//                UploadUtil.copy(file, bcExcel.getExcelRealPath(), bcExcel.getExcelRealName());
//            } catch (Exception e) {
//                result.setCode(AjaxResult.CODE_FAILURE);
//                if (e instanceof ExcelException) {
//                    result.setMsg(e.getMessage());
//                } else {
//                    if (e instanceof InvalidFormatException) {
//                        result.setMsg("错误的文件格式。。。");
//                    }
//                    result.setMsg(e.getMessage());
//                    e.printStackTrace();
//                    LOGGER.error(e.getMessage());
//                }
//            }
//        }
//
//        System.out.println("result = " + result);
//        return result;
//    }


    /**平台待分配客户*/





    /**正式客户*/




}
