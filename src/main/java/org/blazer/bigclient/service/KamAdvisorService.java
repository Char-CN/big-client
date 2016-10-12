package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yyccb on 2016-10-12.
 */
@Service
public class KamAdvisorService extends BaseService<KamAdvisor> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KamAdvisorService.class);

    public PageInfo<KamAdvisor> findByPage(HashMap<String, String> params) {
        Example example = new Example(KamAdvisor.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        criteria.andEqualTo("ifDelete", 0);
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<KamAdvisor> list = selectByExample(example);
        return new PageInfo<KamAdvisor>(list);
    }
}
