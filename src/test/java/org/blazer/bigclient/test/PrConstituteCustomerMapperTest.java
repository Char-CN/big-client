package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.PrConstituteCustomerMapper;
import org.blazer.bigclient.model.PrConstituteCustomer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class PrConstituteCustomerMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertTest() {
        PrConstituteCustomerMapper mapper = sqlSession.getMapper(PrConstituteCustomerMapper.class);

        ArrayList<PrConstituteCustomer> list = new ArrayList<>();

        for (int i = 1; i <= 51; i++) {
            PrConstituteCustomer user = new PrConstituteCustomer(i + "", i + "", i + "", i + "", i + "",
                    i + "", i + "", new Date(), new Date());

            list.add(user);
        }

        mapper.insertList(list);
    }


}
