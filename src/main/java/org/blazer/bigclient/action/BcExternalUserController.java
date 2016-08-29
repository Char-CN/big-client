package org.blazer.bigclient.action;

import org.blazer.bigclient.service.BcExternalUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cuican on 2016-8-26.
 */
@RequestMapping("/ext")
@Controller
public class BcExternalUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcExternalUserController.class);

    @Autowired
    private BcExternalUserService bcExternalUserService;

    @ResponseBody
    @RequestMapping("list")
    public String listAllUserByPage(HttpServletRequest request, HttpServletResponse response){

        return null;
    }
}
