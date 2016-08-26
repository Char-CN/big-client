package org.blazer.bigclient.model;

import java.util.Date;

public class BcWaitAllotUser {
    private Long id;

    private String userName;

    private Long phoneNumber;

    private String registerDate;

    private String idCard;

    private String ifEmployee;

    private String assetsAmount;

    private String sex;

    private String age;

    private String birthday;

    private String referrer;

    private String referrerPhoneNumber;

    private String ifReferrerEmployee;

    private Date mtime;

    private Date ctime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIfEmployee() {
        return ifEmployee;
    }

    public void setIfEmployee(String ifEmployee) {
        this.ifEmployee = ifEmployee;
    }

    public String getAssetsAmount() {
        return assetsAmount;
    }

    public void setAssetsAmount(String assetsAmount) {
        this.assetsAmount = assetsAmount;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getReferrerPhoneNumber() {
        return referrerPhoneNumber;
    }

    public void setReferrerPhoneNumber(String referrerPhoneNumber) {
        this.referrerPhoneNumber = referrerPhoneNumber;
    }

    public String getIfReferrerEmployee() {
        return ifReferrerEmployee;
    }

    public void setIfReferrerEmployee(String ifReferrerEmployee) {
        this.ifReferrerEmployee = ifReferrerEmployee;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}