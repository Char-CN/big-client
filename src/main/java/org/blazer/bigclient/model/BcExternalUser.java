package org.blazer.bigclient.model;

import java.util.Date;

public class BcExternalUser {
    private Long id;

    private Long excelId;

    private Long phoneNumber;

    private String sysName;

    private String sysIfRegister;

    private String sysRegisterDate;

    private String sysIfRealName;

    private String sysIfBindCard;

    private String sysIfTransaction;

    private String sysReferrer;

    private String sysRebateExpirationDate;

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

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysIfRegister() {
        return sysIfRegister;
    }

    public void setSysIfRegister(String sysIfRegister) {
        this.sysIfRegister = sysIfRegister;
    }

    public String getSysRegisterDate() {
        return sysRegisterDate;
    }

    public void setSysRegisterDate(String sysRegisterDate) {
        this.sysRegisterDate = sysRegisterDate;
    }

    public String getSysIfRealName() {
        return sysIfRealName;
    }

    public void setSysIfRealName(String sysIfRealName) {
        this.sysIfRealName = sysIfRealName;
    }

    public String getSysIfBindCard() {
        return sysIfBindCard;
    }

    public void setSysIfBindCard(String sysIfBindCard) {
        this.sysIfBindCard = sysIfBindCard;
    }

    public String getSysIfTransaction() {
        return sysIfTransaction;
    }

    public void setSysIfTransaction(String sysIfTransaction) {
        this.sysIfTransaction = sysIfTransaction;
    }

    public String getSysReferrer() {
        return sysReferrer;
    }

    public void setSysReferrer(String sysReferrer) {
        this.sysReferrer = sysReferrer;
    }

    public String getSysRebateExpirationDate() {
        return sysRebateExpirationDate;
    }

    public void setSysRebateExpirationDate(String sysRebateExpirationDate) {
        this.sysRebateExpirationDate = sysRebateExpirationDate;
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