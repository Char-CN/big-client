package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.ClExtUser;
import org.blazer.bigclient.model.SrAssetsBalance;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-16.
 */
@Service
public class SrAssetsBalanceService extends BaseService<SrAssetsBalance> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SrAssetsBalanceService.class);

    public PageInfo<SrAssetsBalance> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件查询：资产余额[SrAssetsBalance]列表...");
        Example example = new Example(SrAssetsBalance.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        //AUM时间点
        String dateStart = StringUtil.getStrEmpty(params.get("dateStart"));
        if (StringUtils.isNotEmpty(dateStart)) {
            //处理时间格式，添加时分秒
            String dateStart_front = dateStart + " 00:00:00";
            String dateStart_back = dateStart + " 23:59:59";
            criteria.andGreaterThanOrEqualTo("aumTimePoint", dateStart_front);
            criteria.andLessThanOrEqualTo("aumTimePoint", dateStart_back);
        }
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<SrAssetsBalance> list = selectByExample(example);
        return new PageInfo(list);
    }

    public List<SrAssetsBalance> findBySearch(HashMap<String, String> params) {
        LOGGER.info("根据条件查询：资产余额[SrAssetsBalance]，导出到excel表...");
        Example example = new Example(SrAssetsBalance.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        //AUM时间点
        String dateStart = StringUtil.getStrEmpty(params.get("dateStart"));
        if (StringUtils.isNotEmpty(dateStart)) {
            String dateStart_front = dateStart + " 00:00:00";
            String dateStart_back = dateStart + " 23:59:59";
            criteria.andGreaterThanOrEqualTo("aumTimePoint", dateStart_front);
            criteria.andLessThanOrEqualTo("aumTimePoint", dateStart_back);
        }
        return selectByExample(example);
    }

    public List<SrAssetsBalance> findByMonthly(String data) {
        LOGGER.info("月初AUM报表导出：资产余额[SrAssetsBalance]，导出到excel表...");
        Example example = new Example(SrAssetsBalance.class);
        Example.Criteria criteria = example.createCriteria();
        String date = StringUtil.getStrEmpty(data);
        if (StringUtils.isNotEmpty(date)) {
            String s = date + "-01";
            criteria.andCondition(s + " = date(ctime)");
        }
        return selectByExample(example);
    }
}
