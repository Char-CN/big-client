package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pr_regular_payment")
public class PrRegularPayment {
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
    private String phoneNumber;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 产品期限
     */
    @Column(name = "product_period")
    private String productPeriod;

    /**
     * 年天数
     */
    @Column(name = "year_days")
    private String yearDays;

    /**
     * 本金
     */
    private String principal;

    /**
     * 产品收益
     */
    @Column(name = "product_revenue")
    private String productRevenue;

    /**
     * 投资顾问
     */
    @Column(name = "investment_advisor")
    private String investmentAdvisor;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;

    public PrRegularPayment() {
    }

    public PrRegularPayment(String userName, String phoneNumber, String productName, String productPeriod, String yearDays,
                            String principal, String productRevenue, String investmentAdvisor, Date mtime, Date ctime) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.productName = productName;
        this.productPeriod = productPeriod;
        this.yearDays = yearDays;
        this.principal = principal;
        this.productRevenue = productRevenue;
        this.investmentAdvisor = investmentAdvisor;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号码
     *
     * @param phoneNumber 手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取产品期限
     *
     * @return product_period - 产品期限
     */
    public String getProductPeriod() {
        return productPeriod;
    }

    /**
     * 设置产品期限
     *
     * @param productPeriod 产品期限
     */
    public void setProductPeriod(String productPeriod) {
        this.productPeriod = productPeriod;
    }

    /**
     * 获取年天数
     *
     * @return year_days - 年天数
     */
    public String getYearDays() {
        return yearDays;
    }

    /**
     * 设置年天数
     *
     * @param yearDays 年天数
     */
    public void setYearDays(String yearDays) {
        this.yearDays = yearDays;
    }

    /**
     * 获取本金
     *
     * @return principal - 本金
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * 设置本金
     *
     * @param principal 本金
     */
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    /**
     * 获取产品收益
     *
     * @return product_revenue - 产品收益
     */
    public String getProductRevenue() {
        return productRevenue;
    }

    /**
     * 设置产品收益
     *
     * @param productRevenue 产品收益
     */
    public void setProductRevenue(String productRevenue) {
        this.productRevenue = productRevenue;
    }

    /**
     * 获取投资顾问
     *
     * @return investment_advisor - 投资顾问
     */
    public String getInvestmentAdvisor() {
        return investmentAdvisor;
    }

    /**
     * 设置投资顾问
     *
     * @param investmentAdvisor 投资顾问
     */
    public void setInvestmentAdvisor(String investmentAdvisor) {
        this.investmentAdvisor = investmentAdvisor;
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
        return "PrRegularPayment{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", productPeriod='" + productPeriod + '\'' +
                ", yearDays='" + yearDays + '\'' +
                ", principal='" + principal + '\'' +
                ", productRevenue='" + productRevenue + '\'' +
                ", investmentAdvisor='" + investmentAdvisor + '\'' +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}