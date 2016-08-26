package org.blazer.bigclient.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.blazer.bigclient.model.BcFormalUser;
import org.blazer.bigclient.model.BcFormalUserExample;
import org.blazer.bigclient.util.MyMapper;

public interface BcFormalUserMapper extends MyMapper<BcFormalUser> {
    long countByExample(BcFormalUserExample example);

    int deleteByExample(BcFormalUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcFormalUser record);

    int insertSelective(BcFormalUser record);

    List<BcFormalUser> selectByExample(BcFormalUserExample example);

    BcFormalUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcFormalUser record, @Param("example") BcFormalUserExample example);

    int updateByExample(@Param("record") BcFormalUser record, @Param("example") BcFormalUserExample example);

    int updateByPrimaryKeySelective(BcFormalUser record);

    int updateByPrimaryKey(BcFormalUser record);
}