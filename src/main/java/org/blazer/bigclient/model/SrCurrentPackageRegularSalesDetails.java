package org.blazer.bigclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sr_current_package_regular_sales_details")
public class SrCurrentPackageRegularSalesDetails {
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
     * 基础产品名称（活包定）
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
    
}