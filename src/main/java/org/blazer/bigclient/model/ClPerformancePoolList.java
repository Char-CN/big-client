package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cl_performance_pool_list")
public class ClPerformancePoolList {
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
    private Long phoneNumber;

    /**
     * 是否业绩池（0：不计入，1：计入）
     */
    @Column(name = "if_performance_pool")
    private Integer ifPerformancePool;

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
     * 获取手机号码
     *
     * @return phone_number - 手机号码
     */
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号码
     *
     * @param phoneNumber 手机号码
     */
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取是否业绩池（0：不计入，1：计入）
     *
     * @return if_performance_pool - 是否业绩池（0：不计入，1：计入）
     */
    public Integer getIfPerformancePool() {
        return ifPerformancePool;
    }

    /**
     * 设置是否业绩池（0：不计入，1：计入）
     *
     * @param ifPerformancePool 是否业绩池（0：不计入，1：计入）
     */
    public void setIfPerformancePool(Integer ifPerformancePool) {
        this.ifPerformancePool = ifPerformancePool;
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