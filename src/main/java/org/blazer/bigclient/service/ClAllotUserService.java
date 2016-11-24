package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.ClAllotUser;
import org.blazer.bigclient.model.ClFormalUser;
import org.blazer.bigclient.model.ClFormalUserVersion;
import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-10.
 */
@Service
public class ClAllotUserService extends BaseService<ClAllotUser> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClAllotUserService.class);

    @Autowired
    private ClFormalUserService clFormalUserService;

    @Autowired
    private ClFormalUserVersionService clFormalUserVersionService;

    @Autowired
    private KamAdvisorService kamAdvisorService;

    public PageInfo<ClAllotUser> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件查询平台待分配客户列表。。。");
        Example example = new Example(ClAllotUser.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        String advisorName = StringUtil.getStrEmpty(params.get("advisorName"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        if (StringUtils.isNotEmpty(advisorName)) {
            //此处为实体类的属性，不是表字段
            criteria.andEqualTo("investmentAdviser", advisorName);
        }
        criteria.andEqualTo("ifDelete", 0);
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<ClAllotUser> list = selectByExample(example);
        return new PageInfo<>(list);
    }

    public List<ClAllotUser> findBySearch(String search) {
        LOGGER.info("根据条件查询外部拓展客户数据，导出到excel表。");
        Example example = new Example(ClAllotUser.class);
        Example.Criteria criteria = example.createCriteria();
        String search_text = StringUtil.getStrEmpty(search);
        if (StringUtils.isNotEmpty(search_text)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        criteria.andEqualTo("ifDelete", 0);
        return selectByExample(example);
    }


    public Boolean assignToFormal(String advisorId, String ids) {

        Boolean flag = false;

        if (StringUtils.isNotEmpty(advisorId) && StringUtils.isNotEmpty(ids)) {

            try {
                KamAdvisor advisor = this.kamAdvisorService.selectByKey(Long.parseLong(advisorId));
                if(advisor == null){
                    return flag;
                }
                String[] idsArr = ids.split(",");
                for (int i = 0; i < idsArr.length; i++) {

                    ClAllotUser clAllotUser = this.selectByKey(Long.parseLong(idsArr[i]));
                    clAllotUser.setInvestmentAdviser(advisor.getActualName());
                    clAllotUser.setUserIdentify("DKH001");
                    clAllotUser.setMtime(new Date());
                    this.updateNotNull(clAllotUser);

                    //保存到正式名单表
                    ClFormalUser clFormalUser = new ClFormalUser();
                    clFormalUser.setPhoneNumber(clAllotUser.getPhoneNumber());
                    clFormalUser.setReportOrAllot("分配");
                    clFormalUser.setReportOrAllotDate(DateUtil.thisDate());
                    clFormalUser.setUserIdentify("DHK0001");
                    clFormalUser.setIfDelete(0);
                    clFormalUser.setCtime(new Date());
                    this.clFormalUserService.save(clFormalUser);

                    //保存到版本表
                    ClFormalUserVersion clFormalUserVersion = new ClFormalUserVersion();
                    clFormalUserVersion.setUserId(clFormalUser.getId());
                    clFormalUserVersion.setAdvisorId(Long.parseLong(advisorId));
                    clFormalUserVersion.setVersionNo("1");
                    clFormalUserVersion.setStartDate(DateUtil.str2Date(clFormalUser.getReportOrAllotDate()));
                    clFormalUserVersion.setCtime(new Date());
                    this.clFormalUserVersionService.save(clFormalUserVersion);
                }
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
