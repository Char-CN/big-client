package org.blazer.bigclient.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.mapper.KamAdvisorTeamMapper;
import org.blazer.bigclient.model.KamAdvisorTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yyccb on 2016-10-12.
 */
@Service
@Slf4j
public class KamAdvisorTeamService extends BaseService<KamAdvisorTeam> {

    /**
     * 根据teamName，查询投顾组
     *
     * @return
     */
    public KamAdvisorTeam selectByName(String teamName) {
        log.info("投顾组的查询条件[投顾组名称]为：" + teamName);
        Example example = new Example(KamAdvisorTeam.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(teamName)) {
            criteria.andEqualTo("teamName", teamName);
        }
        List<KamAdvisorTeam> list = this.selectByExample(example);
        if (list != null || list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
