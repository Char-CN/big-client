package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.KamUserInfo;
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
public class KamUserInfoService extends BaseService<KamUserInfo> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KamUserInfoService.class);

    public PageInfo<KamUserInfo> findUserByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件查询客户列表。。。");
        Example example = new Example(KamUserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        String userIdentify = StringUtil.getStrEmpty(params.get("userIdentify"));
        String ifReportOrAllot = StringUtil.getStrEmpty(params.get("ifReportOrAllot"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        if (StringUtils.isNotEmpty(userIdentify)) {
            //通过客户标识DKH000，DHK001区别客户类别
            criteria.andEqualTo("userIdentify", userIdentify);
        }
        if (StringUtils.isNotEmpty(ifReportOrAllot)) {
            criteria.andEqualTo("ifReportOrAllot", ifReportOrAllot);
        }
        criteria.andEqualTo("ifDelete", 0);
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<KamUserInfo> list = selectByExample(example);
        return new PageInfo<KamUserInfo>(list);
    }


    /**
     * 外部拓展客户
     */


    /**
     * 平台待分配客户
     */


    /**正式客户*/
}
