package org.blazer.bigclient.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.blazer.bigclient.model.BcExternalUserBackup;
import org.blazer.bigclient.model.BcExternalUserBackupExample;
import org.blazer.bigclient.util.MyMapper;

public interface BcExternalUserBackupMapper extends MyMapper<BcExternalUserBackup> {
    long countByExample(BcExternalUserBackupExample example);

    int deleteByExample(BcExternalUserBackupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcExternalUserBackup record);

    int insertSelective(BcExternalUserBackup record);

    List<BcExternalUserBackup> selectByExample(BcExternalUserBackupExample example);

    BcExternalUserBackup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcExternalUserBackup record, @Param("example") BcExternalUserBackupExample example);

    int updateByExample(@Param("record") BcExternalUserBackup record, @Param("example") BcExternalUserBackupExample example);

    int updateByPrimaryKeySelective(BcExternalUserBackup record);

    int updateByPrimaryKey(BcExternalUserBackup record);
}