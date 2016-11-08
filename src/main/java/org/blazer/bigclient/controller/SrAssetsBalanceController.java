package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.model.SrAssetsBalance;
import org.blazer.bigclient.service.SrAssetsBalanceService;
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
 * Created by zizou on 16/10/27.
 */
@RequestMapping("/sr/assets_balance")
@Controller
public class SrAssetsBalanceController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SrAssetsBalanceController.class);

    @Autowired
    private SrAssetsBalanceService srAssetsBalanceService;


    /**
     * 根据搜索条件分页查询
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findByPage")
    public PageInfo<SrAssetsBalance> findByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return srAssetsBalanceService.findByPage(params);
    }




}
