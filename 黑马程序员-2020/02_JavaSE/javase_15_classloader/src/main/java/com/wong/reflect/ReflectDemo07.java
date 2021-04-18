package com.wong.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射案例5：
 * 反射获取Student类的有参数的成员方法
 * public void eat(String,double)
 */
public class ReflectDemo07 {
    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        Class c = Class.forName("com.wong.reflect.Student");
        Object object = c.newInstance();
        //获取指定的方法，eat，参数列表String,double
        Method method = c.getMethod("eat", String.class, double.class);
        method.invoke(object, "字符串", 5.8);
    }
}
