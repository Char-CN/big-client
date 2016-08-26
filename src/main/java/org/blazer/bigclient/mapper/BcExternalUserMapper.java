package org.blazer.bigclient.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.model.BcExternalUserExample;
import org.blazer.bigclient.util.MyMapper;

public interface BcExternalUserMapper extends MyMapper<BcExternalUser> {
    long countByExample(BcExternalUserExample example);

    int deleteByExample(BcExternalUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcExternalUser record);

    int insertSelective(BcExternalUser record);

    List<BcExternalUser> selectByExample(BcExternalUserExample example);

    BcExternalUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcExternalUser record, @Param("example") BcExternalUserExample example);

    int updateByExample(@Param("record") BcExternalUser record, @Param("example") BcExternalUserExample example);

    int updateByPrimaryKeySelective(BcExternalUser record);

    int updateByPrimaryKey(BcExternalUser record);
}