package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.SrCurrentSalesDetailsMapper;
import org.blazer.bigclient.model.SrCurrentSalesDetails;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class SrCurrentSalesDetailsMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertTest() {
        SrCurrentSalesDetailsMapper mapper = sqlSession.getMapper(SrCurrentSalesDetailsMapper.class);

        ArrayList<SrCurrentSalesDetails> list = new ArrayList<>();

        for (int i = 1; i <= 51; i++) {
            SrCurrentSalesDetails user = new SrCurrentSalesDetails(i + "", Long.parseLong(i + ""), i + "", i + "", i + "", i + "",
                    i + "", i + "", i + "", i + "", new Date(), new Date());

            list.add(user);
        }

        mapper.insertList(list);
    }


}
