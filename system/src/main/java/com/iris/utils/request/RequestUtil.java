package com.iris.utils.request;

import com.iris.utils.constants.SystemSpecialCode;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WindChaser
 * @createTime 2020-09-15 19:21
 * @description CusAccessObjectUtil 请求工具类
 */
public class RequestUtil {

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     * 取X-Forwarded-For中第一个非unknown的有效IP字符串。
     * @param request {@link HttpServletRequest}
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || SystemSpecialCode.UNKNOWN.equalsIgnoreCase(ip)) {

            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || SystemSpecialCode.UNKNOWN.equalsIgnoreCase(ip)) {

            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || SystemSpecialCode.UNKNOWN.equalsIgnoreCase(ip)) {

            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || SystemSpecialCode.UNKNOWN.equalsIgnoreCase(ip)) {

            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || SystemSpecialCode.UNKNOWN.equalsIgnoreCase(ip)) {

            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
