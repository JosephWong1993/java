package com.wong.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring的核心配置文件
 */
@Configuration
//开启SpringIOC的注解扫描
@ComponentScan({ "com.wong" })
//开启SpringAOP的注解扫描
@EnableAspectJAutoProxy
public class SpringConfig {

}
