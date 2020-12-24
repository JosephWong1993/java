package com.wong.utils;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * 日志的切面类（包含了 增强方法）
 */
public class LogUtil {
    
    /**
     * 配置 前置增强：执行时机 在切入点方法执行前执行
     *
     * @param joinPoint
     * @throws Throwable
     */
    public void beforePrintLog(JoinPoint joinPoint) throws Throwable {
        //获取切人点的方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("前置增强beforePrintLog = " + Arrays.toString(args));
    }
}
