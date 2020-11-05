package com.iris.utils.response;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;import com.iris.exception.BaseException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: izanagi
 * @Date: 2020-07-01 13:57
 * @Description: ResponseUtil
 */
@Slf4j
public class ResponseUtil {

    /**
     * 往 response 写出 json
     * @param response 响应
     * @param status   状态
     * @param message  信息
     */
    public static void renderJson(HttpServletResponse response, ResponseStatus status, String message) {

        try {

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);

            if (!StrUtil.isNotBlank(message)) {

                message = status.getMessage();
            }

            response.getWriter()
                    .write(JSONUtil.toJsonStr(new JSONObject(ResponseVO.error(status.getCode(), message), false)));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }

    /**
     * 往 response 写出 json
     *
     * @param response  响应
     * @param exception 异常
     */
    public static void renderJson(HttpServletResponse response, BaseException exception) {
        try {

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);

            response.getWriter()
                    .write(JSONUtil.toJsonStr(new JSONObject(ResponseVO.ofException(exception), false)));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }
}