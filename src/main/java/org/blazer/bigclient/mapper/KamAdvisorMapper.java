package org.blazer.bigclient.mapper;

import org.blazer.bigclient.body.AdvisorInfoBean;
import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KamAdvisorMapper extends MyMapper<KamAdvisor> {
    List<AdvisorInfoBean> findByPage(String search);
}