package com.wong.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 监听，当前应用程序启动之后，做一些事情
 */
@Component
public class My02ApplicationRunListener implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("当前应用程序启动完成之后执行，主函数的参数：" + args.toString());
    }
}