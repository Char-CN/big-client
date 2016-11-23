package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.SrAssetsBalanceMapper;
import org.blazer.bigclient.model.SrAssetsBalance;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class SrAssetsBalanceMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertTest() {
        SrAssetsBalanceMapper mapper = sqlSession.getMapper(SrAssetsBalanceMapper.class);

        ArrayList<SrAssetsBalance> list = new ArrayList<>();

        for (int i = 1; i <= 51; i++) {
            /*(String userName, Long phoneNumber, String investmentAdviser, String registerDate,
               String regularAssetsTotal, String regularAumTimePoint, String currentAssetsTotal,
               String currentAumTimePoint, String aumTotal, Date mtime, Date ctime)*/
            SrAssetsBalance user = new SrAssetsBalance(i + "", Long.parseLong(i + ""), i + "", i + "", i + "", i + "",
                                                        i + "", i + "", i + "", new Date(), new Date());

            list.add(user);
        }

        mapper.insertList(list);
    }


}
