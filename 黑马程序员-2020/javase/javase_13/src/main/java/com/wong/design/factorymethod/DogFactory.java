package com.wong.design.factorymethod;

/**
 * 狗工厂，只能创建狗对象
 */
public class DogFactory implements Factory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
