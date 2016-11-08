package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.model.KamExtUserUpload;
import org.blazer.bigclient.model.KamUserInfo;
import org.blazer.bigclient.service.KamUserInfoService;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.LongUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by yyccb on 2016-10-11.
 */
@RequestMapping("/user")
@Controller
public class KamUserInfoController extends BaseController {

    /*private static final Logger LOGGER = LoggerFactory.getLogger(KamUserInfoController.class);

    @Autowired
    private KamUserInfoService kamUserInfoService;



    *//**
     * 根据搜索条件分页查询
     *
     * @param request
     * @param response
     * @return
     *//*
    @ResponseBody
    @RequestMapping("/findUserByPage")
    public PageInfo<KamUserInfo> findUserByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取前台传递过来的参数
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));

        //获取当前登录用户
        KamAdvisor advisor = super.getCurrentUser(request);

        //判断当前登录用户如果为投顾,则添加投顾真实姓名作为查询参数
        if (advisor != null) {
            params.put("advisorName",advisor.getActualName());
        }
        return kamUserInfoService.findUserByPage(params);
    }


    *//**外部拓展客户*//*

    *//**
     * 保存单个用户
     *
     * @param request
     * @return
     *//*
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

                kamUserInfo.setIfReportOrAllot(0);
                kamUserInfo.setUserIdentify("DHK0000");



                kamUserInfo.setCtime(new Date());
                //构建KamExtUserUpload对象
                KamExtUserUpload kamExtUserUpload = new KamExtUserUpload();
                //当excelId为0时，则说明该条记录不是excel导入，是手动单条添加的。
                kamExtUserUpload.setExcelId(kamUserInfo.getExcelId());
                kamExtUserUpload.setPhoneNumber(kamUserInfo.getPhoneNumber());
                kamExtUserUpload.setCtime(kamUserInfo.getCtime());
                //保存到数据库
//                int num = this.kamUserInfoService.saveUserToTwo(kamUserInfo, kamExtUserUpload);
//                if (num < 0) {
//                    result.setCode(AjaxResult.CODE_FAILURE);
//                    result.setMsg("保存用户信息失败！");
//                }
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




    *//**平台待分配客户*//*





    *//**正式客户*//*

    *//**
     * 根据搜索条件分页查询
     *
     * @param request
     * @param response
     * @return
     *//*
    @ResponseBody
    @RequestMapping("formal/findByPage")
    public PageInfo<KamUserInfo> findByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取前台传递过来的参数
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")) +
                ", dateStart:" + StringUtil.getStrEmpty(params.get("dateStart")) +
                ", dateEnd:" + StringUtil.getStrEmpty(params.get("dateEnd")));

        //获取当前登录用户
        KamAdvisor advisor = super.getCurrentUser(request);

        //判断当前登录用户如果为投顾,则添加投顾真实姓名作为查询参数
        if (advisor != null) {
            params.put("advisorName",advisor.getActualName());
        }
        return kamUserInfoService.findByPage(params);
    }

*/

}
