package org.blazer.bigclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer reportOrAllot;

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
     * 现有资产
     */
    @Column(name = "current_assets_total")
    private String currentAssetsTotal;

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
     * 业绩池系数
     */
    @Column(name = "performance_pool_coefficient")
    private Integer performancePoolCoefficient;

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

}