package org.blazer.bigclient.model;

import java.util.Date;

public class BcFormalUser {
    private Long id;

    private Long excelId;

    private Long phoneNumber;

    private String reportOrAllot;

    private String reportOrAllotDate;

    private String investmentAdviser;

    private String userIdentify;

    private Date mtime;

    private Date ctime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExcelId() {
        return excelId;
    }

    public void setExcelId(Long excelId) {
        this.excelId = excelId;
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

    public String getInvestmentAdviser() {
        return investmentAdviser;
    }

    public void setInvestmentAdviser(String investmentAdviser) {
        this.investmentAdviser = investmentAdviser;
    }

    public String getUserIdentify() {
        return userIdentify;
    }

    public void setUserIdentify(String userIdentify) {
        this.userIdentify = userIdentify;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}