package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sr_regular_sales_details")
public class SrRegularSalesDetails {
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