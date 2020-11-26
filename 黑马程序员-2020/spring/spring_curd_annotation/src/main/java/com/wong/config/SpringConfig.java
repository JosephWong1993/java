package com.wong.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Spring框架的核心配置文件
 */
@Configuration
//加载properties配置文件
//@PropertySource({ "classpath:jdbc.properties" })
//开启SpringIOC容器的注解扫描
@ComponentScan({ "com.wong" })
public class SpringConfig {
    //配置数据源
    @Bean("druidDataSource")
    public DataSource createDruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        //配置相关信息（驱动，url，用户名，密码）
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://49.235.249.194:3306/ssm_practice?serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("gh1002020");
        return druidDataSource;
    }
    
    //配置SqlSessionFactory对象
    //参数DataSource dataSource，会自动从SpringIOC容器中找配置的Bean对象
    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("druidDataSource") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //配置相关信息（数据源，pojo的别名）
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.wong.pojo");
        return sqlSessionFactoryBean;
    }
    
    //dao扫描器
    @Bean
    public MapperScannerConfigurer createMapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //配置相关信息（指定扫描的dao层的路径）
        scannerConfigurer.setBasePackage("com.wong.dao");
        return scannerConfigurer;
    }
}
