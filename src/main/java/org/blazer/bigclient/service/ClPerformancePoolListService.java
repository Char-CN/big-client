package org.blazer.bigclient.service;

import org.blazer.bigclient.mapper.ClPerformancePoolListMapper;
import org.blazer.bigclient.model.ClPerformancePoolList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * User: cuican
 * Date: 2016-12-2
 * Time: 15:33
 */
@Service
public class ClPerformancePoolListService extends BaseService<ClPerformancePoolList> {

    @Autowired
    private ClPerformancePoolListMapper clPerformancePoolListMapper;

    public void deleteAll() {
        this.clPerformancePoolListMapper.deleteAll();
    }
}
