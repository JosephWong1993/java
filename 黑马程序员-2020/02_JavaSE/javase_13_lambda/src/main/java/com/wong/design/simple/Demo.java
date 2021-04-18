package com.wong.design.simple;

/**
 * 简单工厂设计模式：
 * 工厂生产对象
 * 对象创建，不是只能创建一个对象，创建一类对象
 */
public class Demo {
    public static void main(String[] args) {
        //工厂创建对象
        Animal animal = AnimalFactory.createAnime("dog");
        animal.eat();
    }
}