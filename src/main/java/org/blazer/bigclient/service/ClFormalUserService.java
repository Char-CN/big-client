package org.blazer.bigclient.service;

import org.blazer.bigclient.model.ClFormalUser;
import org.blazer.bigclient.util.LongUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by cuican on 2016-11-8.
 */
@Service
public class ClFormalUserService extends BaseService<ClFormalUser> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClFormalUserService.class);

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
}
