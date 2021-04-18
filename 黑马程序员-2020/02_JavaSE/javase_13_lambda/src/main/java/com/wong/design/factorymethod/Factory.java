package com.wong.design.factorymethod;

/**
 * 工厂接口，规则就是工厂必须创建动物对象
 */
public interface Factory {
    public abstract Animal createAnimal();
}
