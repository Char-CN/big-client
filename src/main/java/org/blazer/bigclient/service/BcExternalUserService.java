package org.blazer.bigclient.service;

import java.util.List;

import org.blazer.bigclient.body.PageBody;
import org.blazer.bigclient.model.BcExternalUser;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * Created by cuican on 2016-8-26.
 */
@Service
public class BcExternalUserService extends BaseService<BcExternalUser> {

	public PageBody<BcExternalUser> findByPage(Integer currentPage, Integer pageSize) {
		PageBody<BcExternalUser> pb = new PageBody<BcExternalUser>();
		Example example = new Example(BcExternalUser.class);
		Page<BcExternalUser> page = PageHelper.startPage(currentPage, pageSize);
		List<BcExternalUser> list = selectByExample(example);
		pb.setCurrentPage(page.getPageNum());
		pb.setPageSize(page.getPageSize());
		pb.setTotal(page.getTotal());
		pb.setRst(list);
		return pb;
	}

}
