package org.blazer.bigclient.model;

import org.blazer.bigclient.util.DateUtil;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cl_ext_user_bak")
public class ClExtUserBak {
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
     * 投顾上传的客户姓名（待匹配系统客户姓名）
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * 客户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 投资顾问
     */
    @Column(name = "investment_adviser")
    private String investmentAdviser;

    /**
     * 是否有效（1：有效，0：无效）
     */
    @Column(name = "if_effective")
    private Integer ifEffective;

    /**
     * 是否删除，0代表未删除，1代表删除
     */
    @Column(name = "if_delete")
    private Integer ifDelete;

    /**
     * 备注信息(用来记录上报无效的原因）
     */
    private String remark;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;


    //格式化创建时间
    @Transient
    private String ctime_format;

    public String getCtime_format() {
        if (ctime == null) {
            ctime_format = "";
        } else {
            ctime_format = DateUtil.date2Str(ctime, DateUtil.DEFAULT_DATE_TIME_FORMAT);
        }
        return ctime_format;
    }

    public void setCtime_format(String ctime_format) {
        this.ctime_format = ctime_format;
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
     * 获取投顾上传的客户姓名（待匹配系统客户姓名）
     *
     * @return customer_name - 投顾上传的客户姓名（待匹配系统客户姓名）
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置投顾上传的客户姓名（待匹配系统客户姓名）
     *
     * @param customerName 投顾上传的客户姓名（待匹配系统客户姓名）
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取客户姓名
     *
     * @return user_name - 客户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置客户姓名
     *
     * @param userName 客户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * 获取是否有效（1：有效，0：无效）
     *
     * @return if_effective - 是否有效（1：有效，0：无效）
     */
    public Integer getIfEffective() {
        return ifEffective;
    }

    /**
     * 设置是否有效（1：有效，0：无效）
     *
     * @param ifEffective 是否有效（1：有效，0：无效）
     */
    public void setIfEffective(Integer ifEffective) {
        this.ifEffective = ifEffective;
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
     * 获取备注信息(用来记录上报无效的原因）
     *
     * @return remark - 备注信息(用来记录上报无效的原因）
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息(用来记录上报无效的原因）
     *
     * @param remark 备注信息(用来记录上报无效的原因）
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
        return "ClExtUserBak{" +
                "id=" + id +
                ", excelId=" + excelId +
                ", phoneNumber=" + phoneNumber +
                ", customerName='" + customerName + '\'' +
                ", userName='" + userName + '\'' +
                ", investmentAdviser='" + investmentAdviser + '\'' +
                ", ifEffective=" + ifEffective +
                ", ifDelete=" + ifDelete +
                ", remark='" + remark + '\'' +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                ", ctime_format='" + ctime_format + '\'' +
                '}';
    }
}