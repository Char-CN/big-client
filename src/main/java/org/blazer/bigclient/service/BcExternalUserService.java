package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.BcExcel;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.model.BcExternalUserBackup;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-8-26.
 */
@Service
public class BcExternalUserService extends BaseService<BcExternalUser> {

    /**
     * 分页条件查询用户列表
     *
     * @param params
     * @return
     */
    public PageInfo<BcExternalUser> findByPage(HashMap<String, String> params) {
        Example example = new Example(BcExternalUser.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or sys_name like '%" + search + "%'");
        }
        PageHelper.startPage(IntegerUtil.getInt0(params.get("currentPage")), IntegerUtil.getInt0(params.get("pageSize")));
        List<BcExternalUser> list = selectByExample(example);
        return new PageInfo<BcExternalUser>(list);
    }



}
