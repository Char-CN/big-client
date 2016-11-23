package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.PrPerformanceReportMapper;
import org.blazer.bigclient.mapper.PrRegularPaymentMapper;
import org.blazer.bigclient.model.PrPerformanceReport;
import org.blazer.bigclient.model.PrRegularPayment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class PrRegularPaymentMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertTest() {
        PrRegularPaymentMapper mapper = sqlSession.getMapper(PrRegularPaymentMapper.class);

        ArrayList<PrRegularPayment> list = new ArrayList<>();

        for (int i = 1; i <= 51; i++) {
            PrRegularPayment user = new PrRegularPayment(i + "", i + "", i + "", i + "", i + "",
                                                         i + "",i + "", i + "", new Date(), new Date());

            list.add(user);
        }

        mapper.insertList(list);
    }


}
