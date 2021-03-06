package org.blazer.bigclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sr_crp_payment_due")
public class SrCrpPaymentDue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "redemption_date")
    private String redemptionDate;

    private String principal;

    @Column(name = "product_revenue")
    private String productRevenue;

    @Column(name = "transfer_amount")
    private String transferAmount;

    @Column(name = "investment_advisor")
    private String investmentAdvisor;

    private Date mtime;

    private Date ctime;

}