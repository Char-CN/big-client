package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.ClAllotUserMapper;
import org.blazer.bigclient.model.ClAllotUser;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.RandomNumUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class ClAllotUserMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void addTest() {
        ClAllotUserMapper mapper = sqlSession.getMapper(ClAllotUserMapper.class);

        ArrayList<ClAllotUser> list = new ArrayList<>();

        for (int i = 1; i <= 55; i++) {
            ClAllotUser user = new ClAllotUser();

            user.setPhoneNumber(RandomNumUtil.randomPhoneNumber());
            user.setRegisterDate(DateUtil.thisDate());
            user.setIdCard(RandomNumUtil.randomIDNo());
            user.setAssetsAmount(RandomNumUtil.randomAssetNo());
            user.setAge(RandomNumUtil.randomAgeNo());
            user.setBirthday(DateUtil.date2Str(DateUtil.getFirstDateOfMonth(new Date()), DateUtil.DEFAULT_DATE_FORMAT));
            user.setReferrerPhoneNumber(RandomNumUtil.randomPhoneNo());
            user.setUserIdentify("DHK0001");
            user.setIfDelete(0);
            user.setCtime(new Date());
            user.setMtime(user.getCtime());

            if (i % 2 == 0) {
                user.setUserName("李四" + i);
                user.setIfEmployee("是");
                user.setSex("男");
                user.setReferrer("关羽" + i);
                user.setIfReferrerEmployee("否");
                user.setInvestmentAdviser("张辉胜");

            } else if (i % 3 == 0) {
                user.setUserName("王五" + i);
                user.setIfEmployee("否");
                user.setSex("女");
                user.setReferrer("张飞" + i);
                user.setIfReferrerEmployee("否");
                user.setInvestmentAdviser("毛慧芳");
            } else {
                user.setUserName("张三" + i);
                user.setIfEmployee("是");
                user.setSex("男");
                user.setReferrer("刘备" + i);
                user.setIfReferrerEmployee("是");
                user.setInvestmentAdviser("何朵");
            }

            if (i % 10 == 0) {
                user.setIfDelete(1);
            }

            list.add(user);
        }

        mapper.insertList(list);
    }


}
