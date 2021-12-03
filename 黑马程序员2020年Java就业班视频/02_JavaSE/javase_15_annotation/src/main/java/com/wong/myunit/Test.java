package com.wong.myunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 解析注解@MyTest
 * 方法上带有注解 @MyTest，运行此方法
 * <p>
 * 实现思想：
 * 1：反射OurTest
 * 2：获取类中的所有方法
 * 3：遍历这些方法
 * 4：判断哪些方法上有注解 @MyTest
 * 5：如果有，invoke
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //1：反射OurTest
        Class c = Class.forName("com.wong.myunit.OurTest");
        Object object = c.newInstance();
        //2：获取类中的所有方法
        Method[] methods = c.getMethods();
        //3：遍历这些方法
        for (Method method : methods) {
            //method是每个方法
            //4：判断哪些方法上有注解 @MyTest
            boolean b = method.isAnnotationPresent(MyTest.class);
            if (b) {
                method.invoke(object);
            }
        }
    }
}
