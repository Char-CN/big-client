package org.blazer.bigclient.body;

/**
 * Created by cuican on 2016-11-18.
 */
public class AdvisorInfoBean {

    private Long id;
    private Long tid;
    private String serialNumber;
    private String level;
    private String systemName;
    private String actualName;
    private String phoneNumber;
    private String email;
    private String teamName;
    private Long teamLeaderId;
    private String teamLeaderName;
    private Integer totalNumber;
    private String area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Long teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public String getTeamLeaderName() {
        return teamLeaderName;
    }

    public void setTeamLeaderName(String teamLeaderName) {
        this.teamLeaderName = teamLeaderName;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "AdvisorInfoBean{" +
                "id=" + id +
                ", tid=" + tid +
                ", serialNumber='" + serialNumber + '\'' +
                ", level='" + level + '\'' +
                ", systemName='" + systemName + '\'' +
                ", actualName='" + actualName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", teamName='" + teamName + '\'' +
                ", teamLeaderId=" + teamLeaderId +
                ", teamLeaderName='" + teamLeaderName + '\'' +
                ", totalNumber=" + totalNumber +
                ", area='" + area + '\'' +
                '}';
    }
}
