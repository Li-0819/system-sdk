package com.iris.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据库配置
 * - 使用Druid作为数据库连接池
 * @author izanagi
 */
@Configuration
public class DataSourceConfiguration {

    /**
     * 主数据库
     * @return {@link DruidDataSource}
     */
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource mainDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}

