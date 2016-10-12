package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.KamUserInfoMapper;
import org.blazer.bigclient.model.KamUserInfo;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.RandomNumUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by cuican on 2016-9-23.
 */
public class KamUserInfoMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void addUserTest() {
        //获取mapper
        KamUserInfoMapper userMapper = sqlSession.getMapper(KamUserInfoMapper.class);
        //批量添加用户
        for (int i = 1; i <= 300; i++) {
            KamUserInfo user = new KamUserInfo();
            /**
             * <field name="id" title="自动编号"/>
             <field name="excelId" title="excel关联id"/>
             <field name="phoneNumber" title="手机号码"/>
             <field name="userName" title="客户姓名"/>
             <field name="sex" title="性别"/>
             <field name="age" title="年龄"/>
             <field name="birthday" title="出生日期"/>
             <field name="idCard" title="证件号码"/>
             <field name="assetsAmount" title="资产总额"/>
             <field name="ifEmployee" title="是否员工"/>
             <field name="ifRegister" title="是否注册"/>
             <field name="registerDate" title="注册日期"/>
             <field name="ifRealName" title="是否实名"/>
             <field name="ifBindCard" title="是否绑卡"/>
             <field name="ifTransaction" title="是否有过交易"/>
             <field name="referrer" title="扫码推荐人"/>
             <field name="referrerPhoneNumber" title="推荐人手机号"/>
             <field name="ifReferrerEmployee" title="推荐人是否员工"/>
             <field name="rebateExpirationDate" title="返利失效日期"/>
             <field name="ifReportOrAllot" title="是否上报/分配"/>
             <field name="reportOrAllot" title="上报/分配"/>
             <field name="reportOrAllotDate" title="上报/分配时间"/>
             <field name="userIdentify" title="客户标识"/>DKH000，DKH001
             <field name="investmentAdviser" title="投资顾问"/>
             <field name="ifDelete" title="是否删除"/>
             <field name="mtime" title="更新时间" pattern="yyyy-MM-dd"/>
             <field name="ctime" title="创建时间" pattern="yyyy-MM-dd"/>
             */
            if (i % 2 == 0) {
                user.setUserName("张三" + i);
                user.setSex("男");
                user.setIfEmployee("是");
                user.setIfRegister("是");
                user.setRegisterDate(DateUtil.thisDate());
                user.setIfRealName("是");
                user.setIfBindCard("是");
                user.setIfTransaction("是");
                user.setReferrer("王五" + i);
                user.setIfReferrerEmployee("是");
                user.setReportOrAllot("上报");
                user.setUserIdentify("DKH000");
                user.setInvestmentAdviser("田七" + i);
            } else {
                user.setUserName("李四" + i);
                user.setSex("女");
                user.setIfEmployee("否");
                user.setIfRegister("否");
                user.setRegisterDate(DateUtil.thisDate());
                user.setIfRealName("否");
                user.setIfBindCard("否");
                user.setIfTransaction("否");
                user.setReferrer("赵六" + i);
                user.setIfReferrerEmployee("否");
                user.setReportOrAllot("分配");
                user.setUserIdentify("DKH001");
                user.setInvestmentAdviser("胡八" + i);
            }
            user.setPhoneNumber(RandomNumUtil.randomPhoneNumber());
            user.setExcelId(0L);
            user.setAge(RandomNumUtil.randomAgeNo());
            user.setBirthday(DateUtil.thisDate());
            user.setIdCard(RandomNumUtil.randomIDNo());
            user.setAssetsAmount(RandomNumUtil.randomAssetNo());
            user.setReferrerPhoneNumber(RandomNumUtil.randomPhoneNo());
            user.setRebateExpirationDate(DateUtil.thisDate());
            user.setReportOrAllotDate(DateUtil.thisDate());
            user.setIfDelete(0);
            user.setCtime(new Date());
            userMapper.insert(user);

        }


    }


    @Test
    public void updateUserTest() {
        //获取mapper
        KamUserInfoMapper userMapper = sqlSession.getMapper(KamUserInfoMapper.class);
        //查询表中所有对象
        List<KamUserInfo> list = userMapper.selectAll();
        //遍历集合
        for (int i = 1; i < list.size(); i++) {
            KamUserInfo user = list.get(i);
            if (i <=150) {
                user.setIfReportOrAllot(0);
            } else {
                user.setIfReportOrAllot(1);
            }
            user.setMtime(new Date());
            userMapper.updateByPrimaryKey(user);
        }
    }

}
