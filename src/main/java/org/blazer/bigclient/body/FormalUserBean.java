package org.blazer.bigclient.body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.blazer.bigclient.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cuican on 2016-11-15.
 *
 * 正式名单页面展示bean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormalUserBean implements Serializable {

    private static final long serialVersionUID = -7447069713901405697L;

    private Long userId;
    private Long phoneNumber;
    private String reportOrAllot;
    private String reportOrAllotDate;
    private String userIdentify;
    private String investmentAdviser;
    private Integer ifPerformancePool;
    private String versionNo;
    private Date startDate;
    private Date endDate;
    private String startDateFormat;
    private String endDateFormat;

}
