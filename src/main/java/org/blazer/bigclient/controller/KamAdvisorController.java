package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.body.AdvisorInfoBean;
import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.service.KamAdvisorService;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by yyccb on 2016-10-12.
 * 投资顾问相关
 */
@RequestMapping("/advisor")
@Controller
public class KamAdvisorController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(KamAdvisorController.class);

    @Autowired
    private KamAdvisorService kamAdvisorService;

    /**
     * 根据搜索条件分页查询
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findByPage")
    public PageInfo<AdvisorInfoBean> findByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return kamAdvisorService.findByPage(params);
    }

}
