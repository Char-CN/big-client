package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pa_current_sales_scale_accounting")
public class PaCurrentSalesScaleAccounting {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 投资顾问
     */
    @Column(name = "investment_adviser")
    private String investmentAdviser;

    /**
     * 当月申购金额（万元）
     */
    @Column(name = "monthly_purchase_amount")
    private Double monthlyPurchaseAmount;

    /**
     * 当月申购金额/10（千元）
     */
    @Column(name = "monthly_purchase_amount_10")
    private Double monthlyPurchaseAmount10;

    /**
     * 月投资规模目标（万元）
     */
    @Column(name = "monthly_investment_target")
    private Double monthlyInvestmentTarget;

    /**
     * 当月活期业绩上限（万元）
     */
    @Column(name = "monthly_performance_limit")
    private Double monthlyPerformanceLimit;

    /**
     * 有效活期销售规模（万元）
     */
    @Column(name = "effective_current_sales_scale")
    private Double effectiveCurrentSalesScale;

    /**
     * 递延下月（万元）
     */
    @Column(name = "deferred_next_month")
    private Double deferredNextMonth;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;


    public PaCurrentSalesScaleAccounting() {
    }

    public PaCurrentSalesScaleAccounting(String investmentAdviser, Double monthlyPurchaseAmount, Double monthlyPurchaseAmount10,
                                         Double monthlyInvestmentTarget, Double monthlyPerformanceLimit, Double effectiveCurrentSalesScale,
                                         Double deferredNextMonth, Date mtime, Date ctime) {
        this.investmentAdviser = investmentAdviser;
        this.monthlyPurchaseAmount = monthlyPurchaseAmount;
        this.monthlyPurchaseAmount10 = monthlyPurchaseAmount10;
        this.monthlyInvestmentTarget = monthlyInvestmentTarget;
        this.monthlyPerformanceLimit = monthlyPerformanceLimit;
        this.effectiveCurrentSalesScale = effectiveCurrentSalesScale;
        this.deferredNextMonth = deferredNextMonth;
        this.mtime = mtime;
        this.ctime = ctime;
    }

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
     * 获取当月申购金额（万元）
     *
     * @return monthly_purchase_amount - 当月申购金额（万元）
     */
    public Double getMonthlyPurchaseAmount() {
        return monthlyPurchaseAmount;
    }

    /**
     * 设置当月申购金额（万元）
     *
     * @param monthlyPurchaseAmount 当月申购金额（万元）
     */
    public void setMonthlyPurchaseAmount(Double monthlyPurchaseAmount) {
        this.monthlyPurchaseAmount = monthlyPurchaseAmount;
    }

    /**
     * 获取当月申购金额/10（千元）
     *
     * @return monthly_purchase_amount_10 - 当月申购金额/10（千元）
     */
    public Double getMonthlyPurchaseAmount10() {
        return monthlyPurchaseAmount10;
    }

    /**
     * 设置当月申购金额/10（千元）
     *
     * @param monthlyPurchaseAmount10 当月申购金额/10（千元）
     */
    public void setMonthlyPurchaseAmount10(Double monthlyPurchaseAmount10) {
        this.monthlyPurchaseAmount10 = monthlyPurchaseAmount10;
    }

    /**
     * 获取月投资规模目标（万元）
     *
     * @return monthly_investment_target - 月投资规模目标（万元）
     */
    public Double getMonthlyInvestmentTarget() {
        return monthlyInvestmentTarget;
    }

    /**
     * 设置月投资规模目标（万元）
     *
     * @param monthlyInvestmentTarget 月投资规模目标（万元）
     */
    public void setMonthlyInvestmentTarget(Double monthlyInvestmentTarget) {
        this.monthlyInvestmentTarget = monthlyInvestmentTarget;
    }

    /**
     * 获取当月活期业绩上限（万元）
     *
     * @return monthly_performance_limit - 当月活期业绩上限（万元）
     */
    public Double getMonthlyPerformanceLimit() {
        return monthlyPerformanceLimit;
    }

    /**
     * 设置当月活期业绩上限（万元）
     *
     * @param monthlyPerformanceLimit 当月活期业绩上限（万元）
     */
    public void setMonthlyPerformanceLimit(Double monthlyPerformanceLimit) {
        this.monthlyPerformanceLimit = monthlyPerformanceLimit;
    }

    /**
     * 获取有效活期销售规模（万元）
     *
     * @return effective_current_sales_scale - 有效活期销售规模（万元）
     */
    public Double getEffectiveCurrentSalesScale() {
        return effectiveCurrentSalesScale;
    }

    /**
     * 设置有效活期销售规模（万元）
     *
     * @param effectiveCurrentSalesScale 有效活期销售规模（万元）
     */
    public void setEffectiveCurrentSalesScale(Double effectiveCurrentSalesScale) {
        this.effectiveCurrentSalesScale = effectiveCurrentSalesScale;
    }

    /**
     * 获取递延下月（万元）
     *
     * @return deferred_next_month - 递延下月（万元）
     */
    public Double getDeferredNextMonth() {
        return deferredNextMonth;
    }

    /**
     * 设置递延下月（万元）
     *
     * @param deferredNextMonth 递延下月（万元）
     */
    public void setDeferredNextMonth(Double deferredNextMonth) {
        this.deferredNextMonth = deferredNextMonth;
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

    @Override
    public String toString() {
        return "PaCurrentSalesScaleAccounting{" +
                "id=" + id +
                ", investmentAdviser='" + investmentAdviser + '\'' +
                ", monthlyPurchaseAmount=" + monthlyPurchaseAmount +
                ", monthlyPurchaseAmount10=" + monthlyPurchaseAmount10 +
                ", monthlyInvestmentTarget=" + monthlyInvestmentTarget +
                ", monthlyPerformanceLimit=" + monthlyPerformanceLimit +
                ", effectiveCurrentSalesScale=" + effectiveCurrentSalesScale +
                ", deferredNextMonth=" + deferredNextMonth +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}