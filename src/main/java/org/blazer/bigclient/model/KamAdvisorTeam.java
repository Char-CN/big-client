package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "kam_advisor_team")
public class KamAdvisorTeam {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 团队名称
     */
    @Column(name = "team_name")
    private String teamName;

    /**
     * 团队长ID（= advisor.id）
     */
    @Column(name = "team_leader_id")
    private Long teamLeaderId;

    /**
     * 团队人数
     */
    @Column(name = "total_number")
    private Integer totalNumber;

    /**
     * 区域
     */
    private String area;

    /**
     * 备注
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
     * 获取团队名称
     *
     * @return team_name - 团队名称
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * 设置团队名称
     *
     * @param teamName 团队名称
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * 获取团队长ID（= advisor.id）
     *
     * @return team_leader_id - 团队长ID（= advisor.id）
     */
    public Long getTeamLeaderId() {
        return teamLeaderId;
    }

    /**
     * 设置团队长ID（= advisor.id）
     *
     * @param teamLeaderId 团队长ID（= advisor.id）
     */
    public void setTeamLeaderId(Long teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    /**
     * 获取团队人数
     *
     * @return total_number - 团队人数
     */
    public Integer getTotalNumber() {
        return totalNumber;
    }

    /**
     * 设置团队人数
     *
     * @param totalNumber 团队人数
     */
    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * 获取区域
     *
     * @return area - 区域
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区域
     *
     * @param area 区域
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
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
        return "KamAdvisorTeam{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", teamLeaderId=" + teamLeaderId +
                ", totalNumber=" + totalNumber +
                ", area='" + area + '\'' +
                ", remark='" + remark + '\'' +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}