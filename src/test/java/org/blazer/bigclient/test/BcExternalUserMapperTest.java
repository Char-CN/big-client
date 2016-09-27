package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.BcExternalUserBackupMapper;
import org.blazer.bigclient.mapper.BcExternalUserMapper;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.model.BcExternalUserBackup;
import org.blazer.bigclient.util.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/**
 * Created by cuican on 2016-9-23.
 */
public class BcExternalUserMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void addUserTest() {
        //获取mapper
        BcExternalUserMapper userMapper = sqlSession.getMapper(BcExternalUserMapper.class);
        BcExternalUserBackupMapper externalUserBackupMapper = sqlSession.getMapper(BcExternalUserBackupMapper.class);
        //批量添加用户
        for (int i = 0; i < 200; i++) {
            BcExternalUser user = new BcExternalUser();

            if(i % 2 == 0){
                user.setPhoneNumber(18899990000L + i);
                user.setSysName("刘备"+i);
                user.setSysIfRegister("是");
                user.setSysRegisterDate(DateUtil.thisDate());
                user.setSysIfRealName("是");
                user.setSysIfBindCard("是");
                user.setSysIfTransaction("是");
                user.setSysReferrer("张飞"+i);
                user.setSysRebateExpirationDate(DateUtil.thisDate());
            }else {
                user.setPhoneNumber(16699990000L + i);
                user.setSysName("关羽"+i);
                user.setSysIfRegister("否");
                user.setSysRegisterDate(DateUtil.thisDate());
                user.setSysIfRealName("否");
                user.setSysIfBindCard("否");
                user.setSysIfTransaction("否");
                user.setSysReferrer("赵云"+i);
                user.setSysRebateExpirationDate(DateUtil.thisDate());
            }
//            String s = "";
//            Random random = new Random();
//            s += random.nextInt(9) + 1;
//            for (int j = 0; j < 18 - 1; j++) {
//                s += random.nextInt(10);
//            }
            user.setExcelId(0L);
            user.setMtime(DateUtil.getFirstDateOfMonth(new Date()));
            user.setCtime(user.getMtime());
            userMapper.insert(user);
            BcExternalUserBackup bcExternalUserBackup = new BcExternalUserBackup();
            bcExternalUserBackup.setPhoneNumber(user.getPhoneNumber());
            bcExternalUserBackup.setExcelId(0L);
            bcExternalUserBackup.setCtime(user.getMtime());
            bcExternalUserBackup.setMtime(user.getMtime());
            externalUserBackupMapper.insert(bcExternalUserBackup);
        }


    }

    /**
     * 产生18位的随机数
     * @param a
     */
    public static void main(String[] a) {
        String s = "";
        Random random = new Random();
        s += random.nextInt(9) + 1;
        for (int i = 0; i < 18 - 1; i++) {
            s += random.nextInt(10);
            System.out.println("s = " + s);
        }
        BigInteger bigInteger = new BigInteger(s);
        System.out.println(bigInteger);
    }

}
