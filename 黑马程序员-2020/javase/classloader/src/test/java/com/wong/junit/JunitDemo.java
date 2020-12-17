package com.wong.junit;

import org.junit.Test;

/**
 * 使用Junit第三方工具，提供的一个注解 @Test
 */
public class JunitDemo {
    @Test
    public void show() {
        System.out.println("测试此方法");
    }
    
    //定义方法，HelloWorld
    @Test
    public void test() {
        System.out.println("Hello World");
        System.out.println(1 / 0);
    }
}
