package com.wong.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class My01CommandLineRunner implements CommandLineRunner {
    /**
     * 当应用程序启动之后，会执行run方法
     *
     * @param args 主函数的参数列表
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("当前的应用程序已经启动完成，主函数的参数：" + args);
    }
}
