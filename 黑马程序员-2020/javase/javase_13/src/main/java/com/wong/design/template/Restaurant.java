package com.wong.design.template;

/**
 * 饭店类：
 * 点菜
 * 吃菜
 * 结账
 * <p>
 * 吃菜：不明确过程
 * 先不做，等待子类实现（方法的重写）
 * <p>
 * eatingMethod() 对外暴露出去的模板方法：不做任何实现，等待子类进行重写
 *
 * 父类调用了子类的重写方法
 */
public abstract class Restaurant {
    public void eat() {
        System.out.println("看菜单点菜");
        eatingMethod();
        System.out.println("结账");
    }
    
    public abstract void eatingMethod();
}
