package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.PrPerformanceReport;
import org.blazer.bigclient.service.PrPerformanceReportService;
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
 * Created by cuican on 2016-11-21.
 */
@RequestMapping("/pr/performance_report")
@Controller
public class PrPerformanceReportController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrPerformanceReportController.class);

    @Autowired
    private PrPerformanceReportService prPerformanceReportService;

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
    public PageInfo<PrPerformanceReport> findByPage(HttpServletRequest request, HttpServletResponse response) {
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
        return this.prPerformanceReportService.findByPage(params);
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
            LOGGER.debug("查询条件---search:" + search);

            //xml配置中的ID
            String id = "paRegularSalesScaleAccounting";
            // 要导出的数据
            List<PrPerformanceReport> list = this.prPerformanceReportService.findBySearch(search);
            if (list == null || list.size() == 0) {
                PrPerformanceReport performanceReport = new PrPerformanceReport();
                performanceReport.setInvestmentAdvisor("测试姓名");
                list.add(performanceReport);
            }
            //excel文件名称,不需要任何后缀
            String excelName = "RegularSalesScaleAccounting_Export_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();
            /*<field name="id" title="自动编号"/>
            <field name="advisorLevel" title="投顾级别"/>
            <field name="investmentAdvisor" title="投顾姓名"/>
            <field name="currentVipCustomersNumber" title="当前vip客户数（人数）"/>
            <field name="performanceCustomersAum" title="计入业绩客户AUM值（亿元）"/>
            <field name="performanceCustomersNumber" title="计入业绩客户数（人数）"/>
            <field name="reportedCustomersRegisteredGrowthRate" title="上报客户数注册增长率"/>
            <field name="reportedCustomersTransactionsGrowthRate" title="上报客户交易数增长率"/>
            <field name="lastMonthSalesScale" title="上月销售规模（万元）"/>
            <field name="monthlySalesScale" title="月销售规模（万元）"/>
            <field name="monthlySalesScalePerformanceTargets" title="月销售规模业绩目标（万元）"/>
            <field name="salesCompletionRate" title="销售规模完成率"/>
            <field name="monthlyNumberOfGetCustomers" title="月获客数（折算）"/>
            <field name="monthlyAcquisitionTarget" title="月度获客目标（折算）"/>
            <field name="getCustomersCompletionRate" title="获客完成率"/>
            <field name="comprehensiveCompletionRate" title="综合完成率"/>
            <field name="comprehensiveCompletionRateRanking" title="综合完成率排名"/>
            <field name="teamComprehensiveCompletionRate" title="投资组综合完成率"/>
            <field name="mtime" title="更新时间" pattern="yyyy-MM-dd HH:mm:ss"/>
            <field name="ctime" title="创建时间" pattern="yyyy-MM-dd HH:mm:ss"/>*/
            specifyFields.add("userName");
            specifyFields.add("phoneNumber");
            specifyFields.add("referrer");
            specifyFields.add("rebateExpirationDate");
            specifyFields.add("reportOrAllot");
            specifyFields.add("reportOrAllotDate");
            specifyFields.add("investmentAdviser");
            specifyFields.add("userIdentify");
            specifyFields.add("basicProductName");
            specifyFields.add("investmentAmount");
            specifyFields.add("regularAssetsTotal");
            specifyFields.add("investmentDate");
            specifyFields.add("partitionCoefficient");
            specifyFields.add("performancePoolCoefficient");
            specifyFields.add("productCoefficient");
            specifyFields.add("effectiveSalesAmount");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
