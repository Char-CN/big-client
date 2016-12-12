package org.blazer.bigclient.body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by cuican on 2016-11-18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorInfoBean implements Serializable {

    private static final long serialVersionUID = -9205618461475346830L;

    private Long id;
    private String serialNumber;
    private String level;
    private String systemName;
    private String actualName;
    private String phoneNumber;
    private String email;
    private String teamName;
    private String teamLeaderName;
    private Integer totalNumber;
    private String area;

}
