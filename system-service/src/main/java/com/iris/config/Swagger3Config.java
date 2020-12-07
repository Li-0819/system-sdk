package com.iris.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.iris.utils.constants.SpecialCode;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spi.service.contexts.SecurityContextBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Predicate;

/**
 * @Author: izanagi
 * @Date: 2020-06-03 18:34
 * @Description: Swagger2Config
 */
@Data
@Configuration
//@EnableOpenApi
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
public class Swagger3Config {

    @Resource
    private SwaggerInfo swaggerInfo;

    private boolean enable;

    private String host;

    private List<String> agreement;

    private static final List<String> EXCLUDE = Arrays.asList(
            "/",
            "/v2/**",
            "/csrf",
            "/error",
            "/favicon.ico",
            "/swagger-resources",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/webjars/**",
            "/index.html",
            "/index.html/**"
            );

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
//                .operationOrdering(Orderings.nickNameComparator())
                .host(host)
                .apiInfo(apiInfo())
                .select()
                //此包路径下的类，才生成接口文档
                .apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()))
//                .apis(basePackage("com"))
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(io.swagger.v3.oas.annotations.Operation.class))
                .paths(PathSelectors.any())
                .build()
//                .protocols(newHashSet("http", "https"))
                .protocols(new LinkedHashSet<>(agreement))
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(swaggerInfo.getTitle())
                .description(swaggerInfo.getDescription())
                .contact(new Contact(swaggerInfo.getName(), swaggerInfo.getUrl(), swaggerInfo.getEmail()))
                .version(swaggerInfo.getVersion())
                .build();
    }

    /**
     * 授权信息设置
     * @return {@link SecurityScheme}
     */
    private List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(new ApiKey(SpecialCode.X_AUTH_TOKEN, SpecialCode.X_AUTH_TOKEN,SpecialCode.HEADER));
    }

    /**
     * 认证的上下文，这里面需要指定哪些接口需要认证
     * @return {@link SecurityContext}
     */
    private List<SecurityContext> securityContexts() {
        SecurityContextBuilder builder = SecurityContext.builder().securityReferences(securityReferences());
        //指定需要认证的path，大写的注意，这里就用到了配置文件里面的URL，需要自己实现path选择的逻辑
        builder.forPaths(forExcludeAntPaths());
        return Collections.singletonList(builder.build());
    }
    /**
     * 匹配登陆拦截器过滤地址
     * @return predicate that matches a particular ant pattern
     */
    private Predicate<String> forExcludeAntPaths() {
        return (input) -> {
            //使用spring的ant路径配置
            AntPathMatcher matcher = new AntPathMatcher();
            //如果不是白名单的URL，就需要认证
            return Swagger3Config.EXCLUDE.stream().noneMatch(antPattern -> matcher.match(antPattern, input));
        };
    }

    /**
     * 这个方法是验证的作用域，不能漏了
     * @return {@link SecurityReference}
     */
    private List<SecurityReference> securityReferences() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        return Collections.singletonList(
                new SecurityReference(SpecialCode.X_AUTH_TOKEN, new AuthorizationScope[]{authorizationScope}));
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length >= 1) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(";")) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}