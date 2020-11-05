package com.iris.utils.constants;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-06-04 09:36
 * @Description: java系统级编码
 */
public class SystemSpecialCode {

    /**
     *
     */
    public static final String X_AUTH_TOKEN = "X-Auth-Token";
    public static final String HEADER = "header";

    public static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
    public static final String UNKNOWN = "unknown";

    /**
     * JWT 在 Redis 中保存的key前缀
     */
    public static final String REDIS_JWT_KEY_PREFIX = "security:jwt:";

    public static final String YYYY_AND_MM = "yyyyMM";
    public static final String MM_DD = "MM-dd";

    public static final List<String> A = Arrays.asList(".mp4", "rmvb", "3gp", "amv");

}
