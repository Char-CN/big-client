package org.blazer.bigclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pr_return_payment_report")
public class PrReturnPaymentReport {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 客户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 投资顾问
     */
    @Column(name = "investment_advisor")
    private String investmentAdvisor;
    /**
     * 客户标识
     */
    @Column(name = "user_identify")
    private String userIdentify;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 本金
     */
    private String amount;

    /**
     * 产品期限
     */
    @Column(name = "product_period")
    private String productPeriod;

    /**
     * 产品利率
     */
    @Column(name = "product_interest_rate")
    private String productInterestRate;

    /**
     * 起息日
     */
    @Column(name = "interest_date")
    private String interestDate;
    /**
     * 到期日
     */
    @Column(name = "expiry_date")
    private String expiryDate;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;

}