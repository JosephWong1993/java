package com.wong.design.single02;

/**
 * 单例设计模式：懒汉
 * 对象延迟创建
 * <p>
 * 线程安全问题
 */
public class Single {
    private Single() {
    }

    private static Single s = null;

    public static synchronized Single getInstance() {
        if (s == null) {
            s = new Single();
        }
        return s;
    }
}
