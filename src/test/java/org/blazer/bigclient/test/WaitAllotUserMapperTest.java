package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.BcWaitAllotUserMapper;
import org.blazer.bigclient.model.BcWaitAllotUser;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.RandomNumUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/**
 * Created by cuican on 2016-9-23.
 */
public class WaitAllotUserMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void addUserTest() {
        //获取mapper
        BcWaitAllotUserMapper userMapper = sqlSession.getMapper(BcWaitAllotUserMapper.class);
        //批量添加用户
        for (int i = 0; i < 200; i++) {
            BcWaitAllotUser user = new BcWaitAllotUser();
            /**<field name="id" title="自动编号"/>
             <field name="userName" title="客户名称"/>
             <field name="phoneNumber" title="手机号码"/>
             <field name="registerDate" title="注册日期"/>
             <field name="idCard" title="身份证号"/>
             <field name="ifEmployee" title="是否员工"/>
             <field name="assetsAmount" title="资产余额"/>
             <field name="sex" title="性别"/>
             <field name="age" title="年龄"/>
             <field name="birthday" title="出生日期"/>
             <field name="referrer" title="邀请人"/>
             <field name="referrerPhoneNumber" title="邀请人手机号"/>
             <field name="ifReferrerEmployee" title="邀请人是否员工"/>
             <field name="mtime" title="更新时间" pattern="yyyy-MM-dd HH:mm:ss"/>
             <field name="ctime" title="创建时间" pattern="yyyy-MM-dd HH:mm:ss"/>*/
            if (i % 2 == 0) {
                user.setUserName("曹操" + i);
                user.setIfEmployee("是");
                user.setSex("男");
                user.setReferrer("司马懿" + i);
                user.setIfReferrerEmployee("否");
            } else {
                user.setUserName("孙权" + i);
                user.setIfEmployee("否");
                user.setSex("女");
                user.setReferrer("周瑜" + i);
                user.setIfReferrerEmployee("是");
            }
            user.setPhoneNumber(RandomNumUtil.randomPhoneNumber());
            user.setAssetsAmount(RandomNumUtil.randomAssetNo());
            user.setAge(RandomNumUtil.randomAgeNo());
            user.setReferrerPhoneNumber(RandomNumUtil.randomPhoneNo());
            user.setIdCard(RandomNumUtil.randomIDNo());
            user.setRegisterDate(DateUtil.thisDate());
            user.setBirthday(DateUtil.thisDate());
            user.setMtime(DateUtil.getFirstDateOfMonth(new Date()));
            user.setCtime(user.getMtime());
            userMapper.insert(user);

        }

    }

}
