package com.wong.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志的切面类（包含了 增强方法）
 */
@Component
//设置切面类
@Aspect
public class LogUtil {
    
    //配置通用的切入点表达式
    @Pointcut("execution(* com.wong.service..*.*(..))")
    public void pointcut() {
    
    }
    
    /**
     * 配置 前置增强：执行时机 在切入点方法执行前执行
     */
    //    @Before("pointcut()")
    public void beforePrintLog(JoinPoint joinPoint) throws Throwable {
        //获取切人点的方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("前置增强beforePrintLog = " + Arrays.toString(args));
    }
    
    /**
     * 配置 后置增强：执行时机 在切入点方法执行完毕后，执行；若切入点方法执行过程中产生了异常，后置增强不执行
     */
    //    @AfterReturning(value = "pointcut()", returning = "rtValue")
    public void afterReturningPrintLog(JoinPoint joinPoint, Object rtValue) throws Throwable {
        System.out.println("后置增强afterReturningPrintLog = " + rtValue);
    }
    
    /**
     * 配置 异常增强：执行时机 在切入点方法执行过程中 抛出了异常，执行
     */
    //    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowingPrintLog(JoinPoint joinPoint, Exception e) throws Throwable {
        System.out.println("异常增强 = " + e);
    }
    
    /**
     * 配置 最终增强：执行时机 在切入点方法执行完毕后，执行(无论是否有异常，最终增强都执行)
     */
    //    @After("pointcut()")
    public void afterPrintLog(JoinPoint joinPoint) throws Throwable {
        System.out.println("最终增强：afterPrintLog");
    }
    
    /**
     * 配置 环绕通知：包含了（前置增强，后置增强，异常增强，最终增强）
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object rtValue = null;
        
        try {
            //配置 前置增强
            System.out.println("前置增强");
            
            //获取方法执行时所需的实际参数
            Object[] arg = joinPoint.getArgs();
            //原有方法执行
            rtValue = joinPoint.proceed(arg);
            //配置 后置增强
            System.out.println("后置增强");
        } catch (Throwable throwable) {
            //配置 异常增强
            System.out.println("异常增强");
        } finally {
            //配置 异常增强
            System.out.println("最终增强");
        }
        return rtValue;
    }
}
