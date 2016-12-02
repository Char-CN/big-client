package org.blazer.bigclient.mapper;

import org.apache.ibatis.annotations.Select;
import org.blazer.bigclient.model.ClPerformancePoolList;
import org.blazer.bigclient.util.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ClPerformancePoolListMapper extends MyMapper<ClPerformancePoolList> {

    @Select("TRUNCATE TABLE cl_performance_pool_list")
    void deleteAll();
}