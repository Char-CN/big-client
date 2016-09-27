package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.BcWaitAllotUser;
import org.blazer.bigclient.service.BcWaitAllotUserService;
import org.blazer.bigclient.util.DateUtil;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by cuican on 2016-9-27.
 */
@RequestMapping("/wait")
@Controller
public class BcWaitAllotUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcWaitAllotUserController.class);

    @Autowired
    private BcWaitAllotUserService bcWaitAllotUserService;

    /**
     * 根据搜索条件分页查询列表
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("findByPage")
    public PageInfo<BcWaitAllotUser> listAllUserByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return bcWaitAllotUserService.findByPage(params);
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
        AjaxResult result = AjaxResult.success("保存用户信息成功。。。");
        //获取前台页面传递的参数
        Long id = LongUtil.getLongZero(request.getParameter("id"));
        String userName = StringUtil.getStrEmpty(request.getParameter("userName"));
        String phoneNumber = StringUtil.getStrEmpty(request.getParameter("phoneNumber"));
        LOGGER.debug("正在保存的用户手机号是 :" + phoneNumber);
        String registerDate = StringUtil.getStrEmpty(request.getParameter("registerDate"));
        String idCard = StringUtil.getStrEmpty(request.getParameter("idCard"));
        String ifEmployee = StringUtil.getStrEmpty(request.getParameter("ifEmployee"));
        String assetsAmount = StringUtil.getStrEmpty(request.getParameter("assetsAmount"));
        String sex = StringUtil.getStrEmpty(request.getParameter("sex"));
        String age = StringUtil.getStrEmpty(request.getParameter("age"));
        String birthday = StringUtil.getStrEmpty(request.getParameter("birthday"));
        String referrer = StringUtil.getStrEmpty(request.getParameter("referrer"));
        String referrerPhoneNumber = StringUtil.getStrEmpty(request.getParameter("referrerPhoneNumber"));
        String ifReferrerEmployee = StringUtil.getStrEmpty(request.getParameter("ifReferrerEmployee"));

        try {
            //分配用户只提供修改
            if (id != 0L) {
                //修改用户，先根据id查询到用户,手机号不允许修改
                BcWaitAllotUser user = this.bcWaitAllotUserService.selectByKey(id);
                user.setUserName(userName);
                user.setRegisterDate(registerDate);
                user.setIdCard(idCard);
                user.setIfEmployee(ifEmployee);
                user.setAssetsAmount(assetsAmount);
                user.setSex(sex);
                user.setAge(age);
                user.setBirthday(birthday);
                user.setReferrer(referrer);
                user.setReferrerPhoneNumber(referrerPhoneNumber);
                user.setIfReferrerEmployee(ifReferrerEmployee);
                int num = this.bcWaitAllotUserService.updateNotNull(user);
                if (num <= 0) {
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
        AjaxResult result = AjaxResult.success("删除用户信息成功！");
        try {
            int num = this.bcWaitAllotUserService.delete(id);
            //判断是否成功删除
            if (num <= 0) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("删除用户信息失败！");
            }
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("删除用户操作失败。。。" + e.getMessage());
            e.printStackTrace();
        }
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
            List<BcWaitAllotUser> list = bcWaitAllotUserService.findBySearch(search);
            //xml配置中的ID
            String id = "bcWaitAllotUser";
            //excel文件名称,不需要任何后缀
            String excelName = "BcWaitAllotUser_Export_" + DateUtil.thisDateTime();
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();

            specifyFields.add("userName");
            specifyFields.add("phoneNumber");
            specifyFields.add("registerDate");
            specifyFields.add("idCard");
            specifyFields.add("ifEmployee");
            specifyFields.add("assetsAmount");
            specifyFields.add("sex");
            specifyFields.add("age");
            specifyFields.add("birthday");
            specifyFields.add("referrer");
            specifyFields.add("referrerPhoneNumber");
            specifyFields.add("ifReferrerEmployee");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }


}
