package com.iris.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Sets;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @Author: izanagi
 * @Date: 2020-06-03 18:34
 * @Description: 自定义配置
 */
@ConfigurationProperties(prefix = "custom.config")
@Data
public class CustomConfig {
    /**
     * 不需要拦截的地址
     */
    private IgnoreConfig ignores;

    /**
     * 请求是否不需要进行权限拦截
     *
     * @param request 当前请求
     * @return true - 忽略，false - 不忽略
     */
    public boolean checkIgnores(HttpServletRequest request) {
        String method = request.getMethod();

        HttpMethod httpMethod = HttpMethod.resolve(method);
        if (ObjectUtil.isNull(httpMethod)) {
            httpMethod = HttpMethod.GET;
        }

        Set<String> ignores = Sets.newHashSet();

        switch (httpMethod) {
            case GET:
                ignores.addAll(getIgnores()
                        .getGet());
                break;
            case PUT:
                ignores.addAll(getIgnores()
                        .getPut());
                break;
            case HEAD:
                ignores.addAll(getIgnores()
                        .getHead());
                break;
            case POST:
                ignores.addAll(getIgnores()
                        .getPost());
                break;
            case PATCH:
                ignores.addAll(getIgnores()
                        .getPatch());
                break;
            case TRACE:
                ignores.addAll(getIgnores()
                        .getTrace());
                break;
            case DELETE:
                ignores.addAll(getIgnores()
                        .getDelete());
                break;
            case OPTIONS:
                ignores.addAll(getIgnores()
                        .getOptions());
                break;
            default:
                break;
        }

        ignores.addAll(getIgnores()
                .getPattern());

        if (CollUtil.isNotEmpty(ignores)) {
            for (String ignore : ignores) {
                AntPathRequestMatcher matcher = new AntPathRequestMatcher(ignore, method);
                if (matcher.matches(request)) {
                    return true;
                }
            }
        }

        return false;
    }
}
