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
     * 客户的自动编号=kamUserInfo.id
     */
    private Long uid;

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
     * 获取客户的自动编号=kamUserInfo.id
     *
     * @return uid - 客户的自动编号=kamUserInfo.id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置客户的自动编号=kamUserInfo.id
     *
     * @param uid 客户的自动编号=kamUserInfo.id
     */
    public void setUid(Long uid) {
        this.uid = uid;
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
}