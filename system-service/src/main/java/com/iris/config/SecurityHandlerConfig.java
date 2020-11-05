package com.iris.config;

import com.iris.utils.constants.CommonMsg;
import com.iris.utils.response.ResponseStatus;
import com.iris.utils.response.ResponseUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Security 结果处理配置
 *
 * @Author: izanagi
 * @Date: 2020-07-02 09:34
 * @Description: SecurityHandlerConfig
 */
@Configuration
public class SecurityHandlerConfig {

    /**
     * 用来解决认证过的用户访问无权限资源时的异常
     * @return {@link AccessDeniedHandler}
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {

        return (request, response, accessDeniedException) ->

                ResponseUtil.renderJson(response, ResponseStatus.FORBIDDEN, CommonMsg.TOKEN_PARSE_ERROR);
    }

    /**
     * 用来解决匿名用户访问无权限资源时的异常
     * @return {@link AuthenticationEntryPoint}
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {

        return (request, response, authException) ->

            ResponseUtil.renderJson(response, ResponseStatus.UNAUTHORIZED, null);

    }
}
