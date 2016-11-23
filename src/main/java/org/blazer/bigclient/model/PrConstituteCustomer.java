package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pr_constitute_customer")
public class PrConstituteCustomer {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 计入业绩客户数
     */
    @Column(name = "performance_customers_number")
    private String performanceCustomersNumber;

    /**
     * 纯新增vip客户数
     */
    @Column(name = "pure_new_vip_customers")
    private String pureNewVipCustomers;

    /**
     * 上报客户数
     */
    @Column(name = "reported_customers_number")
    private String reportedCustomersNumber;

    /**
     * 分配客户数
     */
    @Column(name = "allot_customers_number")
    private String allotCustomersNumber;

    /**
     * 本周获客数
     */
    @Column(name = "weekly_get_customers_number")
    private String weeklyGetCustomersNumber;

    /**
     * 当前vip客户数
     */
    @Column(name = "current_vip_customers_number")
    private String currentVipCustomersNumber;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;


    public PrConstituteCustomer() {
    }

    public PrConstituteCustomer(String performanceCustomersNumber, String pureNewVipCustomers, String reportedCustomersNumber, String allotCustomersNumber, String weeklyGetCustomersNumber, String currentVipCustomersNumber, Date mtime, Date ctime) {
        this.performanceCustomersNumber = performanceCustomersNumber;
        this.pureNewVipCustomers = pureNewVipCustomers;
        this.reportedCustomersNumber = reportedCustomersNumber;
        this.allotCustomersNumber = allotCustomersNumber;
        this.weeklyGetCustomersNumber = weeklyGetCustomersNumber;
        this.currentVipCustomersNumber = currentVipCustomersNumber;
        this.mtime = mtime;
        this.ctime = ctime;
    }

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
     * 获取计入业绩客户数
     *
     * @return performance_customers_number - 计入业绩客户数
     */
    public String getPerformanceCustomersNumber() {
        return performanceCustomersNumber;
    }

    /**
     * 设置计入业绩客户数
     *
     * @param performanceCustomersNumber 计入业绩客户数
     */
    public void setPerformanceCustomersNumber(String performanceCustomersNumber) {
        this.performanceCustomersNumber = performanceCustomersNumber;
    }

    /**
     * 获取纯新增vip客户数
     *
     * @return pure_new_vip_customers - 纯新增vip客户数
     */
    public String getPureNewVipCustomers() {
        return pureNewVipCustomers;
    }

    /**
     * 设置纯新增vip客户数
     *
     * @param pureNewVipCustomers 纯新增vip客户数
     */
    public void setPureNewVipCustomers(String pureNewVipCustomers) {
        this.pureNewVipCustomers = pureNewVipCustomers;
    }

    /**
     * 获取上报客户数
     *
     * @return reported_customers_number - 上报客户数
     */
    public String getReportedCustomersNumber() {
        return reportedCustomersNumber;
    }

    /**
     * 设置上报客户数
     *
     * @param reportedCustomersNumber 上报客户数
     */
    public void setReportedCustomersNumber(String reportedCustomersNumber) {
        this.reportedCustomersNumber = reportedCustomersNumber;
    }

    /**
     * 获取分配客户数
     *
     * @return allot_customers_number - 分配客户数
     */
    public String getAllotCustomersNumber() {
        return allotCustomersNumber;
    }

    /**
     * 设置分配客户数
     *
     * @param allotCustomersNumber 分配客户数
     */
    public void setAllotCustomersNumber(String allotCustomersNumber) {
        this.allotCustomersNumber = allotCustomersNumber;
    }

    /**
     * 获取本周获客数
     *
     * @return weekly_get_customers_number - 本周获客数
     */
    public String getWeeklyGetCustomersNumber() {
        return weeklyGetCustomersNumber;
    }

    /**
     * 设置本周获客数
     *
     * @param weeklyGetCustomersNumber 本周获客数
     */
    public void setWeeklyGetCustomersNumber(String weeklyGetCustomersNumber) {
        this.weeklyGetCustomersNumber = weeklyGetCustomersNumber;
    }

    /**
     * 获取当前vip客户数
     *
     * @return current_vip_customers_number - 当前vip客户数
     */
    public String getCurrentVipCustomersNumber() {
        return currentVipCustomersNumber;
    }

    /**
     * 设置当前vip客户数
     *
     * @param currentVipCustomersNumber 当前vip客户数
     */
    public void setCurrentVipCustomersNumber(String currentVipCustomersNumber) {
        this.currentVipCustomersNumber = currentVipCustomersNumber;
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

    @Override
    public String toString() {
        return "PrConstituteCustomer{" +
                "id=" + id +
                ", performanceCustomersNumber='" + performanceCustomersNumber + '\'' +
                ", pureNewVipCustomers='" + pureNewVipCustomers + '\'' +
                ", reportedCustomersNumber='" + reportedCustomersNumber + '\'' +
                ", allotCustomersNumber='" + allotCustomersNumber + '\'' +
                ", weeklyGetCustomersNumber='" + weeklyGetCustomersNumber + '\'' +
                ", currentVipCustomersNumber='" + currentVipCustomersNumber + '\'' +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}