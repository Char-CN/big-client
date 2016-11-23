package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.PrPerformanceReportMapper;
import org.blazer.bigclient.model.PrPerformanceReport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class PrPerformanceReportMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertTest() {
        PrPerformanceReportMapper mapper = sqlSession.getMapper(PrPerformanceReportMapper.class);

        ArrayList<PrPerformanceReport> list = new ArrayList<>();

        for (int i = 1; i <= 51; i++) {
            PrPerformanceReport user = new PrPerformanceReport(i + "", i + "", i + "", i + "", i + "",
                                                                i + "", i + "", i + "", i + "", i + "",
                                                                i + "", i + "", i + "", i + "", i + "",
                                                                i + "", i + "", new Date(), new Date());

            list.add(user);
        }

        mapper.insertList(list);
    }


}
