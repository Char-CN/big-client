package org.blazer.bigclient.mapper;

import org.blazer.bigclient.model.ClFormalUserVersion;
import org.blazer.bigclient.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClFormalUserVersionMapper extends MyMapper<ClFormalUserVersion> {

    ClFormalUserVersion selectMaxVerNoByUid(Long id);

    List<ClFormalUserVersion> selectMaxVerNoList();
}