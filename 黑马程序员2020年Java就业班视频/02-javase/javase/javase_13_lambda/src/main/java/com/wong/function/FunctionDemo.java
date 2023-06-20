package com.wong.function;

/**
 * JDK8中出现的注解：限制 @FunctionInterface
 * <p>
 * 接口定义上，使用了注解@FunctionalInterface
 * 编译class文件的时候，javac检测接口是否符合规定 有且只能有一个抽象方法，规定不满足，编译失败
 */
@FunctionalInterface
interface A {
    public abstract void show();

//    public abstract void show2();

    public default void method() {
    }
}

public class FunctionDemo {
}
