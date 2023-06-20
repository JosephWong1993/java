package com.wong.pool02;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("线程开启");
        return "线程结果字符串";
    }
}
