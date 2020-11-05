package com.iris.utils.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * static method read Configuration Utils 静态方法读取配置文件
 * @author WindChaser
 * @creatTime 2020-09-07 11:10
 * @description NAME
 */
@Component
public class SmrConfigurationUtils {

    public static String requestDir;

    @Value("${file.request-dir}")
    public void setFileRequestDir(String requestDir) {
        SmrConfigurationUtils.requestDir = requestDir;
    }
}
