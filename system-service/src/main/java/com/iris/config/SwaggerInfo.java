package com.iris.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author izanagi
 * @version 1.0
 * @date 2020/8/28 14:12
 */
@Data
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "api-info")
public class SwaggerInfo {

    private String basePackage;
    private String title;
    private String description;
    private String name;
    private String url;
    private String email;
    private String version;
}
