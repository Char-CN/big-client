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
            PaCustomersAccounting user = new PaCustomersAccounting(Long.parseLong(i + ""),i + "", Long.parseLong(i + ""), i + "", i + "", i + "",
                    i, i + "", i + "", i + "", i + "",
                    i + "", i, i + "", i, i,
                    i, i, i, i, i,
                    i + "", new Date(), new Date());
            list.add(user);
        }

        mapper.insertList(list);
    }


}
