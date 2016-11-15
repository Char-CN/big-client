package org.blazer.bigclient.body;

import org.blazer.bigclient.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cuican on 2016-11-15.
 *
 * 正式名单页面展示bean
 */
public class FormalUserBean implements Serializable {

    private static final long serialVersionUID = -7447069713901405697L;

    private Long userId;
    private Long phoneNumber;
    private String reportOrAllot;
    private String reportOrAllotDate;
    private String userIdentify;
    private String investmentAdviser;
    private String ifPerformancePool;
    private String versionNo;
    private Date startDate;
    private Date endDate;
    private String startDateFormat;
    private String endDateFormat;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReportOrAllot() {
        return reportOrAllot;
    }

    public void setReportOrAllot(String reportOrAllot) {
        this.reportOrAllot = reportOrAllot;
    }

    public String getReportOrAllotDate() {
        return reportOrAllotDate;
    }

    public void setReportOrAllotDate(String reportOrAllotDate) {
        this.reportOrAllotDate = reportOrAllotDate;
    }

    public String getUserIdentify() {
        return userIdentify;
    }

    public void setUserIdentify(String userIdentify) {
        this.userIdentify = userIdentify;
    }

    public String getInvestmentAdviser() {
        return investmentAdviser;
    }

    public void setInvestmentAdviser(String investmentAdviser) {
        this.investmentAdviser = investmentAdviser;
    }

    public String getIfPerformancePool() {
        return ifPerformancePool;
    }

    public void setIfPerformancePool(String ifPerformancePool) {
        this.ifPerformancePool = ifPerformancePool;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStartDateFormat() {
        if (startDate == null) {
            startDateFormat = "";
        } else {
            startDateFormat = DateUtil.date2Str(startDate, DateUtil.DEFAULT_DATE_TIME_FORMAT);
        }
        return startDateFormat;
    }

    public void setStartDateFormat(String startDateFormat) {
        this.startDateFormat = startDateFormat;
    }

    public String getEndDateFormat() {
        if (endDate == null) {
            endDateFormat = "";
        } else {
            endDateFormat = DateUtil.date2Str(endDate, DateUtil.DEFAULT_DATE_TIME_FORMAT);
        }
        return endDateFormat;
    }

    public void setEndDateFormat(String endDateFormat) {
        this.endDateFormat = endDateFormat;
    }

    @Override
    public String toString() {
        return "FormalUserBean{" +
                "userId=" + userId +
                ", phoneNumber=" + phoneNumber +
                ", reportOrAllot='" + reportOrAllot + '\'' +
                ", reportOrAllotDate='" + reportOrAllotDate + '\'' +
                ", userIdentify='" + userIdentify + '\'' +
                ", investmentAdviser='" + investmentAdviser + '\'' +
                ", ifPerformancePool='" + ifPerformancePool + '\'' +
                ", versionNo='" + versionNo + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startDateFormat='" + startDateFormat + '\'' +
                ", endDateFormat='" + endDateFormat + '\'' +
                '}';
    }
}
