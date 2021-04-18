package com.wong.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * Spring框架的核心配置文件
 */
@Configuration
//开启SpringIOC容器的注解扫描
@ComponentScan({ "com.wong" })
@Import({ JDBCConfig.class, MybatisConfig.class })
public class SpringConfig {
}
