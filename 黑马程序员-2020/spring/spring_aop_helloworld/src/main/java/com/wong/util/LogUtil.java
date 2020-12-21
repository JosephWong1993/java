package com.wong.util;

/**
 * 日志切面类，提供了AccountServiceImpl类增强方法
 */
public class LogUtil {
    //打印日志（增强方法）
    public void printLog() {
        System.out.println("增强方法 printLog 执行了");
    }
}
