package com.iris.utils.constants;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-06-04 09:36
 * @Description: java系统级编码
 */
public class SpecialCode {

    public static final String ROUTE_COMMON = "/common";

    /**
     *
     */
    public static final String X_AUTH_TOKEN = "X-Auth-Token";
    public static final String TERMINAL_CLASSIFY = "Terminal_Classify";
    public static final String CLASSIFY_CLIENT = "client";
    public static final String CLASSIFY_BUSINESS = "business";
    public static final String HEADER = "header";

    public static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";

    /**
     * JWT 在 Redis 中保存的key前缀
     */
    public static final String REDIS_JWT_KEY_PREFIX = "security:jwt:";

    public static final String YYYY_AND_MM = "yyyyMM";
    public static final String MM_DD = "MM-dd";

    public static final Integer DEFAULT_CURRENT_PAGE = 1;
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    public static final List<String> A = Arrays.asList(".mp4", "rmvb", "3gp", "amv");

    /** 已上架 */
    public static final String HAS_BEEN_ON = "1039-30";

    /** 审核状态
     *  1,待审核 2,审核通过 3,驳回 4,已锁定, 5,已认证
     * */
    public static final String TO_AUDIT  = "1001-10";
    public static final String AUDIT_PASS  = "1001-20";
    public static final String AUDIT_REJECT  = "1001-30";
    public static final String AUDIT_LOCK  = "1001-40";
    public static final String AUDIT_ATTESTATION  = "1001-50";

    public static final String ORDER_UNDERWAY = "1011-10";

    /**
     * 登录方式
     * 10 验证码  20 本机号码一键登录  30 微信授权登录  40 QQ授权登录
     */
    public static final String VERIFICATION_CODE_LOGIN = "1013-10";
    public static final String LOCAL_PHONE_ONE_KEY_LOGIN = "1013-20";
    public static final String WE_XIN_LOGIN = "1013-30";
    public static final String QQ_LOGIN = "1013-40";

}
