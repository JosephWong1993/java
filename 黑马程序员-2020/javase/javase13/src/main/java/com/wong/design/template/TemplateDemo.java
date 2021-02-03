package com.wong.design.template;

/**
 * 模板方法设计：
 * 明确了一部分功能，而另一部分功能不明确
 * 点菜，怎么吃，买单
 */
public class TemplateDemo {
    public static void main(String[] args) {
        Restaurant restaurant = new ChengDuSnacksRestaurant();
        restaurant.eat();
    }
}