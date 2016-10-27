package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "kam_user_info")
public class KamUserInfo {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * excel关联id(平台分配-1，手动添加0，excel上传正数)
     */
    @Column(name = "excel_id")
    private Long excelId;

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
     * 证件号码
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 资产总额
     */
    @Column(name = "assets_amount")
    private String assetsAmount;

    /**
     * 是否员工
     */
    @Column(name = "if_employee")
    private String ifEmployee;

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
     * 返利失效日期
     */
    @Column(name = "rebate_expiration_date")
    private String rebateExpirationDate;

    /**
     * 是否上报/分配（0未操作，1已操作）
     */
    @Column(name = "if_report_or_allot")
    private Integer ifReportOrAllot;

    /**
     * 上报/分配
     */
    @Column(name = "report_or_allot")
    private String reportOrAllot;

    /**
     * 上报/分配时间
     */
    @Column(name = "report_or_allot_date")
    private String reportOrAllotDate;

    /**
     * 客户标识
     */
    @Column(name = "user_identify")
    private String userIdentify;

    /**
     * 投资顾问
     */
    @Column(name = "investment_adviser")
    private String investmentAdviser;

    /**
     * 是否业绩池（0：不计入，1：计入）
     */
    @Column(name = "if_performance_pool")
    private Integer ifPerformancePool;

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
     * 获取excel关联id(平台分配-1，手动添加0，excel上传正数)
     *
     * @return excel_id - excel关联id(平台分配-1，手动添加0，excel上传正数)
     */
    public Long getExcelId() {
        return excelId;
    }

    /**
     * 设置excel关联id(平台分配-1，手动添加0，excel上传正数)
     *
     * @param excelId excel关联id(平台分配-1，手动添加0，excel上传正数)
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
     * 获取返利失效日期
     *
     * @return rebate_expiration_date - 返利失效日期
     */
    public String getRebateExpirationDate() {
        return rebateExpirationDate;
    }

    /**
     * 设置返利失效日期
     *
     * @param rebateExpirationDate 返利失效日期
     */
    public void setRebateExpirationDate(String rebateExpirationDate) {
        this.rebateExpirationDate = rebateExpirationDate;
    }

    /**
     * 获取是否上报/分配（0未操作，1已操作）
     *
     * @return if_report_or_allot - 是否上报/分配（0未操作，1已操作）
     */
    public Integer getIfReportOrAllot() {
        return ifReportOrAllot;
    }

    /**
     * 设置是否上报/分配（0未操作，1已操作）
     *
     * @param ifReportOrAllot 是否上报/分配（0未操作，1已操作）
     */
    public void setIfReportOrAllot(Integer ifReportOrAllot) {
        this.ifReportOrAllot = ifReportOrAllot;
    }

    /**
     * 获取上报/分配
     *
     * @return report_or_allot - 上报/分配
     */
    public String getReportOrAllot() {
        return reportOrAllot;
    }

    /**
     * 设置上报/分配
     *
     * @param reportOrAllot 上报/分配
     */
    public void setReportOrAllot(String reportOrAllot) {
        this.reportOrAllot = reportOrAllot;
    }

    /**
     * 获取上报/分配时间
     *
     * @return report_or_allot_date - 上报/分配时间
     */
    public String getReportOrAllotDate() {
        return reportOrAllotDate;
    }

    /**
     * 设置上报/分配时间
     *
     * @param reportOrAllotDate 上报/分配时间
     */
    public void setReportOrAllotDate(String reportOrAllotDate) {
        this.reportOrAllotDate = reportOrAllotDate;
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
     * 获取是否业绩池（0：不计入，1：计入）
     *
     * @return if_performance_pool - 是否业绩池（0：不计入，1：计入）
     */
    public Integer getIfPerformancePool() {
        return ifPerformancePool;
    }

    /**
     * 设置是否业绩池（0：不计入，1：计入）
     *
     * @param ifPerformancePool 是否业绩池（0：不计入，1：计入）
     */
    public void setIfPerformancePool(Integer ifPerformancePool) {
        this.ifPerformancePool = ifPerformancePool;
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