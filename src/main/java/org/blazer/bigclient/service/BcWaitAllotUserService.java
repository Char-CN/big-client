package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.BcWaitAllotUser;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yyccb on 2016-9-27.
 */
@Service
public class BcWaitAllotUserService extends BaseService<BcWaitAllotUser> {

    /**
     * 分页条件查询用户列表
     *
     * @param params
     * @return
     */
    public PageInfo<BcWaitAllotUser> findByPage(HashMap<String, String> params) {
        Example example = new Example(BcWaitAllotUser.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<BcWaitAllotUser> list = selectByExample(example);
        return new PageInfo<BcWaitAllotUser>(list);
    }

    /**
     * 根据条件查询用户集合，
     * 用于前台页面的Excel导出
     *
     * @param search
     * @return
     */
    public List<BcWaitAllotUser> findBySearch(String search) {
        Example example = new Example(BcWaitAllotUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        List<BcWaitAllotUser> list = selectByExample(example);
        return list;
    }
}
