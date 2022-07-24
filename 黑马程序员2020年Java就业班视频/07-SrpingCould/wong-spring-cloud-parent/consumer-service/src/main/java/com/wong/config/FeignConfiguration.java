package com.wong.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign客户的接口的配置类
 */
@Configuration
public class FeignConfiguration {
    /**
     * 注入日志级别的配置到Spring容器中
     */
    @Bean
    public Logger.Level loggerLevel() {
        // 配置显示全部的日志信息
        return Logger.Level.FULL;
    }
}
