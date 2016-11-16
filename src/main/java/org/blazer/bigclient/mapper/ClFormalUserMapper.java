package org.blazer.bigclient.mapper;

import org.blazer.bigclient.body.FormalUserBean;
import org.blazer.bigclient.model.ClFormalUser;
import org.blazer.bigclient.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClFormalUserMapper extends MyMapper<ClFormalUser> {

    List<FormalUserBean> selectMaxVersionList(String search, String dateStart, String dateEnd);

}