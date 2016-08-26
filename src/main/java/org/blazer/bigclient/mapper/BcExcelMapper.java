package org.blazer.bigclient.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.blazer.bigclient.model.BcExcel;
import org.blazer.bigclient.model.BcExcelExample;
import org.blazer.bigclient.util.MyMapper;

public interface BcExcelMapper extends MyMapper<BcExcel> {
    long countByExample(BcExcelExample example);

    int deleteByExample(BcExcelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcExcel record);

    int insertSelective(BcExcel record);

    List<BcExcel> selectByExample(BcExcelExample example);

    BcExcel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcExcel record, @Param("example") BcExcelExample example);

    int updateByExample(@Param("record") BcExcel record, @Param("example") BcExcelExample example);

    int updateByPrimaryKeySelective(BcExcel record);

    int updateByPrimaryKey(BcExcel record);
}