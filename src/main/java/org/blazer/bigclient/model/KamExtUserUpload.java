package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "kam_ext_user_upload")
public class KamExtUserUpload {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * excel关联id
     */
    @Column(name = "excel_id")
    private Long excelId;

    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    private Long phoneNumber;

    /**
     * 投资顾问
     */
    @Column(name = "investment_adviser")
    private String investmentAdviser;

    /**
     * 是否删除，0代表未删除，1代表删除
     */
    @Column(name = "if_delete")
    private Integer ifDelete;

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
     * 获取excel关联id
     *
     * @return excel_id - excel关联id
     */
    public Long getExcelId() {
        return excelId;
    }

    /**
     * 设置excel关联id
     *
     * @param excelId excel关联id
     */
    public void setExcelId(Long excelId) {
        this.excelId = excelId;
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
     * 获取投资顾问
     *
     * @return investment_adviser - 投资顾问
     */
    public String getInvestmentAdviser() {
        return investmentAdviser;
    }

    /**
     * 设置投资顾问
     *
     * @param investmentAdviser 投资顾问
     */
    public void setInvestmentAdviser(String investmentAdviser) {
        this.investmentAdviser = investmentAdviser;
    }

    /**
     * 获取是否删除，0代表未删除，1代表删除
     *
     * @return if_delete - 是否删除，0代表未删除，1代表删除
     */
    public Integer getIfDelete() {
        return ifDelete;
    }

    /**
     * 设置是否删除，0代表未删除，1代表删除
     *
     * @param ifDelete 是否删除，0代表未删除，1代表删除
     */
    public void setIfDelete(Integer ifDelete) {
        this.ifDelete = ifDelete;
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