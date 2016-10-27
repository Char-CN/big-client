package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sr_current_sales_details")
public class SrCurrentSalesDetails {
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
     * 基础产品名称（活期）
     */
    @Column(name = "base_product_name")
    private String baseProductName;

    /**
     * 申购金额
     */
    @Column(name = "purchase_amount")
    private String purchaseAmount;

    /**
     * 现有资产---当前活期AUM（资产总额）
     */
    @Column(name = "current_assets_total")
    private String currentAssetsTotal;

    /**
     * 申购时间 0000-00-00 00:00:00
     */
    @Column(name = "purchase_date")
    private String purchaseDate;

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
     * 获取基础产品名称（活期）
     *
     * @return base_product_name - 基础产品名称（活期）
     */
    public String getBaseProductName() {
        return baseProductName;
    }

    /**
     * 设置基础产品名称（活期）
     *
     * @param baseProductName 基础产品名称（活期）
     */
    public void setBaseProductName(String baseProductName) {
        this.baseProductName = baseProductName;
    }

    /**
     * 获取申购金额
     *
     * @return purchase_amount - 申购金额
     */
    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * 设置申购金额
     *
     * @param purchaseAmount 申购金额
     */
    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    /**
     * 获取现有资产---当前活期AUM（资产总额）
     *
     * @return current_assets_total - 现有资产---当前活期AUM（资产总额）
     */
    public String getCurrentAssetsTotal() {
        return currentAssetsTotal;
    }

    /**
     * 设置现有资产---当前活期AUM（资产总额）
     *
     * @param currentAssetsTotal 现有资产---当前活期AUM（资产总额）
     */
    public void setCurrentAssetsTotal(String currentAssetsTotal) {
        this.currentAssetsTotal = currentAssetsTotal;
    }

    /**
     * 获取申购时间 0000-00-00 00:00:00
     *
     * @return purchase_date - 申购时间 0000-00-00 00:00:00
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * 设置申购时间 0000-00-00 00:00:00
     *
     * @param purchaseDate 申购时间 0000-00-00 00:00:00
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
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