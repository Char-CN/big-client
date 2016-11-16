package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.SrRegularSalesDetails;
import org.blazer.bigclient.service.SrRegularSalesDetailsService;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.IntegerUtil;
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
 * Created by cuican on 2016-11-16.
 */
@RequestMapping("/sr/regular_sales_details")
@Controller
public class SrRegularSalesDetailsController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SrAssetsBalanceController.class);

    @Autowired
    private SrRegularSalesDetailsService srRegularSalesDetailsService;

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
    public PageInfo<SrRegularSalesDetails> findByPage(HttpServletRequest request, HttpServletResponse response) {
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
        return this.srRegularSalesDetailsService.findByPage(params);
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
            String id = "srRegularSalesDetails";
            // 要导出的数据
            List<SrRegularSalesDetails> list = this.srRegularSalesDetailsService.findBySearch(search);
            //excel文件名称,不需要任何后缀
            String excelName = "RegularSalesDetails_Export_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();
            /*<field name="id" title="自动编号"/>
                 <field name="userName" title="客户姓名"/>
                 <field name="phoneNumber" title="手机号码"/>
                 <field name="referrer" title="referrer"/>
                 <field name="rebateExpirationDate" title="rebateExpirationDate"/>
                 <field name="reportOrAllot" title="reportOrAllot"/>
                 <field name="reportOrAllotDate" title="reportOrAllotDate"/>
                 <field name="investmentAdviser" title="investmentAdviser"/>
                 <field name="userIdentify" title="userIdentify"/>
                 <field name="basicProductName" title="basicProductName"/>
                 <field name="investmentAmount" title="投资顾问"/>
                 <field name="regularAssetsTotal" title="regularAssetsTotal"/>
                 <field name="investmentDate" title="investmentDate"/>*/
            specifyFields.add("userName");
            specifyFields.add("phoneNumber");
            specifyFields.add("referrer");
            specifyFields.add("rebateExpirationDate");
            specifyFields.add("reportOrAllot");
            specifyFields.add("reportOrAllotDate");
            specifyFields.add("investmentAdviser");
            specifyFields.add("userIdentify");
            specifyFields.add("basicProductName");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
