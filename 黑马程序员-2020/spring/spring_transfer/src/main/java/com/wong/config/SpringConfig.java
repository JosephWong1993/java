package com.wong.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring框架的核心配置文件
 */
@Configuration
//开启SpringIOC容器的注解扫描
@ComponentScan({ "com.wong" })
@Import({ JDBCConfig.class, MybatisConfig.class })
public class SpringConfig {
}
