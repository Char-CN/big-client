package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pa_regular_sales_scale_accounting")
public class PaRegularSalesScaleAccounting {
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
     * 扫码推荐人
     */
    private String referrer;

    /**
     * 返利失效日期
     */
    @Column(name = "rebate_expiration_date")
    private String rebateExpirationDate;

    /**
     * 上报/分配
     */
    @Column(name = "report_or_allot")
    private String reportOrAllot;

    /**
     * 上报/分配时间
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
     * 基础产品名称（定期）
     */
    @Column(name = "basic_product_name")
    private String basicProductName;

    /**
     * 投资金额
     */
    @Column(name = "investment_amount")
    private String investmentAmount;

    /**
     * 现有资产---当前定期AUM（资产总额）
     */
    @Column(name = "regular_assets_total")
    private String regularAssetsTotal;

    /**
     * 购买时间 0000-00-00 00:00:00
     */
    @Column(name = "investment_date")
    private String investmentDate;

    /**
     * 分配系数
     */
    @Column(name = "partition_coefficient")
    private Integer partitionCoefficient;

    /**
     * 业绩池系数
     */
    @Column(name = "performance_pool_coefficient")
    private Integer performancePoolCoefficient;

    /**
     * 产品系数
     */
    @Column(name = "product_coefficient")
    private Integer productCoefficient;

    /**
     * 有效销售金额（单位：元）
     */
    @Column(name = "effective_sales_amount")
    private Double effectiveSalesAmount;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;

    public PaRegularSalesScaleAccounting() {
    }

    public PaRegularSalesScaleAccounting(String userName, Long phoneNumber, String referrer, String rebateExpirationDate,
                                         String reportOrAllot, String reportOrAllotDate, String investmentAdviser,
                                         String userIdentify, String basicProductName, String investmentAmount,
                                         String regularAssetsTotal, String investmentDate, Integer partitionCoefficient,
                                         Integer performancePoolCoefficient, Integer productCoefficient, Double effectiveSalesAmount,
                                         Date mtime, Date ctime) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.referrer = referrer;
        this.rebateExpirationDate = rebateExpirationDate;
        this.reportOrAllot = reportOrAllot;
        this.reportOrAllotDate = reportOrAllotDate;
        this.investmentAdviser = investmentAdviser;
        this.userIdentify = userIdentify;
        this.basicProductName = basicProductName;
        this.investmentAmount = investmentAmount;
        this.regularAssetsTotal = regularAssetsTotal;
        this.investmentDate = investmentDate;
        this.partitionCoefficient = partitionCoefficient;
        this.performancePoolCoefficient = performancePoolCoefficient;
        this.productCoefficient = productCoefficient;
        this.effectiveSalesAmount = effectiveSalesAmount;
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
     * 获取扫码推荐人
     *
     * @return referrer - 扫码推荐人
     */
    public String getReferrer() {
        return referrer;
    }

    /**
     * 设置扫码推荐人
     *
     * @param referrer 扫码推荐人
     */
    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    /**
     * 获取返利失效日期
     *
     * @return rebate_expiration_date - 返利失效日期
     */
    public String getRebateExpirationDate() {
        return rebateExpirationDate;
    }

    /**
     * 设置返利失效日期
     *
     * @param rebateExpirationDate 返利失效日期
     */
    public void setRebateExpirationDate(String rebateExpirationDate) {
        this.rebateExpirationDate = rebateExpirationDate;
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
     * 获取上报/分配时间
     *
     * @return report_or_allot_date - 上报/分配时间
     */
    public String getReportOrAllotDate() {
        return reportOrAllotDate;
    }

    /**
     * 设置上报/分配时间
     *
     * @param reportOrAllotDate 上报/分配时间
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
     * 获取基础产品名称（定期）
     *
     * @return basic_product_name - 基础产品名称（定期）
     */
    public String getBasicProductName() {
        return basicProductName;
    }

    /**
     * 设置基础产品名称（定期）
     *
     * @param basicProductName 基础产品名称（定期）
     */
    public void setBasicProductName(String basicProductName) {
        this.basicProductName = basicProductName;
    }

    /**
     * 获取投资金额
     *
     * @return investment_amount - 投资金额
     */
    public String getInvestmentAmount() {
        return investmentAmount;
    }

    /**
     * 设置投资金额
     *
     * @param investmentAmount 投资金额
     */
    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    /**
     * 获取现有资产---当前定期AUM（资产总额）
     *
     * @return regular_assets_total - 现有资产---当前定期AUM（资产总额）
     */
    public String getRegularAssetsTotal() {
        return regularAssetsTotal;
    }

    /**
     * 设置现有资产---当前定期AUM（资产总额）
     *
     * @param regularAssetsTotal 现有资产---当前定期AUM（资产总额）
     */
    public void setRegularAssetsTotal(String regularAssetsTotal) {
        this.regularAssetsTotal = regularAssetsTotal;
    }

    /**
     * 获取购买时间 0000-00-00 00:00:00
     *
     * @return investment_date - 购买时间 0000-00-00 00:00:00
     */
    public String getInvestmentDate() {
        return investmentDate;
    }

    /**
     * 设置购买时间 0000-00-00 00:00:00
     *
     * @param investmentDate 购买时间 0000-00-00 00:00:00
     */
    public void setInvestmentDate(String investmentDate) {
        this.investmentDate = investmentDate;
    }

    /**
     * 获取分配系数
     *
     * @return partition_coefficient - 分配系数
     */
    public Integer getPartitionCoefficient() {
        return partitionCoefficient;
    }

    /**
     * 设置分配系数
     *
     * @param partitionCoefficient 分配系数
     */
    public void setPartitionCoefficient(Integer partitionCoefficient) {
        this.partitionCoefficient = partitionCoefficient;
    }

    /**
     * 获取业绩池系数
     *
     * @return performance_pool_coefficient - 业绩池系数
     */
    public Integer getPerformancePoolCoefficient() {
        return performancePoolCoefficient;
    }

    /**
     * 设置业绩池系数
     *
     * @param performancePoolCoefficient 业绩池系数
     */
    public void setPerformancePoolCoefficient(Integer performancePoolCoefficient) {
        this.performancePoolCoefficient = performancePoolCoefficient;
    }

    /**
     * 获取产品系数
     *
     * @return product_coefficient - 产品系数
     */
    public Integer getProductCoefficient() {
        return productCoefficient;
    }

    /**
     * 设置产品系数
     *
     * @param productCoefficient 产品系数
     */
    public void setProductCoefficient(Integer productCoefficient) {
        this.productCoefficient = productCoefficient;
    }

    /**
     * 获取有效销售金额（单位：元）
     *
     * @return effective_sales_amount - 有效销售金额（单位：元）
     */
    public Double getEffectiveSalesAmount() {
        return effectiveSalesAmount;
    }

    /**
     * 设置有效销售金额（单位：元）
     *
     * @param effectiveSalesAmount 有效销售金额（单位：元）
     */
    public void setEffectiveSalesAmount(Double effectiveSalesAmount) {
        this.effectiveSalesAmount = effectiveSalesAmount;
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
        return "PaRegularSalesScaleAccounting{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", referrer='" + referrer + '\'' +
                ", rebateExpirationDate='" + rebateExpirationDate + '\'' +
                ", reportOrAllot='" + reportOrAllot + '\'' +
                ", reportOrAllotDate='" + reportOrAllotDate + '\'' +
                ", investmentAdviser='" + investmentAdviser + '\'' +
                ", userIdentify='" + userIdentify + '\'' +
                ", basicProductName='" + basicProductName + '\'' +
                ", investmentAmount='" + investmentAmount + '\'' +
                ", regularAssetsTotal='" + regularAssetsTotal + '\'' +
                ", investmentDate='" + investmentDate + '\'' +
                ", partitionCoefficient=" + partitionCoefficient +
                ", performancePoolCoefficient=" + performancePoolCoefficient +
                ", productCoefficient=" + productCoefficient +
                ", effectiveSalesAmount=" + effectiveSalesAmount +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}