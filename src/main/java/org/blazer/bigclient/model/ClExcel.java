package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "kam_excel")
public class ClExcel {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 当前用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * Excel源文件名
     */
    @Column(name = "excel_name")
    private String excelName;

    /**
     * Excel服务器文件名
     */
    @Column(name = "excel_real_name")
    private String excelRealName;

    /**
     * Excel服务器路径
     */
    @Column(name = "excel_real_path")
    private String excelRealPath;

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
     * 获取当前用户ID
     *
     * @return user_id - 当前用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置当前用户ID
     *
     * @param userId 当前用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取Excel源文件名
     *
     * @return excel_name - Excel源文件名
     */
    public String getExcelName() {
        return excelName;
    }

    /**
     * 设置Excel源文件名
     *
     * @param excelName Excel源文件名
     */
    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    /**
     * 获取Excel服务器文件名
     *
     * @return excel_real_name - Excel服务器文件名
     */
    public String getExcelRealName() {
        return excelRealName;
    }

    /**
     * 设置Excel服务器文件名
     *
     * @param excelRealName Excel服务器文件名
     */
    public void setExcelRealName(String excelRealName) {
        this.excelRealName = excelRealName;
    }

    /**
     * 获取Excel服务器路径
     *
     * @return excel_real_path - Excel服务器路径
     */
    public String getExcelRealPath() {
        return excelRealPath;
    }

    /**
     * 设置Excel服务器路径
     *
     * @param excelRealPath Excel服务器路径
     */
    public void setExcelRealPath(String excelRealPath) {
        this.excelRealPath = excelRealPath;
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
        return "ClExcel{" +
                "id=" + id +
                ", userId=" + userId +
                ", excelName='" + excelName + '\'' +
                ", excelRealName='" + excelRealName + '\'' +
                ", excelRealPath='" + excelRealPath + '\'' +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}