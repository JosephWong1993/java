package com.wong.config;

import com.wong.utils.CodeUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * codeutil的自动配置类
 * 帮我们注入CodeUtils对象到Spring的容器中，谁导入starter坐标，就注入到那里去
 */
@Configuration
@ConditionalOnClass(name = "com.wong.utils.CodeUtils")
@Import(Properties.class)
public class WongAutoConfiguration {
    /**
     * 注入核心对象到Spring的容器中
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(name = "spring.wong.enable", havingValue = "true", matchIfMissing = true)
    public CodeUtils codeUtils() {
        return new CodeUtils();
    }
}