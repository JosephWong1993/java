package com.wong.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射案例4：
 * 反射获取Student类的无参数构的成员方法
 * public void study()
 */
public class ReflectDemo06 {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException,
            InvocationTargetException {
        Class c = Class.forName("com.wong.reflect.Student");
        Object object = c.newInstance();
        //Class类的方法 Method[] getMethod() 获取到被反射对象，所有的公共权限方法，包括继承的
        /*Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/
        
        //获取无参数 eat() 方法执行
        //Class类的方法 Method getMethod(String 方法名,方法参数列表) 获取指定的成员方法
        Method method = c.getMethod("study");
        //运行成员方法，Method类的方法 Object invoke(Object obj,Object...p); 调用方法传递的实际参数
        method.invoke(object);
        
        //new Student().study()
    }
}
