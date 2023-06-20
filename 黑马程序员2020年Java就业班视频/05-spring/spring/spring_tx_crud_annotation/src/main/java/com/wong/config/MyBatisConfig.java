package com.wong.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import({JDBCConfig.class})
public class MyBatisConfig {
    /**
     * 配置SQLSessionFactoryBean对象
     */
    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //配置（数据源，pojo别名）
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.wong.pojo");
        return sqlSessionFactoryBean;
    }

    /**
     * 配置dao扫描器对象
     */
    @Bean
    public MapperScannerConfigurer createMapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //配置（扫描的包路径）
        scannerConfigurer.setBasePackage("com.wong.dao");
        return scannerConfigurer;
    }
}
