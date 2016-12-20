package org.blazer.bigclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kam_advisor")
public class KamAdvisor {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 所属团队ID（advisor_team.id）
     */
    private Long tid;

    /**
     * 投顾编号
     */
    @Column(name = "serial_number")
    private String serialNumber;

    /**
     * 投顾级别
     */
    private String level;

    /**
     * 系统登录用户名
     */
    @Column(name = "system_name")
    private String systemName;

    /**
     * 投顾姓名
     */
    @Column(name = "actual_name")
    private String actualName;

    /**
     * 投顾手机号码
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;

}