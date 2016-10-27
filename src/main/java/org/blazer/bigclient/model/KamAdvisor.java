package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

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
     * 获取所属团队ID（advisor_team.id）
     *
     * @return tid - 所属团队ID（advisor_team.id）
     */
    public Long getTid() {
        return tid;
    }

    /**
     * 设置所属团队ID（advisor_team.id）
     *
     * @param tid 所属团队ID（advisor_team.id）
     */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /**
     * 获取投顾编号
     *
     * @return serial_number - 投顾编号
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * 设置投顾编号
     *
     * @param serialNumber 投顾编号
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * 获取投顾级别
     *
     * @return level - 投顾级别
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置投顾级别
     *
     * @param level 投顾级别
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 获取系统登录用户名
     *
     * @return system_name - 系统登录用户名
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 设置系统登录用户名
     *
     * @param systemName 系统登录用户名
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    /**
     * 获取投顾姓名
     *
     * @return actual_name - 投顾姓名
     */
    public String getActualName() {
        return actualName;
    }

    /**
     * 设置投顾姓名
     *
     * @param actualName 投顾姓名
     */
    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    /**
     * 获取投顾手机号码
     *
     * @return phone_number - 投顾手机号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置投顾手机号码
     *
     * @param phoneNumber 投顾手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取备注信息
     *
     * @return remark - 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     *
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
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