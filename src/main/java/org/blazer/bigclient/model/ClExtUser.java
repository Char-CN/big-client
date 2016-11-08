package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cl_ext_user")
public class ClExtUser {
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
     * 投资顾问
     */
    @Column(name = "investment_adviser")
    private String investmentAdviser;

    /**
     * 是否注册
     */
    @Column(name = "if_register")
    private String ifRegister;

    /**
     * 注册日期
     */
    @Column(name = "register_date")
    private String registerDate;

    /**
     * 是否实名
     */
    @Column(name = "if_real_name")
    private String ifRealName;

    /**
     * 是否绑卡
     */
    @Column(name = "if_bind_card")
    private String ifBindCard;

    /**
     * 是否有过交易
     */
    @Column(name = "if_transaction")
    private String ifTransaction;

    /**
     * 扫码推荐人
     */
    private String referrer;

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
     * 获取是否注册
     *
     * @return if_register - 是否注册
     */
    public String getIfRegister() {
        return ifRegister;
    }

    /**
     * 设置是否注册
     *
     * @param ifRegister 是否注册
     */
    public void setIfRegister(String ifRegister) {
        this.ifRegister = ifRegister;
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
     * 获取是否实名
     *
     * @return if_real_name - 是否实名
     */
    public String getIfRealName() {
        return ifRealName;
    }

    /**
     * 设置是否实名
     *
     * @param ifRealName 是否实名
     */
    public void setIfRealName(String ifRealName) {
        this.ifRealName = ifRealName;
    }

    /**
     * 获取是否绑卡
     *
     * @return if_bind_card - 是否绑卡
     */
    public String getIfBindCard() {
        return ifBindCard;
    }

    /**
     * 设置是否绑卡
     *
     * @param ifBindCard 是否绑卡
     */
    public void setIfBindCard(String ifBindCard) {
        this.ifBindCard = ifBindCard;
    }

    /**
     * 获取是否有过交易
     *
     * @return if_transaction - 是否有过交易
     */
    public String getIfTransaction() {
        return ifTransaction;
    }

    /**
     * 设置是否有过交易
     *
     * @param ifTransaction 是否有过交易
     */
    public void setIfTransaction(String ifTransaction) {
        this.ifTransaction = ifTransaction;
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
        return "ClExtUser{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", userName='" + userName + '\'' +
                ", investmentAdviser='" + investmentAdviser + '\'' +
                ", ifRegister='" + ifRegister + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", ifRealName='" + ifRealName + '\'' +
                ", ifBindCard='" + ifBindCard + '\'' +
                ", ifTransaction='" + ifTransaction + '\'' +
                ", referrer='" + referrer + '\'' +
                ", userIdentify='" + userIdentify + '\'' +
                ", ifDelete=" + ifDelete +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}