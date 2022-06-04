package com.wong.config;

;

import com.wong.service.UserService;
import com.wong.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ComponentScan("com.itheima") 注解作用：组件扫描，扫描指定包下的所有注解，注入对象到spring的ioc容器
 * @Import(JdbcConfiguration.class) 注解作用：导入配置类
 * @EnableTransactionManagement 注解作用：开启事务管理器
 */
@Configuration
@ComponentScan("com.wong")
@Import(JdbcConfiguration.class)//导入本项目中的配置类
public class SpringConfiguration {
//    @Bean
//    public UserService userService() {
//        return new UserServiceImpl();
//    }
}
