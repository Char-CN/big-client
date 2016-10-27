package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.SrAssetsBalance;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zizou on 16/10/27.
 */
@Service
public class SrAssetsBalanceService extends BaseService<SrAssetsBalance> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SrAssetsBalanceService.class);

    /**
     * 根据条件分页查询数据库中资产余额表中的字段
     *
     * @param params
     * @return
     */
    public PageInfo<SrAssetsBalance> findByPage(HashMap<String, String> params) {

        LOGGER.info("根据条件查询列表。。。");
        Example example = new Example(SrAssetsBalance.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<SrAssetsBalance> list = selectByExample(example);
        //这是要处理userInfo的字段



        return new PageInfo<SrAssetsBalance>(list);

    }
}
