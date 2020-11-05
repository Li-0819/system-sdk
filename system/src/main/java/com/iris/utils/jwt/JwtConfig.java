package com.iris.utils.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: izanagi
 * @Date: 2020-06-04 10:57
 * @Description: Jwt 配置
 */
@ConfigurationProperties(prefix = "jwt.config")
@Data
public class JwtConfig {
    /**
     * jwt 加密 key，默认值：treeFruit.
     */
    private String key;

    /**
     * jwt 过期时间，默认值
     */
    private Long ttl;

    /**
     * 开启 记住我 之后 jwt 过期时间
     */
    private Long remember;

    /**
     * 延长过期时间
     */
    private Long expire;
}
