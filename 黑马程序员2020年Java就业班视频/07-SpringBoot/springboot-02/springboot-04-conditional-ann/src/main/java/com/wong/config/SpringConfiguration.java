package com.wong.config;

import com.wong.pojo.Dog;
import com.wong.pojo.Tomcat;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
public class SpringConfiguration {
    /**
     * @ConditionalOnClass 当我的classpath路径下，存在Tomcat类，导入dog
     * 可以放到：可以放到类上，可以放到方法上
     * @ConditionalOnProperty 注解作用：当配置文件中有spring.wong.enable配置值，且配置值为true时，条件生效
     * name属性，设置配置key
     * havingValue属性，设置配置的默认值
     * matchIfMissing属性，设置配置value匹配的值，如果匹配条件生效，如果不匹配，条件不生效
     */
    @Bean
//    @ConditionalOnClass(name = "com.wong.pojo.Tomcat")
    @ConditionalOnProperty(name = "spring.wong.enable", havingValue = "true", matchIfMissing = true)
    public Dog dog() {
        return new Dog();
    }
}
