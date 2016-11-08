package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cl_allot_user")
public class ClAllotUser {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    private Long phoneNumber;

    /**
     * 客户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 注册日期
     */
    @Column(name = "register_date")
    private String registerDate;

    /**
     * 证件号码
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 是否员工
     */
    @Column(name = "if_employee")
    private String ifEmployee;

    /**
     * 资产总额
     */
    @Column(name = "assets_amount")
    private String assetsAmount;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 扫码推荐人
     */
    private String referrer;

    /**
     * 推荐人手机号
     */
    @Column(name = "referrer_phone_number")
    private String referrerPhoneNumber;

    /**
     * 推荐人是否员工
     */
    @Column(name = "if_referrer_employee")
    private String ifReferrerEmployee;

    /**
     * 投资顾问
     */
    @Column(name = "investment_adviser")
    private String investmentAdviser;

    /**
     * 客户标识
     */
    @Column(name = "user_identify")
    private String userIdentify;

    /**
     * 是否删除;0:未删除，1:删除
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
     * 获取注册日期
     *
     * @return register_date - 注册日期
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * 设置注册日期
     *
     * @param registerDate 注册日期
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * 获取证件号码
     *
     * @return id_card - 证件号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置证件号码
     *
     * @param idCard 证件号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取是否员工
     *
     * @return if_employee - 是否员工
     */
    public String getIfEmployee() {
        return ifEmployee;
    }

    /**
     * 设置是否员工
     *
     * @param ifEmployee 是否员工
     */
    public void setIfEmployee(String ifEmployee) {
        this.ifEmployee = ifEmployee;
    }

    /**
     * 获取资产总额
     *
     * @return assets_amount - 资产总额
     */
    public String getAssetsAmount() {
        return assetsAmount;
    }

    /**
     * 设置资产总额
     *
     * @param assetsAmount 资产总额
     */
    public void setAssetsAmount(String assetsAmount) {
        this.assetsAmount = assetsAmount;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取扫码推荐人
     *
     * @return referrer - 扫码推荐人
     */
    public String getReferrer() {
        return referrer;
    }

    /**
     * 设置扫码推荐人
     *
     * @param referrer 扫码推荐人
     */
    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    /**
     * 获取推荐人手机号
     *
     * @return referrer_phone_number - 推荐人手机号
     */
    public String getReferrerPhoneNumber() {
        return referrerPhoneNumber;
    }

    /**
     * 设置推荐人手机号
     *
     * @param referrerPhoneNumber 推荐人手机号
     */
    public void setReferrerPhoneNumber(String referrerPhoneNumber) {
        this.referrerPhoneNumber = referrerPhoneNumber;
    }

    /**
     * 获取推荐人是否员工
     *
     * @return if_referrer_employee - 推荐人是否员工
     */
    public String getIfReferrerEmployee() {
        return ifReferrerEmployee;
    }

    /**
     * 设置推荐人是否员工
     *
     * @param ifReferrerEmployee 推荐人是否员工
     */
    public void setIfReferrerEmployee(String ifReferrerEmployee) {
        this.ifReferrerEmployee = ifReferrerEmployee;
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
     * 获取客户标识
     *
     * @return user_identify - 客户标识
     */
    public String getUserIdentify() {
        return userIdentify;
    }

    /**
     * 设置客户标识
     *
     * @param userIdentify 客户标识
     */
    public void setUserIdentify(String userIdentify) {
        this.userIdentify = userIdentify;
    }

    /**
     * 获取是否删除;0:未删除，1:删除
     *
     * @return if_delete - 是否删除;0:未删除，1:删除
     */
    public Integer getIfDelete() {
        return ifDelete;
    }

    /**
     * 设置是否删除;0:未删除，1:删除
     *
     * @param ifDelete 是否删除;0:未删除，1:删除
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

    @Override
    public String toString() {
        return "ClAllotUser{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", userName='" + userName + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", idCard='" + idCard + '\'' +
                ", ifEmployee='" + ifEmployee + '\'' +
                ", assetsAmount='" + assetsAmount + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", birthday='" + birthday + '\'' +
                ", referrer='" + referrer + '\'' +
                ", referrerPhoneNumber='" + referrerPhoneNumber + '\'' +
                ", ifReferrerEmployee='" + ifReferrerEmployee + '\'' +
                ", investmentAdviser='" + investmentAdviser + '\'' +
                ", userIdentify='" + userIdentify + '\'' +
                ", ifDelete=" + ifDelete +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}