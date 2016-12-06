package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cuican on 2016-11-15.
 */
public class ClExtUserMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void addTest() {

//        ClExtUserBakMapper clExtUserBakMapper = sqlSession.getMapper(ClExtUserBakMapper.class);
//        ClExtUserMapper mapper = sqlSession.getMapper(ClExtUserMapper.class);
//
//        List<ClExtUserBak> extUserBakList = clExtUserBakMapper.selectAll();
//        for (int i = 0; i < extUserBakList.size(); i++) {
//            ClExtUserBak clExtUserBak = extUserBakList.get(i);
//            ClExtUser user = new ClExtUser();
//            user.setInvestmentAdviser(clExtUserBak.getInvestmentAdviser());
//            user.setPhoneNumber(clExtUserBak.getPhoneNumber());
//            user.setUserName(clExtUserBak.getCustomerName());
//            user.setIfDelete(0);
//            user.setCtime(new Date());
//
//            if (i % 2 == 0) {
//
//                user.setIfRegister("是");
//                user.setRegisterDate(DateUtil.thisDate());
//                user.setIfRealName("否");
//                user.setIfBindCard("是");
//                user.setIfTransaction("否");
//                user.setReferrer("吕布" + i);
//
//            } else {
//                user.setIfRegister("否");
//                user.setRegisterDate(DateUtil.date2Str(DateUtil.getFirstDateOfMonth(new Date()), DateUtil.DEFAULT_DATE_FORMAT));
//                user.setIfRealName("是");
//                user.setIfBindCard("否");
//                user.setIfTransaction("否");
//                user.setReferrer("貂蝉" + i);
//            }
//            mapper.insert(user);
//        }
//
//
    }

}
