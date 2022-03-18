package com.wong.mp.spring.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@Import({JdbcConfig.class})
public class MybatisPlusConfig {
    @Bean
    public MybatisConfiguration mybatisConfiguration() {
        return new MybatisConfiguration();
    }

    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        return paginationInnerInterceptor;
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(PaginationInnerInterceptor paginationInnerInterceptor) {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.setInterceptors(List.of(paginationInnerInterceptor));
        return mybatisPlusInterceptor;
    }

    @Bean
    public GlobalConfig.DbConfig config() {
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setIdType(IdType.AUTO);
        return dbConfig;
    }

    @Bean
    public GlobalConfig globalConfig(GlobalConfig.DbConfig dbConfig) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setDbConfig(dbConfig);
        return globalConfig;
    }

    @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(DataSource dataSource,
                                                                     MybatisConfiguration configuration,
                                                                     GlobalConfig globalConfig,
                                                                     MybatisPlusInterceptor mybatisPlusInterceptor) {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        //配置相关信息（数据源，pojo的别名）
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setGlobalConfig(globalConfig);
        sqlSessionFactory.setPlugins(mybatisPlusInterceptor);
        sqlSessionFactory.setTypeAliasesPackage("com.wong.mp.spring.pojo");
        return sqlSessionFactory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //配置相关信息（指定扫描的dao层的路径）
        scannerConfigurer.setBasePackage("com.wong.mp.spring.mapper");
        return scannerConfigurer;
    }
}
