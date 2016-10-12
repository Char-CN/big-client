package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.model.KamUserInfo;
import org.blazer.bigclient.service.KamUserInfoService;
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
 * Created by yyccb on 2016-10-11.
 */
@RequestMapping("/user")
@Controller
public class KamUserInfoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KamUserInfoController.class);

    @Autowired
    private KamUserInfoService kamUserInfoService;




    /**
     * 根据搜索条件分页查询
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findUserByPage")
    public PageInfo<KamUserInfo> findUserByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return kamUserInfoService.findUserByPage(params);
    }


    /**外部拓展客户*/




    /**平台待分配客户*/





    /**正式客户*/




}
