package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.BcFormalUserMapper;
import org.blazer.bigclient.model.BcFormalUser;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.RandomNumUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by cuican on 2016-9-23.
 */
public class BcFormalUserMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void addUserTest() {
        //获取mapper
        BcFormalUserMapper userMapper = sqlSession.getMapper(BcFormalUserMapper.class);
        //批量添加用户
        for (int i = 0; i < 200; i++) {
            BcFormalUser user = new BcFormalUser();
            /**<field name="id" title="自动编号"/>
             <field name="excelId" title="所属excel编号"/>
             <field name="phoneNumber" title="手机号码"/>
             <field name="reportOrAllot" title="上报/分配"/>
             <field name="reportOrAllotDate" title="上报/分配时间"/>
             <field name="investmentAdviser" title="投资顾问"/>
             <field name="userIdentify" title="客户标识"/>
             <field name="mtime" title="更新时间" pattern="yyyy-MM-dd HH:mm:ss"/>
             <field name="ctime" title="创建时间" pattern="yyyy-MM-dd HH:mm:ss"/>*/
            if (i % 2 == 0) {
                user.setReportOrAllot("上报");
                user.setInvestmentAdviser("诸葛孔明"+i);
            } else {
                user.setReportOrAllot("分配");
                user.setInvestmentAdviser("庞统凤雏"+i);
            }
            user.setExcelId(0L);
            user.setPhoneNumber(RandomNumUtil.randomPhoneNumber());
            user.setReportOrAllotDate(DateUtil.thisDate());
            user.setUserIdentify(RandomNumUtil.randomAssetNo());
            user.setMtime(DateUtil.getFirstDateOfMonth(new Date()));
            user.setCtime(user.getMtime());
            userMapper.insert(user);

        }

    }

}
