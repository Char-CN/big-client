package org.blazer.bigclient.mapper;

import org.blazer.bigclient.model.ClFormalUserVersion;
import org.blazer.bigclient.util.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ClFormalUserVersionMapper extends MyMapper<ClFormalUserVersion> {

    ClFormalUserVersion selectMaxVerNoByUid(Long id);

}