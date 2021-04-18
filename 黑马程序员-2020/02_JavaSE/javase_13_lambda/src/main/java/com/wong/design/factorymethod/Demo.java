package com.wong.design.factorymethod;

/**
 * 工厂方法设计模式，对简单工厂模式延申
 * 针对不同的对象，创建出了不同的工厂
 * <p>
 * 接口，工厂接口
 * 提供抽象方法，创建对象，创建动物
 */
public class Demo {
    public static void main(String[] args) {
        //创建猫工厂对象
        Factory factory = new CarFactory();
        Animal animal = factory.createAnimal(); //创建猫对象
        animal.eat();
    }
}