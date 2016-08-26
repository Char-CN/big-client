package org.blazer.bigclient.model;

import java.util.Date;

public class BcExternalUserBackup {
    private Long id;

    private Long excelId;

    private Long phoneNumber;

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