package com.wong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 事务管理器 配置文件
 */
@Configuration
public class TransactionConfig {
    //配置Spring框架提供的事务管理器对象
    @Bean
    public PlatformTransactionManager createDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        //配置（数据源）
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}