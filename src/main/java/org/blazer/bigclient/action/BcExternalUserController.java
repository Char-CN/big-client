package org.blazer.bigclient.action;

import org.blazer.bigclient.service.BcExternalUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cuican on 2016-8-26.
 */
@Controller
public class BcExternalUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcExternalUserController.class);

    @Autowired
    private BcExternalUserService bcExternalUserService;


}
