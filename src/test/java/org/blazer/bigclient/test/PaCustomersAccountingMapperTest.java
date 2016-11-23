package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.PaCustomersAccountingMapper;
import org.blazer.bigclient.model.PaCustomersAccounting;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class PaCustomersAccountingMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertTest() {
        PaCustomersAccountingMapper mapper = sqlSession.getMapper(PaCustomersAccountingMapper.class);

        ArrayList<PaCustomersAccounting> list = new ArrayList<>();

        for (int i = 1; i <= 51; i++) {
            /*(String userName, Long phoneNumber, String registerDate, String investmentAdviser, String userIdentify,
             Integer ifPerformancePool, String endingBalance, Integer endingNotLessThanFifty, String buyAmount,
             String beginningBalance, Integer beginningNoGreaterThanFifty, String matchingPeriodInitialValue,
             String beginningComparison, String difference, String redemptionOrder, String revise, String errorQuery,
             Date mtime, Date ctime)*/
            PaCustomersAccounting user = new PaCustomersAccounting(i + "", Long.parseLong(i + ""), i + "", i + "", i + "",
                                                                    i, i + "", i, i + "",
                                                                    i + "", i, i + "",
                                                                    i + "", i + "", i + "", i + "", i + "",
                                                                    new Date(), new Date());

            list.add(user);
        }

        mapper.insertList(list);
    }


}
