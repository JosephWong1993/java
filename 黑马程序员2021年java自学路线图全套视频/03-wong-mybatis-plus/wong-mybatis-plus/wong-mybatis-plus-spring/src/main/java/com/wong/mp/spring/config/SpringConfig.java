package com.wong.mp.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MybatisConfig.class)
public class SpringConfig {
}
