package com.wong.design.simple;

/**
 * 工厂类，创建对象，只能创建Animal类型对象
 */
public class AnimalFactory {
    /**
     * 方法创建对象，Animal对象
     * 工厂创建对象，下订单，交定金
     */
    public static Animal createAnime(String name) {
        if ("cat".equals(name)) {
            return new Cat();
        }
        if ("dog".equals(name)) {
            return new Dog();
        }
        return null;
    }
}
