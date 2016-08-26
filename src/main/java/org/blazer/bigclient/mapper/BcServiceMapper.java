package org.blazer.bigclient.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.blazer.bigclient.model.BcService;
import org.blazer.bigclient.model.BcServiceExample;
import org.blazer.bigclient.util.MyMapper;

public interface BcServiceMapper extends MyMapper<BcService> {
    long countByExample(BcServiceExample example);

    int deleteByExample(BcServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BcService record);

    int insertSelective(BcService record);

    List<BcService> selectByExample(BcServiceExample example);

    BcService selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BcService record, @Param("example") BcServiceExample example);

    int updateByExample(@Param("record") BcService record, @Param("example") BcServiceExample example);

    int updateByPrimaryKeySelective(BcService record);

    int updateByPrimaryKey(BcService record);
}