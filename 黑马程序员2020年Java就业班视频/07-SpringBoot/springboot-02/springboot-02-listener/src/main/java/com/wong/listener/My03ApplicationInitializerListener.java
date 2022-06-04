package com.wong.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 在spring的容器初始化之前执行
 */
public class My03ApplicationInitializerListener implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("spring的容器开始初始化");
    }
}
