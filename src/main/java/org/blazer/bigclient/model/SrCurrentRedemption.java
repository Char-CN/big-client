package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sr_current_redemption")
public class SrCurrentRedemption {
    /**
     * �Զ����
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * �ͻ�����
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * �ֻ�����
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * ��Ʒ����
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * ���ʱ��
     */
    @Column(name = "redemption_date")
    private String redemptionDate;

    /**
     * ��ؽ��
     */
    @Column(name = "redemption_amount")
    private String redemptionAmount;

    /**
     * Ͷ�ʹ���
     */
    @Column(name = "investment_advisor")
    private String investmentAdvisor;

    /**
     * ����ʱ��
     */
    private Date mtime;

    /**
     * ����ʱ��
     */
    private Date ctime;

    /**
     * ��ȡ�Զ����
     *
     * @return id - �Զ����
     */
    public Long getId() {
        return id;
    }

    /**
     * �����Զ����
     *
     * @param id �Զ����
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * ��ȡ�ͻ�����
     *
     * @return user_name - �ͻ�����
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ���ÿͻ�����
     *
     * @param userName �ͻ�����
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * ��ȡ�ֻ�����
     *
     * @return phone_number - �ֻ�����
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * �����ֻ�����
     *
     * @param phoneNumber �ֻ�����
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * ��ȡ��Ʒ����
     *
     * @return product_name - ��Ʒ����
     */
    public String getProductName() {
        return productName;
    }

    /**
     * ���ò�Ʒ����
     *
     * @param productName ��Ʒ����
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * ��ȡ���ʱ��
     *
     * @return redemption_date - ���ʱ��
     */
    public String getRedemptionDate() {
        return redemptionDate;
    }

    /**
     * �������ʱ��
     *
     * @param redemptionDate ���ʱ��
     */
    public void setRedemptionDate(String redemptionDate) {
        this.redemptionDate = redemptionDate;
    }

    /**
     * ��ȡ��ؽ��
     *
     * @return redemption_amount - ��ؽ��
     */
    public String getRedemptionAmount() {
        return redemptionAmount;
    }

    /**
     * ������ؽ��
     *
     * @param redemptionAmount ��ؽ��
     */
    public void setRedemptionAmount(String redemptionAmount) {
        this.redemptionAmount = redemptionAmount;
    }

    /**
     * ��ȡͶ�ʹ���
     *
     * @return investment_advisor - Ͷ�ʹ���
     */
    public String getInvestmentAdvisor() {
        return investmentAdvisor;
    }

    /**
     * ����Ͷ�ʹ���
     *
     * @param investmentAdvisor Ͷ�ʹ���
     */
    public void setInvestmentAdvisor(String investmentAdvisor) {
        this.investmentAdvisor = investmentAdvisor;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return mtime - ����ʱ��
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * ���ø���ʱ��
     *
     * @param mtime ����ʱ��
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return ctime - ����ʱ��
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * ���ô���ʱ��
     *
     * @param ctime ����ʱ��
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}