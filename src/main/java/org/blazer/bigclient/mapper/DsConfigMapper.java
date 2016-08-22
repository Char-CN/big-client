package org.blazer.bigclient.mapper;

import org.blazer.bigclient.model.DsConfig;

public interface DsConfigMapper {
    int deleteByPrimaryKey(Long id);

    DsConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DsConfig record);

    int updateByPrimaryKey(DsConfig record);
}