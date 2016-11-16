package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.body.FormalUserBean;
import org.blazer.bigclient.mapper.ClFormalUserMapper;
import org.blazer.bigclient.model.ClFormalUser;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.LongUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-8.
 */
@Service
public class ClFormalUserService extends BaseService<ClFormalUser> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClFormalUserService.class);

    @Autowired
    private ClFormalUserMapper clFormalUserMapper;

    /**
     * 根据手机号查询单个客户
     *
     * @param phoneNumber
     * @return
     */
    public ClFormalUser selectByPhoneNumber(Long phoneNumber) {
        LOGGER.debug("根据手机号：" + phoneNumber + ",查询单个正式客户。");
        Example example = new Example(ClFormalUser.class);
        Example.Criteria criteria = example.createCriteria();
        Long phoneNo = LongUtil.getLongZero(phoneNumber);
        criteria.andEqualTo("phoneNumber", phoneNo);
        List<ClFormalUser> clFormalUsers = this.selectByExample(example);
        ClFormalUser user = null;
        if (clFormalUsers != null && clFormalUsers.size() != 0) {
            user = clFormalUsers.get(0);
        }
        return user;
    }

    /**
     * 首页列表
     *
     * @param params
     * @return
     */
    public PageInfo<FormalUserBean> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件查询正式客户【ClFormalUser】列表。。。");

        String search = StringUtil.getStrEmpty(params.get("search"));
        String dateStart = StringUtil.getStrEmpty(params.get("dateStart"));
        if(StringUtils.isEmpty(dateStart)){
            dateStart="1900-01-01";
        }
        String dateEnd = StringUtil.getStrEmpty(params.get("dateEnd"));
        if(StringUtils.isEmpty(dateEnd)){
            dateEnd = DateUtil.thisDate();
        }

        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));

        List<FormalUserBean> list = this.clFormalUserMapper.selectMaxVersionList(search,dateStart,dateEnd);

        return new PageInfo<FormalUserBean>(list);
    }

    /**
     * 条件查询，excel导出
     *
     * @param search
     * @return
     */
    public List<ClFormalUser> findBySearch(String search) {
        LOGGER.info("根据条件查询正式客户【ClFormalUser】数据，导出到excel表。");
        Example example = new Example(ClFormalUser.class);
        Example.Criteria criteria = example.createCriteria();
        String search_text = StringUtil.getStrEmpty(search);
        if (StringUtils.isNotEmpty(search_text)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        criteria.andEqualTo("ifDelete", 0);
        return selectByExample(example);
    }
}
