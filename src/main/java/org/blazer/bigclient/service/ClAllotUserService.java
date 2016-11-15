package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.ClAllotUser;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-10.
 */
@Service
public class ClAllotUserService extends BaseService<ClAllotUser> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClAllotUserService.class);

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
        return new PageInfo<ClAllotUser>(list);
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


    public void assignToFormal(String advisorName, String ids) {

        if (StringUtils.isNotEmpty(advisorName) && StringUtils.isNotEmpty(ids)) {

            String[] idsArr = ids.split(",");
            for (int i = 0; i < idsArr.length; i++) {
                ClAllotUser clAllotUser = this.selectByKey(idsArr[i]);
                clAllotUser.setInvestmentAdviser(advisorName);
                clAllotUser.setUserIdentify("DHK0001");
                clAllotUser.setMtime(new Date());
                this.updateNotNull(clAllotUser);

                //保存到正式名单的表格

//TODO



            }

        }

    }
}
