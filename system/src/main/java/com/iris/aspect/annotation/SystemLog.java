package com.iris.aspect.annotation;


import java.lang.annotation.*;

/**
 * 后台管理日志注解
 * @author scott
 * @date 2020-9-15 15:38
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    /** 描述*/
    String description() default "";
}
