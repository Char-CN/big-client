package org.blazer.bigclient.util;

public class StringUtil {

	public static String getStrEmpty(Object o) {
		return o == null ? "" : o.toString();
	}

	public static String getStr(Object o) {
		return o == null ? null : o.toString();
	}

}
