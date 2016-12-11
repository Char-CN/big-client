package org.blazer.bigclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa_customers_accounting")
public class PaCustomersAccounting {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 客户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    private Long phoneNumber;

    /**
     * 注册日期
     */
    @Column(name = "register_date")
    private String registerDate;

    /**
     * 期末AUM
     */
    @Column(name = "ending_balance")
    private String endingBalance;

    /**
     * 期末AUM时间点
     */
    @Column(name = "ending_balance_time_point")
    private String endingBalanceTimePoint;

    /**
     * 期末不小于50万系数（0：不符合条件，1：符合条件）
     */
    @Column(name = "ending_not_less_than_fifty")
    private Integer endingNotLessThanFifty;

    /**
     * 投资顾问
     */
    @Column(name = "investment_adviser")
    private String investmentAdviser;

    /**
     * 投资金额
     */
    @Column(name = "buy_amount")
    private String buyAmount;

    /**
     * 本期兑付金额
     */
    @Column(name = "current_amount_paid")
    private String currentAmountPaid;

    /**
     * 期初AUM
     */
    @Column(name = "beginning_balance")
    private String beginningBalance;

    /**
     * 期初AUM时间点
     */
    @Column(name = "beginning_balance_time_point")
    private String beginningBalanceTimePoint;

    /**
     * 期初不大于50万系数（0：不符合条件，1：符合条件）
     */
    @Column(name = "beginning_no_greater_than_fifty")
    private Integer beginningNoGreaterThanFifty;

    /**
     * 客户标识
     */
    @Column(name = "user_identify")
    private String userIdentify;

    /**
     * 业绩池系数（0：不计入，1：计入）
     */
    @Column(name = "if_performance_pool")
    private Integer ifPerformancePool;

    /**
     * 投顾获客
     */
    @Column(name = "advisor_get_customers")
    private Integer advisorGetCustomers;

    /**
     * 比对历史获客（投顾）
     */
    @Column(name = "comparison_historical_advisor")
    private Integer comparisonHistoricalAdvisor;

    /**
     * 投顾获客去重
     */
    @Column(name = "advisor_get_customers_remove_duplicates")
    private Integer advisorGetCustomersRemoveDuplicates;

    /**
     * 中心获客
     */
    @Column(name = "center_for_customers")
    private Integer centerForCustomers;

    /**
     * 比对历史获客（中心）
     */
    @Column(name = "comparison_historical_center")
    private Integer comparisonHistoricalCenter;

    /**
     * 中心获客去重
     */
    @Column(name = "center_for_customers_remove_duplicates")
    private Integer centerForCustomersRemoveDuplicates;

    /**
     * 差错查询（预留字段）
     */
    @Column(name = "error_query")
    private String errorQuery;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;


}