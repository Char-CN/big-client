package org.blazer.bigclient.service;

import org.blazer.bigclient.mapper.ClFormalUserVersionMapper;
import org.blazer.bigclient.model.ClFormalUserVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cuican on 2016-11-8.
 */
@Service
public class ClFormalUserVersionService extends BaseService<ClFormalUserVersion> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClFormalUserVersionService.class);

    @Autowired
    private ClFormalUserVersionMapper clFormalUserVersionMapper;

    public ClFormalUserVersion selectMaxVerNoByUid(Long id) {
        LOGGER.debug("查询version_no最大的一条记录。");
        return this.clFormalUserVersionMapper.selectMaxVerNoByUid(id);
    }
}
