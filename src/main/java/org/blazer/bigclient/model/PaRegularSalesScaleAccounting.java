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
     * 客户的自动编号=kamUserInfo.id
     */
    private Long uid;

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
     * 获取客户的自动编号=kamUserInfo.id
     *
     * @return uid - 客户的自动编号=kamUserInfo.id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置客户的自动编号=kamUserInfo.id
     *
     * @param uid 客户的自动编号=kamUserInfo.id
     */
    public void setUid(Long uid) {
        this.uid = uid;
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
}