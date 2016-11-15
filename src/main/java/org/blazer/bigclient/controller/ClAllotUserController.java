package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.ClAllotUser;
import org.blazer.bigclient.service.ClAllotUserService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-9.
 */
@RequestMapping("/cl/allot/")
@Controller
public class ClAllotUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClAllotUserController.class);

    @Autowired
    private ClAllotUserService clAllotUserService;

    /**
     * 根据搜索条件分页查询
     * 添加了投顾权限控制
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("findByPage")
    public PageInfo<ClAllotUser> findByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取前台传递过来的参数
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));

        /*//获取当前登录用户
        KamAdvisor advisor = super.getCurrentUser(request);

        //判断当前登录用户如果为投顾,则添加投顾真实姓名作为查询参数
        if (advisor != null) {
            params.put("advisorName", advisor.getActualName());
        }*/
        return this.clAllotUserService.findByPage(params);
    }


    /**
     * 修改单个保存
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveOne", method = RequestMethod.POST)
    public AjaxResult saveOne(HttpServletRequest request) {

        AjaxResult result = AjaxResult.success("保存客户成功...");

        //获取前台页面传递的参数
        Long id = LongUtil.getLongZero(request.getParameter("id"));
        String phoneNumber = StringUtil.getStrEmpty(request.getParameter("phoneNumber"));

        LOGGER.debug("当前正要保存客户的手机号是 :" + phoneNumber);

        String customerName = StringUtil.getStrEmpty(request.getParameter("customerName"));
        String investmentAdviser = StringUtil.getStrEmpty(request.getParameter("investmentAdviser"));

        try {
            //修改用户，先根据id查询到客户
            ClAllotUser user = this.clAllotUserService.selectByKey(id);
            user.setInvestmentAdviser(investmentAdviser);
            user.setMtime(new Date());
            this.clAllotUserService.updateNotNull(user);
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("保存客户信息失败..." + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.debug("返回页面的结果对象：" + result);
        return result;
    }


    /**
     * 根据id逻辑删除单个
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
            ClAllotUser clAllotUser = this.clAllotUserService.selectByKey(id);
            clAllotUser.setIfDelete(1);
            this.clAllotUserService.updateNotNull(clAllotUser);
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("删除用户操作失败。。。" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 条件查询导出excel文件
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
            String id = "clAllotUser";
            // 要导出的数据
            List<ClAllotUser> list = this.clAllotUserService.findBySearch(search);
            //excel文件名称,不需要任何后缀
            String excelName = "AllotUser_Export_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();
            specifyFields.add("phoneNumber");
            specifyFields.add("userName");
            specifyFields.add("registerDate");
            specifyFields.add("idCard");
            specifyFields.add("ifEmployee");
            specifyFields.add("assetsAmount");
            specifyFields.add("sex");
            specifyFields.add("age");
            specifyFields.add("birthday");
            specifyFields.add("referrer");
            specifyFields.add("referrerPhoneNumber");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
