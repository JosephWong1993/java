package com.wong.mp.spring.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Import({JdbcConfig.class})
public class MybatisConfig {
    @Bean
    public MybatisSqlSessionFactoryBean createMybatisSqlSessionFactoryBean(DataSource dataSource) {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        //配置相关信息（数据源，pojo的别名）
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.wong.mp.spring.pojo");
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer createMapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //配置相关信息（指定扫描的dao层的路径）
        scannerConfigurer.setBasePackage("com.wong.mp.spring.mapper");
        return scannerConfigurer;
    }
}
