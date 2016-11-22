package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pr_customer_conversion_rate")
public class PrCustomerConversionRate {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 上期客户数
     */
    @Column(name = "last_period_customers_number")
    private String lastPeriodCustomersNumber;

    /**
     * 本期客户数
     */
    @Column(name = "current_period_customers_number")
    private String currentPeriodCustomersNumber;

    /**
     * 上期注册客户数
     */
    @Column(name = "last_period_registered_customers_number")
    private String lastPeriodRegisteredCustomersNumber;

    /**
     * 本期注册客户数
     */
    @Column(name = "current_period_registered_customers_number")
    private String currentPeriodRegisteredCustomersNumber;

    /**
     * 上期客户交易数
     */
    @Column(name = "last_period_transaction_customers_number")
    private String lastPeriodTransactionCustomersNumber;

    /**
     * 本期客户交易数
     */
    @Column(name = "current_period_transaction_customers_number")
    private String currentPeriodTransactionCustomersNumber;

    /**
     * 本期注册客户占比
     */
    @Column(name = "current_period_registered_customers_proportion")
    private String currentPeriodRegisteredCustomersProportion;

    /**
     * 客户注册增长率
     */
    @Column(name = "customer_registration_growth_rate")
    private String customerRegistrationGrowthRate;

    /**
     * 本期交易客户占比
     */
    @Column(name = "current_period_transactions_customers_proportion")
    private String currentPeriodTransactionsCustomersProportion;

    /**
     * 客户交易转换率
     */
    @Column(name = "customer_transaction_conversion_rate")
    private String customerTransactionConversionRate;

    /**
     * 本期客户AUM增长率(期末基准)
     */
    @Column(name = "current_period_customers_aum_growth_rate")
    private String currentPeriodCustomersAumGrowthRate;

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
     * 获取上期客户数
     *
     * @return last_period_customers_number - 上期客户数
     */
    public String getLastPeriodCustomersNumber() {
        return lastPeriodCustomersNumber;
    }

    /**
     * 设置上期客户数
     *
     * @param lastPeriodCustomersNumber 上期客户数
     */
    public void setLastPeriodCustomersNumber(String lastPeriodCustomersNumber) {
        this.lastPeriodCustomersNumber = lastPeriodCustomersNumber;
    }

    /**
     * 获取本期客户数
     *
     * @return current_period_customers_number - 本期客户数
     */
    public String getCurrentPeriodCustomersNumber() {
        return currentPeriodCustomersNumber;
    }

    /**
     * 设置本期客户数
     *
     * @param currentPeriodCustomersNumber 本期客户数
     */
    public void setCurrentPeriodCustomersNumber(String currentPeriodCustomersNumber) {
        this.currentPeriodCustomersNumber = currentPeriodCustomersNumber;
    }

    /**
     * 获取上期注册客户数
     *
     * @return last_period_registered_customers_number - 上期注册客户数
     */
    public String getLastPeriodRegisteredCustomersNumber() {
        return lastPeriodRegisteredCustomersNumber;
    }

    /**
     * 设置上期注册客户数
     *
     * @param lastPeriodRegisteredCustomersNumber 上期注册客户数
     */
    public void setLastPeriodRegisteredCustomersNumber(String lastPeriodRegisteredCustomersNumber) {
        this.lastPeriodRegisteredCustomersNumber = lastPeriodRegisteredCustomersNumber;
    }

    /**
     * 获取本期注册客户数
     *
     * @return current_period_registered_customers_number - 本期注册客户数
     */
    public String getCurrentPeriodRegisteredCustomersNumber() {
        return currentPeriodRegisteredCustomersNumber;
    }

    /**
     * 设置本期注册客户数
     *
     * @param currentPeriodRegisteredCustomersNumber 本期注册客户数
     */
    public void setCurrentPeriodRegisteredCustomersNumber(String currentPeriodRegisteredCustomersNumber) {
        this.currentPeriodRegisteredCustomersNumber = currentPeriodRegisteredCustomersNumber;
    }

    /**
     * 获取上期客户交易数
     *
     * @return last_period_transaction_customers_number - 上期客户交易数
     */
    public String getLastPeriodTransactionCustomersNumber() {
        return lastPeriodTransactionCustomersNumber;
    }

    /**
     * 设置上期客户交易数
     *
     * @param lastPeriodTransactionCustomersNumber 上期客户交易数
     */
    public void setLastPeriodTransactionCustomersNumber(String lastPeriodTransactionCustomersNumber) {
        this.lastPeriodTransactionCustomersNumber = lastPeriodTransactionCustomersNumber;
    }

    /**
     * 获取本期客户交易数
     *
     * @return current_period_transaction_customers_number - 本期客户交易数
     */
    public String getCurrentPeriodTransactionCustomersNumber() {
        return currentPeriodTransactionCustomersNumber;
    }

    /**
     * 设置本期客户交易数
     *
     * @param currentPeriodTransactionCustomersNumber 本期客户交易数
     */
    public void setCurrentPeriodTransactionCustomersNumber(String currentPeriodTransactionCustomersNumber) {
        this.currentPeriodTransactionCustomersNumber = currentPeriodTransactionCustomersNumber;
    }

    /**
     * 获取本期注册客户占比
     *
     * @return current_period_registered_customers_proportion - 本期注册客户占比
     */
    public String getCurrentPeriodRegisteredCustomersProportion() {
        return currentPeriodRegisteredCustomersProportion;
    }

    /**
     * 设置本期注册客户占比
     *
     * @param currentPeriodRegisteredCustomersProportion 本期注册客户占比
     */
    public void setCurrentPeriodRegisteredCustomersProportion(String currentPeriodRegisteredCustomersProportion) {
        this.currentPeriodRegisteredCustomersProportion = currentPeriodRegisteredCustomersProportion;
    }

    /**
     * 获取客户注册增长率
     *
     * @return customer_registration_growth_rate - 客户注册增长率
     */
    public String getCustomerRegistrationGrowthRate() {
        return customerRegistrationGrowthRate;
    }

    /**
     * 设置客户注册增长率
     *
     * @param customerRegistrationGrowthRate 客户注册增长率
     */
    public void setCustomerRegistrationGrowthRate(String customerRegistrationGrowthRate) {
        this.customerRegistrationGrowthRate = customerRegistrationGrowthRate;
    }

    /**
     * 获取本期交易客户占比
     *
     * @return current_period_transactions_customers_proportion - 本期交易客户占比
     */
    public String getCurrentPeriodTransactionsCustomersProportion() {
        return currentPeriodTransactionsCustomersProportion;
    }

    /**
     * 设置本期交易客户占比
     *
     * @param currentPeriodTransactionsCustomersProportion 本期交易客户占比
     */
    public void setCurrentPeriodTransactionsCustomersProportion(String currentPeriodTransactionsCustomersProportion) {
        this.currentPeriodTransactionsCustomersProportion = currentPeriodTransactionsCustomersProportion;
    }

    /**
     * 获取客户交易转换率
     *
     * @return customer_transaction_conversion_rate - 客户交易转换率
     */
    public String getCustomerTransactionConversionRate() {
        return customerTransactionConversionRate;
    }

    /**
     * 设置客户交易转换率
     *
     * @param customerTransactionConversionRate 客户交易转换率
     */
    public void setCustomerTransactionConversionRate(String customerTransactionConversionRate) {
        this.customerTransactionConversionRate = customerTransactionConversionRate;
    }

    /**
     * 获取本期客户AUM增长率(期末基准)
     *
     * @return current_period_customers_aum_growth_rate - 本期客户AUM增长率(期末基准)
     */
    public String getCurrentPeriodCustomersAumGrowthRate() {
        return currentPeriodCustomersAumGrowthRate;
    }

    /**
     * 设置本期客户AUM增长率(期末基准)
     *
     * @param currentPeriodCustomersAumGrowthRate 本期客户AUM增长率(期末基准)
     */
    public void setCurrentPeriodCustomersAumGrowthRate(String currentPeriodCustomersAumGrowthRate) {
        this.currentPeriodCustomersAumGrowthRate = currentPeriodCustomersAumGrowthRate;
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