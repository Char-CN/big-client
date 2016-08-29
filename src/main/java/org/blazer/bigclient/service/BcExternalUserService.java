package org.blazer.bigclient.service;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.body.PageBody;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * Created by cuican on 2016-8-26.
 */
@Service
public class BcExternalUserService extends BaseService<BcExternalUser> {

	public PageBody<BcExternalUser> findByPage(HashMap<String, String> params) {
		PageBody<BcExternalUser> pb = new PageBody<BcExternalUser>();
		Example example = new Example(BcExternalUser.class);
		Criteria criteria = example.createCriteria();
		String search = StringUtil.getStrEmpty(params.get("search"));
		if (StringUtils.isNotEmpty(search)) {
			criteria.andCondition("phone_number like '%" + search + "%'" + " or sys_name like '%" + search + "%'");
		}
		Page<BcExternalUser> page = PageHelper.startPage(IntegerUtil.getInt0(params.get("currentPage")), IntegerUtil.getInt0(params.get("pageSize")));
		List<BcExternalUser> list = selectByExample(example);
		pb.setCurrentPage(page.getPageNum());
		pb.setPageSize(page.getPageSize());
		pb.setTotal(page.getTotal());
		pb.setRst(list);
		return pb;
	}

}
