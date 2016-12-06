package org.blazer.bigclient.test;

import org.apache.ibatis.session.SqlSession;
import org.blazer.bigclient.mapper.PaCurrentSalesScaleAccountingMapper;
import org.blazer.bigclient.model.PaCurrentSalesScaleAccounting;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cuican on 2016-11-10.
 */
public class PaCurrentSalesScaleAccountingMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertTest() {
        PaCurrentSalesScaleAccountingMapper mapper = sqlSession.getMapper(PaCurrentSalesScaleAccountingMapper.class);

        ArrayList<PaCurrentSalesScaleAccounting> list = new ArrayList<>();

        for (int i = 1; i <= 51; i++) {
            /*String userName, Long phoneNumber, String reportOrAllot, String reportOrAllotDate,
             String investmentAdviser, String userIdentify, String basicProductName,
             Double monthlyPurchaseAmount, String purchaseDate, Double monthlyPurchaseAmount10,
             String ifReport, Double effectiveCurrentSalesScale, Double deferredNextMonth,
             Date mtime, Date ctime*/
            PaCurrentSalesScaleAccounting user = new PaCurrentSalesScaleAccounting(i + "", Long.parseLong("i + \"\""),i + "",i + "",
                    i + "",i + "",i + "",Double.parseDouble(i + ""),i + "",Double.parseDouble(i + ""),i + "",
                    Double.parseDouble(i + ""), Double.parseDouble(i + ""), new Date(), new Date());

            list.add(user);
        }

        mapper.insertList(list);
    }


}
