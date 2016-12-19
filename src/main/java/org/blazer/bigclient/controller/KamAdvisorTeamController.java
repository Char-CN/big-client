package org.blazer.bigclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.blazer.bigclient.model.KamAdvisorTeam;
import org.blazer.bigclient.service.KamAdvisorTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 投资组业务
 */
@RequestMapping("/advisor_team")
@Controller
@Slf4j
public class KamAdvisorTeamController extends BaseController {

    @Autowired
    private KamAdvisorTeamService kamAdvisorTeamService;

    /**
     * 查询所有投顾
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public List<KamAdvisorTeam> findAll() {
        Example example = new Example(KamAdvisorTeam.class);
        return kamAdvisorTeamService.selectByExample(example);
    }

}
