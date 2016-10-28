package org.blazer.bigclient.util;

import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.service.KamAdvisorService;
import org.blazer.userservice.core.filter.PermissionsFilter;
import org.blazer.userservice.core.model.SessionModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yyccb on 2016-10-28.
 */
public class JudgePermissions {

    @Autowired
    private static KamAdvisorService kamAdvisorService;

    /**
     * 判断当前登录用户是否为投资顾问
     *
     * @param request
     * @return
     */
    public static KamAdvisor getAdvisorByCookie(HttpServletRequest request) {
        SessionModel model = PermissionsFilter.getSessionModel(request);
        String userName = model.getUserName();
        String phoneNumber = model.getPhoneNumber();
        KamAdvisor advisor = new KamAdvisor();
        advisor.setSystemName(userName);
        advisor.setPhoneNumber(phoneNumber);
        return kamAdvisorService.selcetOne(advisor);
    }

    /**
     * 获取当前投资顾问的用户名
     *
     * @param request
     * @return
     */
    public static String getAdvisorNameByCookie(HttpServletRequest request) {
        SessionModel model = PermissionsFilter.getSessionModel(request);
        String userName = model.getUserName();
        String phoneNumber = model.getPhoneNumber();
        KamAdvisor advisor = new KamAdvisor();
        advisor.setSystemName(userName);
        advisor.setPhoneNumber(phoneNumber);
        KamAdvisor kamAdvisor = kamAdvisorService.selcetOne(advisor);
        return kamAdvisor == null ? null : kamAdvisor.getActualName();
    }


}
