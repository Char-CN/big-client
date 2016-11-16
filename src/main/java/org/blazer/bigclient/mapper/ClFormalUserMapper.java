package org.blazer.bigclient.mapper;

import org.apache.ibatis.annotations.Param;
import org.blazer.bigclient.body.FormalUserBean;
import org.blazer.bigclient.model.ClFormalUser;
import org.blazer.bigclient.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClFormalUserMapper extends MyMapper<ClFormalUser> {

    List<FormalUserBean> selectMaxVersionList(@Param(value = "search") String search,
                                              @Param(value = "dateStart")String dateStart,
                                              @Param(value = "dateEnd")String dateEnd);

}