package org.blazer.bigclient.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "pa_current_sales_scale_accounting")
public class PaCurrentSalesScaleAccounting {
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
     * 上报/分配
     */
    @Column(name = "report_or_allot")
    private String reportOrAllot;

    /**
     * 上报/分配日期
     */
    @Column(name = "report_or_allot_date")
    private String reportOrAllotDate;

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
     * 基础产品名称（活期）
     */
    @Column(name = "basic_product_name")
    private String basicProductName;

    /**
     * 申购金额（万元）
     */
    @Column(name = "monthly_purchase_amount")
    private Double monthlyPurchaseAmount;

    /**
     * 申购日期
     */
    @Column(name = "purchase_date")
    private String purchaseDate;

    /**
     * 申购金额/10（千元）
     */
    @Column(name = "monthly_purchase_amount_10")
    private Double monthlyPurchaseAmount10;

    /**
     * 是否上报（是或否）
     */
    @Column(name = "if_report")
    private String ifReport;

    /**
     * 有效金额（万元）
     */
    @Column(name = "effective_current_sales_scale")
    private Double effectiveCurrentSalesScale;

    /**
     * 递延下月金额（万元）
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

    public PaCurrentSalesScaleAccounting(String userName, Long phoneNumber, String reportOrAllot, String reportOrAllotDate,
                                         String investmentAdviser, String userIdentify, String basicProductName,
                                         Double monthlyPurchaseAmount, String purchaseDate, Double monthlyPurchaseAmount10,
                                         String ifReport, Double effectiveCurrentSalesScale, Double deferredNextMonth,
                                         Date mtime, Date ctime) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.reportOrAllot = reportOrAllot;
        this.reportOrAllotDate = reportOrAllotDate;
        this.investmentAdviser = investmentAdviser;
        this.userIdentify = userIdentify;
        this.basicProductName = basicProductName;
        this.monthlyPurchaseAmount = monthlyPurchaseAmount;
        this.purchaseDate = purchaseDate;
        this.monthlyPurchaseAmount10 = monthlyPurchaseAmount10;
        this.ifReport = ifReport;
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
     * 获取上报/分配
     *
     * @return report_or_allot - 上报/分配
     */
    public String getReportOrAllot() {
        return reportOrAllot;
    }

    /**
     * 设置上报/分配
     *
     * @param reportOrAllot 上报/分配
     */
    public void setReportOrAllot(String reportOrAllot) {
        this.reportOrAllot = reportOrAllot;
    }

    /**
     * 获取上报/分配日期
     *
     * @return report_or_allot_date - 上报/分配日期
     */
    public String getReportOrAllotDate() {
        return reportOrAllotDate;
    }

    /**
     * 设置上报/分配日期
     *
     * @param reportOrAllotDate 上报/分配日期
     */
    public void setReportOrAllotDate(String reportOrAllotDate) {
        this.reportOrAllotDate = reportOrAllotDate;
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
     * 获取基础产品名称（活期）
     *
     * @return basic_product_name - 基础产品名称（活期）
     */
    public String getBasicProductName() {
        return basicProductName;
    }

    /**
     * 设置基础产品名称（活期）
     *
     * @param basicProductName 基础产品名称（活期）
     */
    public void setBasicProductName(String basicProductName) {
        this.basicProductName = basicProductName;
    }

    /**
     * 获取申购金额（万元）
     *
     * @return monthly_purchase_amount - 申购金额（万元）
     */
    public Double getMonthlyPurchaseAmount() {
        return monthlyPurchaseAmount;
    }

    /**
     * 设置申购金额（万元）
     *
     * @param monthlyPurchaseAmount 申购金额（万元）
     */
    public void setMonthlyPurchaseAmount(Double monthlyPurchaseAmount) {
        this.monthlyPurchaseAmount = monthlyPurchaseAmount;
    }

    /**
     * 获取申购日期
     *
     * @return purchase_date - 申购日期
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * 设置申购日期
     *
     * @param purchaseDate 申购日期
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * 获取申购金额/10（千元）
     *
     * @return monthly_purchase_amount_10 - 申购金额/10（千元）
     */
    public Double getMonthlyPurchaseAmount10() {
        return monthlyPurchaseAmount10;
    }

    /**
     * 设置申购金额/10（千元）
     *
     * @param monthlyPurchaseAmount10 申购金额/10（千元）
     */
    public void setMonthlyPurchaseAmount10(Double monthlyPurchaseAmount10) {
        this.monthlyPurchaseAmount10 = monthlyPurchaseAmount10;
    }

    /**
     * 获取是否上报（是或否）
     *
     * @return if_report - 是否上报（是或否）
     */
    public String getIfReport() {
        return ifReport;
    }

    /**
     * 设置是否上报（是或否）
     *
     * @param ifReport 是否上报（是或否）
     */
    public void setIfReport(String ifReport) {
        this.ifReport = ifReport;
    }

    /**
     * 获取有效金额（万元）
     *
     * @return effective_current_sales_scale - 有效金额（万元）
     */
    public Double getEffectiveCurrentSalesScale() {
        return effectiveCurrentSalesScale;
    }

    /**
     * 设置有效金额（万元）
     *
     * @param effectiveCurrentSalesScale 有效金额（万元）
     */
    public void setEffectiveCurrentSalesScale(Double effectiveCurrentSalesScale) {
        this.effectiveCurrentSalesScale = effectiveCurrentSalesScale;
    }

    /**
     * 获取递延下月金额（万元）
     *
     * @return deferred_next_month - 递延下月金额（万元）
     */
    public Double getDeferredNextMonth() {
        return deferredNextMonth;
    }

    /**
     * 设置递延下月金额（万元）
     *
     * @param deferredNextMonth 递延下月金额（万元）
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
                ", userName='" + userName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", reportOrAllot='" + reportOrAllot + '\'' +
                ", reportOrAllotDate='" + reportOrAllotDate + '\'' +
                ", investmentAdviser='" + investmentAdviser + '\'' +
                ", userIdentify='" + userIdentify + '\'' +
                ", basicProductName='" + basicProductName + '\'' +
                ", monthlyPurchaseAmount=" + monthlyPurchaseAmount +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", monthlyPurchaseAmount10=" + monthlyPurchaseAmount10 +
                ", ifReport='" + ifReport + '\'' +
                ", effectiveCurrentSalesScale=" + effectiveCurrentSalesScale +
                ", deferredNextMonth=" + deferredNextMonth +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}