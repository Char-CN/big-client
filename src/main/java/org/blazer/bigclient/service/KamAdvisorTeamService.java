package org.blazer.bigclient.service;

import lombok.extern.slf4j.Slf4j;
import org.blazer.bigclient.mapper.KamAdvisorTeamMapper;
import org.blazer.bigclient.model.KamAdvisorTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yyccb on 2016-10-12.
 */
@Service
@Slf4j
public class KamAdvisorTeamService extends BaseService<KamAdvisorTeam> {


    @Autowired
    private KamAdvisorTeamMapper kamAdvisorTeamMapper;

}
