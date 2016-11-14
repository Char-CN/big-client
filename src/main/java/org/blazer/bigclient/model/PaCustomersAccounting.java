package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

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
     * 投资顾问
     */
    @Column(name = "investment_adviser")
    private String investmentAdviser;

    /**
     * 客户标识
     */
    @Column(name = "user_identify")
    private String userIdentify;

    /**
     * 是否业绩池（0：不计入，1：计入）
     */
    @Column(name = "if_performance_pool")
    private Integer ifPerformancePool;

    /**
     * 期末AUM（资产总额 as a）
     */
    @Column(name = "ending_balance")
    private String endingBalance;

    /**
     * 期末不小于50万（0：不符合条件，1：符合条件）
     */
    @Column(name = "ending_not_less_than_fifty")
    private Integer endingNotLessThanFifty;

    /**
     * 投资总额（当月定期投资+活期申购  as b）
     */
    @Column(name = "buy_amount")
    private String buyAmount;

    /**
     * 期初AUM（= a - b） as c
     */
    @Column(name = "beginning_balance")
    private String beginningBalance;

    /**
     * 期初不大于50万（0：不符合条件，1：符合条件）
     */
    @Column(name = "beginning_no_greater_than_fifty")
    private Integer beginningNoGreaterThanFifty;

    /**
     * 匹配期初值（上月期初值  as d）
     */
    @Column(name = "matching_period_initial_value")
    private String matchingPeriodInitialValue;

    /**
     * 期初对比(c = d ? TRUE or FALSE)
     */
    @Column(name = "beginning_comparison")
    private String beginningComparison;

    /**
     * 差异(c - d 有可能负数)
     */
    private String difference;

    /**
     * 兑付单（关联定期兑付报表）
     */
    @Column(name = "redemption_order")
    private String redemptionOrder;

    /**
     * 修正（TRUE or FALSE）
     */
    private String revise;

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
     * 获取客户姓名
     *
     * @return user_name - 客户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置客户姓名
     *
     * @param userName 客户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取手机号码
     *
     * @return phone_number - 手机号码
     */
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号码
     *
     * @param phoneNumber 手机号码
     */
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取注册日期
     *
     * @return register_date - 注册日期
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * 设置注册日期
     *
     * @param registerDate 注册日期
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * 获取投资顾问
     *
     * @return investment_adviser - 投资顾问
     */
    public String getInvestmentAdviser() {
        return investmentAdviser;
    }

    /**
     * 设置投资顾问
     *
     * @param investmentAdviser 投资顾问
     */
    public void setInvestmentAdviser(String investmentAdviser) {
        this.investmentAdviser = investmentAdviser;
    }

    /**
     * 获取客户标识
     *
     * @return user_identify - 客户标识
     */
    public String getUserIdentify() {
        return userIdentify;
    }

    /**
     * 设置客户标识
     *
     * @param userIdentify 客户标识
     */
    public void setUserIdentify(String userIdentify) {
        this.userIdentify = userIdentify;
    }

    /**
     * 获取是否业绩池（0：不计入，1：计入）
     *
     * @return if_performance_pool - 是否业绩池（0：不计入，1：计入）
     */
    public Integer getIfPerformancePool() {
        return ifPerformancePool;
    }

    /**
     * 设置是否业绩池（0：不计入，1：计入）
     *
     * @param ifPerformancePool 是否业绩池（0：不计入，1：计入）
     */
    public void setIfPerformancePool(Integer ifPerformancePool) {
        this.ifPerformancePool = ifPerformancePool;
    }

    /**
     * 获取期末AUM（资产总额 as a）
     *
     * @return ending_balance - 期末AUM（资产总额 as a）
     */
    public String getEndingBalance() {
        return endingBalance;
    }

    /**
     * 设置期末AUM（资产总额 as a）
     *
     * @param endingBalance 期末AUM（资产总额 as a）
     */
    public void setEndingBalance(String endingBalance) {
        this.endingBalance = endingBalance;
    }

    /**
     * 获取期末不小于50万（0：不符合条件，1：符合条件）
     *
     * @return ending_not_less_than_fifty - 期末不小于50万（0：不符合条件，1：符合条件）
     */
    public Integer getEndingNotLessThanFifty() {
        return endingNotLessThanFifty;
    }

    /**
     * 设置期末不小于50万（0：不符合条件，1：符合条件）
     *
     * @param endingNotLessThanFifty 期末不小于50万（0：不符合条件，1：符合条件）
     */
    public void setEndingNotLessThanFifty(Integer endingNotLessThanFifty) {
        this.endingNotLessThanFifty = endingNotLessThanFifty;
    }

    /**
     * 获取投资总额（当月定期投资+活期申购  as b）
     *
     * @return buy_amount - 投资总额（当月定期投资+活期申购  as b）
     */
    public String getBuyAmount() {
        return buyAmount;
    }

    /**
     * 设置投资总额（当月定期投资+活期申购  as b）
     *
     * @param buyAmount 投资总额（当月定期投资+活期申购  as b）
     */
    public void setBuyAmount(String buyAmount) {
        this.buyAmount = buyAmount;
    }

    /**
     * 获取期初AUM（= a - b） as c
     *
     * @return beginning_balance - 期初AUM（= a - b） as c
     */
    public String getBeginningBalance() {
        return beginningBalance;
    }

    /**
     * 设置期初AUM（= a - b） as c
     *
     * @param beginningBalance 期初AUM（= a - b） as c
     */
    public void setBeginningBalance(String beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    /**
     * 获取期初不大于50万（0：不符合条件，1：符合条件）
     *
     * @return beginning_no_greater_than_fifty - 期初不大于50万（0：不符合条件，1：符合条件）
     */
    public Integer getBeginningNoGreaterThanFifty() {
        return beginningNoGreaterThanFifty;
    }

    /**
     * 设置期初不大于50万（0：不符合条件，1：符合条件）
     *
     * @param beginningNoGreaterThanFifty 期初不大于50万（0：不符合条件，1：符合条件）
     */
    public void setBeginningNoGreaterThanFifty(Integer beginningNoGreaterThanFifty) {
        this.beginningNoGreaterThanFifty = beginningNoGreaterThanFifty;
    }

    /**
     * 获取匹配期初值（上月期初值  as d）
     *
     * @return matching_period_initial_value - 匹配期初值（上月期初值  as d）
     */
    public String getMatchingPeriodInitialValue() {
        return matchingPeriodInitialValue;
    }

    /**
     * 设置匹配期初值（上月期初值  as d）
     *
     * @param matchingPeriodInitialValue 匹配期初值（上月期初值  as d）
     */
    public void setMatchingPeriodInitialValue(String matchingPeriodInitialValue) {
        this.matchingPeriodInitialValue = matchingPeriodInitialValue;
    }

    /**
     * 获取期初对比(c = d ? TRUE or FALSE)
     *
     * @return beginning_comparison - 期初对比(c = d ? TRUE or FALSE)
     */
    public String getBeginningComparison() {
        return beginningComparison;
    }

    /**
     * 设置期初对比(c = d ? TRUE or FALSE)
     *
     * @param beginningComparison 期初对比(c = d ? TRUE or FALSE)
     */
    public void setBeginningComparison(String beginningComparison) {
        this.beginningComparison = beginningComparison;
    }

    /**
     * 获取差异(c - d 有可能负数)
     *
     * @return difference - 差异(c - d 有可能负数)
     */
    public String getDifference() {
        return difference;
    }

    /**
     * 设置差异(c - d 有可能负数)
     *
     * @param difference 差异(c - d 有可能负数)
     */
    public void setDifference(String difference) {
        this.difference = difference;
    }

    /**
     * 获取兑付单（关联定期兑付报表）
     *
     * @return redemption_order - 兑付单（关联定期兑付报表）
     */
    public String getRedemptionOrder() {
        return redemptionOrder;
    }

    /**
     * 设置兑付单（关联定期兑付报表）
     *
     * @param redemptionOrder 兑付单（关联定期兑付报表）
     */
    public void setRedemptionOrder(String redemptionOrder) {
        this.redemptionOrder = redemptionOrder;
    }

    /**
     * 获取修正（TRUE or FALSE）
     *
     * @return revise - 修正（TRUE or FALSE）
     */
    public String getRevise() {
        return revise;
    }

    /**
     * 设置修正（TRUE or FALSE）
     *
     * @param revise 修正（TRUE or FALSE）
     */
    public void setRevise(String revise) {
        this.revise = revise;
    }

    /**
     * 获取差错查询（预留字段）
     *
     * @return error_query - 差错查询（预留字段）
     */
    public String getErrorQuery() {
        return errorQuery;
    }

    /**
     * 设置差错查询（预留字段）
     *
     * @param errorQuery 差错查询（预留字段）
     */
    public void setErrorQuery(String errorQuery) {
        this.errorQuery = errorQuery;
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