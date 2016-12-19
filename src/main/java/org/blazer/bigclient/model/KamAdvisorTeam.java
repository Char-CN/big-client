package org.blazer.bigclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}