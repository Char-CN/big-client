package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cl_formal_user_version")
public class ClFormalUserVersion {
    /**
     * 自动编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 客户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 投顾ID
     */
    @Column(name = "advisor_id")
    private Long advisorId;

    /**
     * 版本号:默认是1，依次递增
     */
    @Column(name = "version_no")
    private String versionNo;

    /**
     * 分配起始日期
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 分配结束日期，为NULL值表示没有结束日期
     */
    @Column(name = "end_date")
    private Date endDate;

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
     * 获取客户ID
     *
     * @return user_id - 客户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置客户ID
     *
     * @param userId 客户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取投顾ID
     *
     * @return advisor_id - 投顾ID
     */
    public Long getAdvisorId() {
        return advisorId;
    }

    /**
     * 设置投顾ID
     *
     * @param advisorId 投顾ID
     */
    public void setAdvisorId(Long advisorId) {
        this.advisorId = advisorId;
    }

    /**
     * 获取版本号:默认是1，依次递增
     *
     * @return version_no - 版本号:默认是1，依次递增
     */
    public String getVersionNo() {
        return versionNo;
    }

    /**
     * 设置版本号:默认是1，依次递增
     *
     * @param versionNo 版本号:默认是1，依次递增
     */
    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    /**
     * 获取分配起始日期
     *
     * @return start_date - 分配起始日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置分配起始日期
     *
     * @param startDate 分配起始日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取分配结束日期，为NULL值表示没有结束日期
     *
     * @return end_date - 分配结束日期，为NULL值表示没有结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置分配结束日期，为NULL值表示没有结束日期
     *
     * @param endDate 分配结束日期，为NULL值表示没有结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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