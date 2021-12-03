package com.wong.annotation;

/**
 * JDK1.5新特性 注解 Annotation
 * 注解和类，接口，是一个级别的事务（就是接口）
 * <p>
 * 作用：
 * 说明，对代码进行说明生成doc文件（API）
 * 检查：检测代码，是否有错误 @Override 方法重写
 * 分析：对代码的分析，起到替代配置文件
 * <p>
 * JDK中的注解：
 *
 * @Override 方法为重写
 * JDK 1.5版本，支持父类方法重写
 * JDK 1.6版本，支持父类，支持接口
 * @Deprecated 方法已经过时，不推荐使用
 * 调用的时候，开发工具，加删除线
 */
public class MyAnnotation {
    @Deprecated
    public void show() {
        System.out.println(11);
    }
    
    public static void main(String[] args) {
        new MyAnnotation().show();
    }
}