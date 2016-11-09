package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.ClExtUser;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-9.
 */
@Service
public class ClExtUserService extends BaseService<ClExtUser> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClExtUserService.class);


    /**
     * 分页条件查询
     *
     * @param params
     * @return
     */
    public PageInfo<ClExtUser> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件查询外部拓展客户列表。。。");
        Example example = new Example(ClExtUser.class);
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
        List<ClExtUser> list = selectByExample(example);
        return new PageInfo<ClExtUser>(list);
    }

    public List<ClExtUser> findBySearch(String search) {
        return null;
    }
}
