package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sr_assets_balance")
public class SrAssetsBalance {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 客户姓名
     */
    @Column(name = "user_name")
    private String userName;

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
     * 注册日期
     */
    @Column(name = "register_date")
    private String registerDate;

    /**
     * 当前定期AUM（资产总额）
     */
    @Column(name = "regular_assets_total")
    private String regularAssetsTotal;

    /**
     * 当前定期AUM时间点
     */
    @Column(name = "regular_aum_time_point")
    private String regularAumTimePoint;

    /**
     * 当前活期AUM（资产总额）
     */
    @Column(name = "current_assets_total")
    private String currentAssetsTotal;

    /**
     * 当前活期AUM时间点
     */
    @Column(name = "current_aum_time_point")
    private String currentAumTimePoint;

    /**
     * 当前AUM汇总（单位：元）
     */
    @Column(name = "aum_total")
    private String aumTotal;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;

    public SrAssetsBalance() {
    }

    public SrAssetsBalance(String userName, Long phoneNumber, String investmentAdviser, String registerDate,
                           String regularAssetsTotal, String regularAumTimePoint, String currentAssetsTotal,
                           String currentAumTimePoint, String aumTotal, Date mtime, Date ctime) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.investmentAdviser = investmentAdviser;
        this.registerDate = registerDate;
        this.regularAssetsTotal = regularAssetsTotal;
        this.regularAumTimePoint = regularAumTimePoint;
        this.currentAssetsTotal = currentAssetsTotal;
        this.currentAumTimePoint = currentAumTimePoint;
        this.aumTotal = aumTotal;
        this.mtime = mtime;
        this.ctime = ctime;
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
     * 获取当前定期AUM（资产总额）
     *
     * @return regular_assets_total - 当前定期AUM（资产总额）
     */
    public String getRegularAssetsTotal() {
        return regularAssetsTotal;
    }

    /**
     * 设置当前定期AUM（资产总额）
     *
     * @param regularAssetsTotal 当前定期AUM（资产总额）
     */
    public void setRegularAssetsTotal(String regularAssetsTotal) {
        this.regularAssetsTotal = regularAssetsTotal;
    }

    /**
     * 获取当前定期AUM时间点
     *
     * @return regular_aum_time_point - 当前定期AUM时间点
     */
    public String getRegularAumTimePoint() {
        return regularAumTimePoint;
    }

    /**
     * 设置当前定期AUM时间点
     *
     * @param regularAumTimePoint 当前定期AUM时间点
     */
    public void setRegularAumTimePoint(String regularAumTimePoint) {
        this.regularAumTimePoint = regularAumTimePoint;
    }

    /**
     * 获取当前活期AUM（资产总额）
     *
     * @return current_assets_total - 当前活期AUM（资产总额）
     */
    public String getCurrentAssetsTotal() {
        return currentAssetsTotal;
    }

    /**
     * 设置当前活期AUM（资产总额）
     *
     * @param currentAssetsTotal 当前活期AUM（资产总额）
     */
    public void setCurrentAssetsTotal(String currentAssetsTotal) {
        this.currentAssetsTotal = currentAssetsTotal;
    }

    /**
     * 获取当前活期AUM时间点
     *
     * @return current_aum_time_point - 当前活期AUM时间点
     */
    public String getCurrentAumTimePoint() {
        return currentAumTimePoint;
    }

    /**
     * 设置当前活期AUM时间点
     *
     * @param currentAumTimePoint 当前活期AUM时间点
     */
    public void setCurrentAumTimePoint(String currentAumTimePoint) {
        this.currentAumTimePoint = currentAumTimePoint;
    }

    /**
     * 获取当前AUM汇总（单位：元）
     *
     * @return aum_total - 当前AUM汇总（单位：元）
     */
    public String getAumTotal() {
        return aumTotal;
    }

    /**
     * 设置当前AUM汇总（单位：元）
     *
     * @param aumTotal 当前AUM汇总（单位：元）
     */
    public void setAumTotal(String aumTotal) {
        this.aumTotal = aumTotal;
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
        return "SrAssetsBalance{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", investmentAdviser='" + investmentAdviser + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", regularAssetsTotal='" + regularAssetsTotal + '\'' +
                ", regularAumTimePoint='" + regularAumTimePoint + '\'' +
                ", currentAssetsTotal='" + currentAssetsTotal + '\'' +
                ", currentAumTimePoint='" + currentAumTimePoint + '\'' +
                ", aumTotal='" + aumTotal + '\'' +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}