package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.body.FormalUserBean;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.ClFormalUser;
import org.blazer.bigclient.service.ClFormalUserService;
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
 * Created by cuican on 2016-11-14.
 */
@RequestMapping("/cl/formal/")
@Controller
public class ClFormalUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClAllotUserController.class);

    @Autowired
    private ClFormalUserService clFormalUserService;

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
    public PageInfo<FormalUserBean> findByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取前台传递过来的参数
        HashMap<String, String> params = getParamMap(request);

        LOGGER.debug("分页条件查询列表--当前页-currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", 每页的行数-pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", 查询条件-search:" + StringUtil.getStrEmpty(params.get("search")) +
                ", 查询历史-history:" + StringUtil.getStrEmpty(params.get("history")) +
                ", 起始时间-dateStart:" + StringUtil.getStrEmpty(params.get("dateStart")) +
                ", 截止时间-dateEnd:" + StringUtil.getStrEmpty(params.get("dateEnd"))+"......");

        /*//获取当前登录用户
        KamAdvisor advisor = super.getCurrentUser(request);

        //判断当前登录用户如果为投顾,则添加投顾真实姓名作为查询参数
        if (advisor != null) {
            params.put("advisorName", advisor.getActualName());
        }*/
        return this.clFormalUserService.findByPage(params);
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

        AjaxResult result = AjaxResult.success("修改客户信息成功...");

        //获取前台页面传递的参数
        Long id = LongUtil.getLongZero(request.getParameter("id"));

        String phoneNumber = StringUtil.getStrEmpty(request.getParameter("phoneNumber"));

        LOGGER.debug("当前修改的客户手机号是 :" + phoneNumber);

        String ifPerformancePool = StringUtil.getStrEmpty(request.getParameter("ifPerformancePool"));

        try {
            //修改用户，先根据id查询到客户
            ClFormalUser user = this.clFormalUserService.selectByKey(id);
            user.setIfPerformancePool(Integer.parseInt(ifPerformancePool));
            user.setMtime(new Date());
            this.clFormalUserService.updateNotNull(user);
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("修改客户信息失败..." + e.getMessage());
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
            ClFormalUser user = this.clFormalUserService.selectByKey(id);
            user.setIfDelete(1);
            this.clFormalUserService.updateNotNull(user);
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("删除客户操作失败。。。" + e.getMessage());
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
            //获取前台传递过来的参数
            HashMap<String, String> params = getParamMap(request);

            LOGGER.debug("Excel导出查询数据列表--当前页-currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                    ", 每页的行数-pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                    ", 查询条件-search:" + StringUtil.getStrEmpty(params.get("search")) +
                    ", 查询历史-history:" + StringUtil.getStrEmpty(params.get("history")) +
                    ", 起始时间-dateStart:" + StringUtil.getStrEmpty(params.get("dateStart")) +
                    ", 截止时间-dateEnd:" + StringUtil.getStrEmpty(params.get("dateEnd"))+"......");

            //xml配置中的ID
            String id = "formalUserBean";
            // 要导出的数据
            List<FormalUserBean> list = this.clFormalUserService.findBySearch(params);
            //excel文件名称,不需要任何后缀
            String excelName = "FormalUser_Export_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<>();
            specifyFields.add("phoneNumber");
            specifyFields.add("reportOrAllot");
            specifyFields.add("reportOrAllotDate");
            specifyFields.add("userIdentify");
            specifyFields.add("investmentAdviser");
            specifyFields.add("versionNo");
            specifyFields.add("startDate");
            specifyFields.add("endDate");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }


}
