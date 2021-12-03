package com.wong.design.factorymethod;

/**
 * 创建猫工厂，只能创建猫对象
 */
public class CarFactory implements Factory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
