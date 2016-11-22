package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pr_performance_report")
public class PrPerformanceReport {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 投顾级别
     */
    @Column(name = "advisor_level")
    private String advisorLevel;

    /**
     * 投顾姓名
     */
    @Column(name = "investment_advisor")
    private String investmentAdvisor;

    /**
     * 当前vip客户数（人数）
     */
    @Column(name = "current_vip_customers_number")
    private String currentVipCustomersNumber;

    /**
     * 计入业绩客户AUM值(亿元)
     */
    @Column(name = "performance_customers_AUM")
    private String performanceCustomersAum;

    /**
     * 计入业绩客户数(人数)
     */
    @Column(name = "performance_customers_number")
    private String performanceCustomersNumber;

    /**
     * 上报客户数注册增长率
     */
    @Column(name = "reported_customers_registered_growth_rate")
    private String reportedCustomersRegisteredGrowthRate;

    /**
     * 上报客户交易数增长率
     */
    @Column(name = "reported_customers_transactions_growth_rate")
    private String reportedCustomersTransactionsGrowthRate;

    /**
     * 上月销售规模(万元)
     */
    @Column(name = "last_month_sales_scale")
    private String lastMonthSalesScale;

    /**
     * 月销售规模(万元)
     */
    @Column(name = "monthly_sales_scale")
    private String monthlySalesScale;

    /**
     * 月销售规模业绩目标(万元)
     */
    @Column(name = "monthly_sales_scale_performance_targets")
    private String monthlySalesScalePerformanceTargets;

    /**
     *  销售规模完成率
     */
    @Column(name = "sales_completion_rate")
    private String salesCompletionRate;

    /**
     * 月获客数(折算)
     */
    @Column(name = "monthly_number_of_get_customers")
    private String monthlyNumberOfGetCustomers;

    /**
     * 月度获客目标(折算)
     */
    @Column(name = "monthly_acquisition_target")
    private String monthlyAcquisitionTarget;

    /**
     * 获客完成率
     */
    @Column(name = "get_customers_completion_rate")
    private String getCustomersCompletionRate;

    /**
     * 综合完成率
     */
    @Column(name = "comprehensive_completion_rate")
    private String comprehensiveCompletionRate;

    /**
     * 综合完成率排名
     */
    @Column(name = "comprehensive_completion_rate_ranking")
    private String comprehensiveCompletionRateRanking;

    /**
     * 投资组综合完成率 
     */
    @Column(name = "team_comprehensive_completion_rate")
    private String teamComprehensiveCompletionRate;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 获取自动编号
     *
     * @return id - 自动编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自动编号
     *
     * @param id 自动编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取投顾级别
     *
     * @return advisor_level - 投顾级别
     */
    public String getAdvisorLevel() {
        return advisorLevel;
    }

    /**
     * 设置投顾级别
     *
     * @param advisorLevel 投顾级别
     */
    public void setAdvisorLevel(String advisorLevel) {
        this.advisorLevel = advisorLevel;
    }

    /**
     * 获取投顾姓名
     *
     * @return investment_advisor - 投顾姓名
     */
    public String getInvestmentAdvisor() {
        return investmentAdvisor;
    }

    /**
     * 设置投顾姓名
     *
     * @param investmentAdvisor 投顾姓名
     */
    public void setInvestmentAdvisor(String investmentAdvisor) {
        this.investmentAdvisor = investmentAdvisor;
    }

    /**
     * 获取当前vip客户数（人数）
     *
     * @return current_vip_customers_number - 当前vip客户数（人数）
     */
    public String getCurrentVipCustomersNumber() {
        return currentVipCustomersNumber;
    }

    /**
     * 设置当前vip客户数（人数）
     *
     * @param currentVipCustomersNumber 当前vip客户数（人数）
     */
    public void setCurrentVipCustomersNumber(String currentVipCustomersNumber) {
        this.currentVipCustomersNumber = currentVipCustomersNumber;
    }

    /**
     * 获取计入业绩客户AUM值(亿元)
     *
     * @return performance_customers_AUM - 计入业绩客户AUM值(亿元)
     */
    public String getPerformanceCustomersAum() {
        return performanceCustomersAum;
    }

    /**
     * 设置计入业绩客户AUM值(亿元)
     *
     * @param performanceCustomersAum 计入业绩客户AUM值(亿元)
     */
    public void setPerformanceCustomersAum(String performanceCustomersAum) {
        this.performanceCustomersAum = performanceCustomersAum;
    }

    /**
     * 获取计入业绩客户数(人数)
     *
     * @return performance_customers_number - 计入业绩客户数(人数)
     */
    public String getPerformanceCustomersNumber() {
        return performanceCustomersNumber;
    }

    /**
     * 设置计入业绩客户数(人数)
     *
     * @param performanceCustomersNumber 计入业绩客户数(人数)
     */
    public void setPerformanceCustomersNumber(String performanceCustomersNumber) {
        this.performanceCustomersNumber = performanceCustomersNumber;
    }

    /**
     * 获取上报客户数注册增长率
     *
     * @return reported_customers_registered_growth_rate - 上报客户数注册增长率
     */
    public String getReportedCustomersRegisteredGrowthRate() {
        return reportedCustomersRegisteredGrowthRate;
    }

    /**
     * 设置上报客户数注册增长率
     *
     * @param reportedCustomersRegisteredGrowthRate 上报客户数注册增长率
     */
    public void setReportedCustomersRegisteredGrowthRate(String reportedCustomersRegisteredGrowthRate) {
        this.reportedCustomersRegisteredGrowthRate = reportedCustomersRegisteredGrowthRate;
    }

    /**
     * 获取上报客户交易数增长率
     *
     * @return reported_customers_transactions_growth_rate - 上报客户交易数增长率
     */
    public String getReportedCustomersTransactionsGrowthRate() {
        return reportedCustomersTransactionsGrowthRate;
    }

    /**
     * 设置上报客户交易数增长率
     *
     * @param reportedCustomersTransactionsGrowthRate 上报客户交易数增长率
     */
    public void setReportedCustomersTransactionsGrowthRate(String reportedCustomersTransactionsGrowthRate) {
        this.reportedCustomersTransactionsGrowthRate = reportedCustomersTransactionsGrowthRate;
    }

    /**
     * 获取上月销售规模(万元)
     *
     * @return last_month_sales_scale - 上月销售规模(万元)
     */
    public String getLastMonthSalesScale() {
        return lastMonthSalesScale;
    }

    /**
     * 设置上月销售规模(万元)
     *
     * @param lastMonthSalesScale 上月销售规模(万元)
     */
    public void setLastMonthSalesScale(String lastMonthSalesScale) {
        this.lastMonthSalesScale = lastMonthSalesScale;
    }

    /**
     * 获取月销售规模(万元)
     *
     * @return monthly_sales_scale - 月销售规模(万元)
     */
    public String getMonthlySalesScale() {
        return monthlySalesScale;
    }

    /**
     * 设置月销售规模(万元)
     *
     * @param monthlySalesScale 月销售规模(万元)
     */
    public void setMonthlySalesScale(String monthlySalesScale) {
        this.monthlySalesScale = monthlySalesScale;
    }

    /**
     * 获取月销售规模业绩目标(万元)
     *
     * @return monthly_sales_scale_performance_targets - 月销售规模业绩目标(万元)
     */
    public String getMonthlySalesScalePerformanceTargets() {
        return monthlySalesScalePerformanceTargets;
    }

    /**
     * 设置月销售规模业绩目标(万元)
     *
     * @param monthlySalesScalePerformanceTargets 月销售规模业绩目标(万元)
     */
    public void setMonthlySalesScalePerformanceTargets(String monthlySalesScalePerformanceTargets) {
        this.monthlySalesScalePerformanceTargets = monthlySalesScalePerformanceTargets;
    }

    /**
     * 获取 销售规模完成率
     *
     * @return sales_completion_rate -  销售规模完成率
     */
    public String getSalesCompletionRate() {
        return salesCompletionRate;
    }

    /**
     * 设置 销售规模完成率
     *
     * @param salesCompletionRate  销售规模完成率
     */
    public void setSalesCompletionRate(String salesCompletionRate) {
        this.salesCompletionRate = salesCompletionRate;
    }

    /**
     * 获取月获客数(折算)
     *
     * @return monthly_number_of_get_customers - 月获客数(折算)
     */
    public String getMonthlyNumberOfGetCustomers() {
        return monthlyNumberOfGetCustomers;
    }

    /**
     * 设置月获客数(折算)
     *
     * @param monthlyNumberOfGetCustomers 月获客数(折算)
     */
    public void setMonthlyNumberOfGetCustomers(String monthlyNumberOfGetCustomers) {
        this.monthlyNumberOfGetCustomers = monthlyNumberOfGetCustomers;
    }

    /**
     * 获取月度获客目标(折算)
     *
     * @return monthly_acquisition_target - 月度获客目标(折算)
     */
    public String getMonthlyAcquisitionTarget() {
        return monthlyAcquisitionTarget;
    }

    /**
     * 设置月度获客目标(折算)
     *
     * @param monthlyAcquisitionTarget 月度获客目标(折算)
     */
    public void setMonthlyAcquisitionTarget(String monthlyAcquisitionTarget) {
        this.monthlyAcquisitionTarget = monthlyAcquisitionTarget;
    }

    /**
     * 获取获客完成率
     *
     * @return get_customers_completion_rate - 获客完成率
     */
    public String getGetCustomersCompletionRate() {
        return getCustomersCompletionRate;
    }

    /**
     * 设置获客完成率
     *
     * @param getCustomersCompletionRate 获客完成率
     */
    public void setGetCustomersCompletionRate(String getCustomersCompletionRate) {
        this.getCustomersCompletionRate = getCustomersCompletionRate;
    }

    /**
     * 获取综合完成率
     *
     * @return comprehensive_completion_rate - 综合完成率
     */
    public String getComprehensiveCompletionRate() {
        return comprehensiveCompletionRate;
    }

    /**
     * 设置综合完成率
     *
     * @param comprehensiveCompletionRate 综合完成率
     */
    public void setComprehensiveCompletionRate(String comprehensiveCompletionRate) {
        this.comprehensiveCompletionRate = comprehensiveCompletionRate;
    }

    /**
     * 获取综合完成率排名
     *
     * @return comprehensive_completion_rate_ranking - 综合完成率排名
     */
    public String getComprehensiveCompletionRateRanking() {
        return comprehensiveCompletionRateRanking;
    }

    /**
     * 设置综合完成率排名
     *
     * @param comprehensiveCompletionRateRanking 综合完成率排名
     */
    public void setComprehensiveCompletionRateRanking(String comprehensiveCompletionRateRanking) {
        this.comprehensiveCompletionRateRanking = comprehensiveCompletionRateRanking;
    }

    /**
     * 获取投资组综合完成率 
     *
     * @return team_comprehensive_completion_rate - 投资组综合完成率 
     */
    public String getTeamComprehensiveCompletionRate() {
        return teamComprehensiveCompletionRate;
    }

    /**
     * 设置投资组综合完成率 
     *
     * @param teamComprehensiveCompletionRate 投资组综合完成率 
     */
    public void setTeamComprehensiveCompletionRate(String teamComprehensiveCompletionRate) {
        this.teamComprehensiveCompletionRate = teamComprehensiveCompletionRate;
    }

    /**
     * 获取更新时间
     *
     * @return mtime - 更新时间
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置更新时间
     *
     * @param mtime 更新时间
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取创建时间
     *
     * @return ctime - 创建时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置创建时间
     *
     * @param ctime 创建时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}