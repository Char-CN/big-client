package org.blazer.bigclient.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.blazer.bigclient.model.BcWaitAllotUser;
import org.blazer.bigclient.model.BcWaitAllotUserExample;
import org.blazer.bigclient.util.MyMapper;

public interface BcWaitAllotUserMapper extends MyMapper<BcWaitAllotUser> {
    long countByExample(BcWaitAllotUserExample example);

    int deleteByExample(BcWaitAllotUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcWaitAllotUser record);

    int insertSelective(BcWaitAllotUser record);

    List<BcWaitAllotUser> selectByExample(BcWaitAllotUserExample example);

    BcWaitAllotUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcWaitAllotUser record, @Param("example") BcWaitAllotUserExample example);

    int updateByExample(@Param("record") BcWaitAllotUser record, @Param("example") BcWaitAllotUserExample example);

    int updateByPrimaryKeySelective(BcWaitAllotUser record);

    int updateByPrimaryKey(BcWaitAllotUser record);
}