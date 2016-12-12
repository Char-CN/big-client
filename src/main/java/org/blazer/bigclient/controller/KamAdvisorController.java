package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.blazer.bigclient.body.AdvisorInfoBean;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.service.KamAdvisorService;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.LongUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yyccb on 2016-10-12.
 * 投资顾问相关
 */
@RequestMapping("/advisor")
@Controller
@Slf4j
public class KamAdvisorController extends BaseController {

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
        log.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return kamAdvisorService.findByPage(params);
    }

    /**
     * 查询所有投顾
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public List<KamAdvisor> findAll(){
        Example example = new Example(KamAdvisor.class);
        return kamAdvisorService.selectByExample(example);
    }


    /**
     * 单个保存
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveOne", method = RequestMethod.POST)
    public AjaxResult saveOne(HttpServletRequest request) {

        AjaxResult result = AjaxResult.success("保存投顾信息成功...");

        //获取前台页面传递的参数
        Long id = LongUtil.getLongZero(request.getParameter("id"));
        String serialNumber = StringUtil.getStrEmpty(request.getParameter("serialNumber"));
        String level = StringUtil.getStrEmpty(request.getParameter("level"));
        String systemName = StringUtil.getStrEmpty(request.getParameter("systemName"));
        String actualName = StringUtil.getStrEmpty(request.getParameter("actualName"));
        String phoneNumber = StringUtil.getStrEmpty(request.getParameter("phoneNumber"));
        String email = StringUtil.getStrEmpty(request.getParameter("email"));
        String teamName = StringUtil.getStrEmpty(request.getParameter("teamName"));
        String teamLeaderName = StringUtil.getStrEmpty(request.getParameter("teamLeaderName"));
        String totalNumber = StringUtil.getStrEmpty(request.getParameter("totalNumber"));
        String area = StringUtil.getStrEmpty(request.getParameter("area"));

        log.debug("当前保存的投顾的姓名是 :" + actualName);

        /*String userName = StringUtil.getStrEmpty(request.getParameter("userName"));
        String remark = StringUtil.getStrEmpty(request.getParameter("remark"));*/
        /*//获取当前登录用户
        KamAdvisor advisor = super.getCurrentUser(request);
        //判断当前登录用户如果为投顾,则添加投顾真实姓名作为查询参数
        if (advisor != null) {
            investmentAdviser = advisor.getActualName();
        }*/

        try {
            //查询该投顾编号是否存在
            Boolean flag = this.kamAdvisorService.selectBySerialNumber(serialNumber);

            // 如果id为空，则是新增，不为空，则为修改
            if (id == 0L && !flag) {
                //构建ClExtUserBak对象
                KamAdvisor advisor = new KamAdvisor();
                advisor.setSerialNumber(serialNumber);
                advisor.setLevel(level);
                advisor.setSystemName(systemName);
                advisor.setActualName(actualName);
                advisor.setPhoneNumber(phoneNumber);
                advisor.setRemark(email);
                advisor.setCtime(new Date());
                //保存到数据库
                this.kamAdvisorService.saveOne(advisor,teamName);
            } else {
                //修改用户，先根据id查询到客户
                KamAdvisor advisor = this.kamAdvisorService.selectByKey(id);
                advisor.setSerialNumber(serialNumber);
                advisor.setLevel(level);
                advisor.setSystemName(systemName);
                advisor.setActualName(actualName);
                advisor.setPhoneNumber(phoneNumber);
                advisor.setRemark(email);
                advisor.setMtime(new Date());
                this.kamAdvisorService.updateOne(advisor,teamName);
            }
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("保存客户信息失败..." + e.getMessage());
            e.printStackTrace();
        }
        log.debug("返回页面的结果对象：" + result);
        return result;
    }

}
