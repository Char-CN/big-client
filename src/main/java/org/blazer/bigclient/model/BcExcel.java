package org.blazer.bigclient.model;

import java.util.Date;

public class BcExcel {
    private Long id;

    private Integer serviceId;

    private Long userId;

    private String excelName;

    private String excelRealName;

    private String excelRealPath;

    private Date mtime;

    private Date ctime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public String getExcelRealName() {
        return excelRealName;
    }

    public void setExcelRealName(String excelRealName) {
        this.excelRealName = excelRealName;
    }

    public String getExcelRealPath() {
        return excelRealPath;
    }

    public void setExcelRealPath(String excelRealPath) {
        this.excelRealPath = excelRealPath;
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