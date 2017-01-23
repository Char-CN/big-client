package org.blazer.bigclient.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: cuican
 * Date: 2016-12-9
 * Time: 11:00
 */
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -1L;

    private Date mtime;

    private Date ctime;

}
