package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.PaRegularSalesScaleAccountingMapper;
import org.blazer.bigclient.model.PaRegularSalesScaleAccounting;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class PaRegularSalesScaleAccountingMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertTest() {
        PaRegularSalesScaleAccountingMapper mapper = sqlSession.getMapper(PaRegularSalesScaleAccountingMapper.class);

        ArrayList<PaRegularSalesScaleAccounting> list = new ArrayList<>();

        for (int i = 1; i <= 51; i++) {
            PaRegularSalesScaleAccounting user = new PaRegularSalesScaleAccounting(i + "", Long.parseLong(i + ""), i + "", i + "", i + "",
                                                                                    i + "", i + "", i + "", i + "",i + "",i + "",i + "", i,
                                                                                    i ,i , Double.parseDouble(i + ""), new Date(), new Date());

            list.add(user);
        }

        mapper.insertList(list);
    }


}
