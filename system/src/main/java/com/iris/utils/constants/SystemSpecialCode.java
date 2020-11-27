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
    public static final String REDIS_JWT_KEY_PREFIX = "ykyz:security:jwt:";

    public static final String YYYY_AND_MM = "yyyyMM";
    public static final String MM_DD = "MM-dd";

    public static final List<String> A = Arrays.asList(".mp4", "rmvb", "3gp", "amv");

    /** 审核状态
     *  10 待审核  20 审核通过 30 驳回 40 已锁定 50已认证
     * */
    public static final String TO_AUDIT  = "1001-10";
    public static final String AUDIT_PASS  = "1001-20";
    public static final String AUDIT_REJECT  = "1001-30";
    public static final String AUDIT_LOCK  = "1001-40";
    public static final String AUDIT_ATTESTATION  = "1001-50";


    public static final String BE_ON_THE_JOB   = "1024-10";

    /**
     * 员工类型
     */
    public static final String ORG_ADMIN  = "1027-30";

}
