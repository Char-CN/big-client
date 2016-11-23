package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.PrCustomerConversionRateMapper;
import org.blazer.bigclient.model.PrCustomerConversionRate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class PrCustomerConversionRateMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertTest() {
        PrCustomerConversionRateMapper mapper = sqlSession.getMapper(PrCustomerConversionRateMapper.class);

        ArrayList<PrCustomerConversionRate> list = new ArrayList<>();

        for (int i = 1; i <= 51; i++) {
            PrCustomerConversionRate user = new PrCustomerConversionRate(i + "", i + "", i + "", i + "", i + "",
                                                                i + "", i + "", i + "", i + "", i + "",
                                                                i + "", i + "", new Date(), new Date());

            list.add(user);
        }

        mapper.insertList(list);
    }


}
