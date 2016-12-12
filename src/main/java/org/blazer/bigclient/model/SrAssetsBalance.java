package org.blazer.bigclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sr_assets_balance")
public class SrAssetsBalance {
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
     * 投资顾问
     */
    @Column(name = "investment_adviser")
    private String investmentAdviser;

    /**
     * 注册日期
     */
    @Column(name = "register_date")
    private String registerDate;

    /**
     * 当前定期资产总额
     */
    @Column(name = "regular_assets_total")
    private String regularAssetsTotal;

    /**
     * 当前活期资产总额
     */
    @Column(name = "current_assets_total")
    private String currentAssetsTotal;

    /**
     * 当前AUM（资产总额）
     */
    @Column(name = "aum_total")
    private String aumTotal;

    /**
     * AUM时间点
     */
    @Column(name = "aum_time_point")
    private String aumTimePoint;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;

}