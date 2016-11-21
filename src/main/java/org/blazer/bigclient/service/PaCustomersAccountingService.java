package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.PaCurrentSalesScaleAccounting;
import org.blazer.bigclient.model.PaCustomersAccounting;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-21.
 */
@Service
public class PaCustomersAccountingService extends BaseService<PaCustomersAccounting> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaCustomersAccountingService.class);

    public PageInfo<PaCustomersAccounting> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件分页查询：获客数核算<PaCustomersAccounting>列表...");
        Example example = new Example(PaCustomersAccounting.class);
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
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<PaCustomersAccounting> list = this.selectByExample(example);
        return new PageInfo(list);
    }

    public List<PaCustomersAccounting> findBySearch(String search) {
        LOGGER.info("根据条件查询：获客数核算<PaCustomersAccounting>，导出到excel表...");
        Example example = new Example(PaCustomersAccounting.class);
        Example.Criteria criteria = example.createCriteria();
        String search_text = StringUtil.getStrEmpty(search);
        if (StringUtils.isNotEmpty(search_text)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        return this.selectByExample(example);
    }

}
