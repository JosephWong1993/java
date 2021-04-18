package com.wong.service;

import org.junit.Test;

public class ThreadLocalTest {
    
    @Test
    public void testString() {
        //使用ThreadLocal对象，实现将当前线程绑定一个String变量
        //1.创建Thread对象
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        //2.把当前线程绑定一个String变量
        threadLocal.set("Wong");
        //3.获取当前线程上绑定的值
        String str = threadLocal.get();
        System.out.println("str = " + str);
        
        //多次获取当前线程中的String变量
        String str2 = threadLocal.get();
        System.out.println("str2 = " + str2);
        
        //创建一个新的线程，测试是否能获取到 Wong，结果是false
        new Thread(() -> {
            String str3 = threadLocal.get();
            System.out.println("str3 = " + str3);
        }).start();
    }
}
