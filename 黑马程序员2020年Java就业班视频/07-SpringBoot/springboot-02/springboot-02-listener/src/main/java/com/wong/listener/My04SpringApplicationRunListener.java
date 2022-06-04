package com.wong.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class My04SpringApplicationRunListener implements SpringApplicationRunListener {

    /**
     * 构造方法
     *
     * @param application
     * @param args
     */
    public My04SpringApplicationRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("应用程序开始启动-starting()");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("应用程序的环境准备完成-environmentPrepared()");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("应用程序的spring容器准备完成-contextPrepared()");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("应用程序的spring容器装载完成-contextLoaded()");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("应用程序启动完成-started()");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("应用程序已经启动-running()");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("应用程序启动出错-failed()");
    }
}
