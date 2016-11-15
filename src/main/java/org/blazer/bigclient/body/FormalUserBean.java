package org.blazer.bigclient.body;

import java.util.Date;

/**
 * Created by cuican on 2016-11-15.
 */
public class FormalUserBean {

    private Long userId;
    private Long phoneNumber;
    private String reportOrAllot;
    private String reportOrAllotDate;
    private String userIdentify;
    private String investmentAdviser;
    private Integer ifDelete;
    private String versionNo;
    private Date startDate;
    private Date endDate;

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

    public Integer getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Integer ifDelete) {
        this.ifDelete = ifDelete;
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

    @Override
    public String toString() {
        return "FormalUserBean{" +
                "userId=" + userId +
                ", phoneNumber=" + phoneNumber +
                ", reportOrAllot='" + reportOrAllot + '\'' +
                ", reportOrAllotDate='" + reportOrAllotDate + '\'' +
                ", userIdentify='" + userIdentify + '\'' +
                ", investmentAdviser='" + investmentAdviser + '\'' +
                ", ifDelete=" + ifDelete +
                ", versionNo='" + versionNo + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
