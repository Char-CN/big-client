package org.blazer.bigclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pr_performance_report")
public class PrPerformanceReport {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 区域
     */
    @OrderBy("desc")
    private String area;

    /**
     * 投顾组
     */
    @OrderBy("desc")
    @Column(name = "team_name")
    private String teamName;

    /**
     * 投顾级别
     */
    @Column(name = "advisor_level")
    private String advisorLevel;

    /**
     * 投资顾问
     */
    @Column(name = "investment_advisor")
    private String investmentAdvisor;

    /**
     * 当前vip客户数(人数)
     */
    @Column(name = "current_vip_customers_number")
    private Integer currentVipCustomersNumber;

    /**
     * 计入业绩客户AUM值（亿元）
     */
    @Column(name = "performance_customers_aum")
    private Double performanceCustomersAum;

    /**
     * 计入业绩客户数（人数）
     */
    @Column(name = "performance_customers_number")
    private Integer performanceCustomersNumber;

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
     * 本月定期销售规模（万元）
     */
    @Column(name = "monthly_regular_sales_scale")
    private Double monthlyRegularSalesScale;

    /**
     * 本月活期申购额折算后(万元) 
     */
    @Column(name = "monthly_current_sales_scale_conversion")
    private Double monthlyCurrentSalesScaleConversion;

    /**
     * 本月活包定申购额折算后（万元）
     */
    @Column(name = "monthly_cpr_sales_scale_conversion")
    private Double monthlyCprSalesScaleConversion;

    /**
     * 当前销售规模(万元)
     */
    @Column(name = "monthly_sales_scale")
    private Double monthlySalesScale;

    /**
     * 月销售规模业绩目标(万元)
     */
    @Column(name = "monthly_sales_scale_performance_targets")
    private Integer monthlySalesScalePerformanceTargets;

    /**
     * 销售规模完成率
     */
    @Column(name = "sales_completion_rate")
    private String salesCompletionRate;

    /**
     * 小组销售规模(万元)
     */
    @Column(name = "team_sales_scale")
    private Double teamSalesScale;

    /**
     * 本月获客数(折算)
     */
    @Column(name = "monthly_get_customers_number")
    private Integer monthlyGetCustomersNumber;

    /**
     * 月度获客业绩目标(折算)
     */
    @Column(name = "monthly_get_customers_target")
    private Integer monthlyGetCustomersTarget;

    /**
     * 获客完成率
     */
    @Column(name = "get_customers_completion_rate")
    private String getCustomersCompletionRate;

    /**
     * 小组获客数量(折算)
     */
    @Column(name = "team_get_customers_number")
    private Integer teamGetCustomersNumber;

    /**
     * 综合完成率
     */
    @Column(name = "comprehensive_completion_rate")
    private String comprehensiveCompletionRate;

    /**
     * 综合完成率排名
     */
    @Column(name = "comprehensive_completion_rate_ranking")
    private Integer comprehensiveCompletionRateRanking;

    /**
     * 小组综合完成率
     */
    @Column(name = "team_comprehensive_completion_rate")
    private String teamComprehensiveCompletionRate;

    /**
     * 版本（格式为年月 201612、201701）
     */
    private Integer version;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;

}