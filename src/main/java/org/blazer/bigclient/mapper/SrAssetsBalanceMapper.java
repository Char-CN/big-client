package org.blazer.bigclient.mapper;

import org.apache.ibatis.annotations.Param;
import org.blazer.bigclient.model.SrAssetsBalance;
import org.blazer.bigclient.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SrAssetsBalanceMapper extends MyMapper<SrAssetsBalance> {

    List<SrAssetsBalance> findByMonthly(@Param("ctime") String ctime);
}