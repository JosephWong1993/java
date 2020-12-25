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
    
    /**
     * 配置 后置增强：执行时机 在切入点方法执行完毕后，执行；若切入点方法执行过程中产生了异常，后置增强不执行
     *
     * @param joinPoint
     * @throws Throwable
     */
    public void afterReturningPrintLog(JoinPoint joinPoint, Object rtValue) throws Throwable {
        System.out.println("后置增强afterReturningPrintLog = " + rtValue);
    }
    
    /**
     * 配置 异常增强：执行时机 在切入点方法执行过程中 抛出了异常，执行
     *
     * @param joinPoint
     * @throws Throwable
     */
    public void afterThrowingPrintLog(JoinPoint joinPoint, Exception e) throws Throwable {
        System.out.println("异常增强 = " + e);
    }
    
    /**
     * 配置 最终增强：执行时机 在切入点方法执行完毕后，执行(无论是否有异常，最终增强都执行)
     *
     * @param joinPoint
     * @throws Throwable
     */
    public void afterPrintLog(JoinPoint joinPoint) throws Throwable {
        System.out.println("最终增强：afterPrintLog");
    }
}
