package com.wong.design.single01;

/**
 * 单例设计模式：饿汉式
 * 保证对象具有唯一性
 */
public class Single {
    //私有构造方法
    private Single() {
    }

    //自己创建自己的对象
    private static Single s = new Single();

    //方法，提供对变量s的访问
    public static Single getInstance() {
        return s;
    }
}
