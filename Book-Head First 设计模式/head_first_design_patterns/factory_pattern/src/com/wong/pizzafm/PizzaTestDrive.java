package com.wong.pizzafm;

import com.wong.pizzafm.pizza.Pizza;
import com.wong.pizzafm.pizza_story.ChicagoPizzaStore;
import com.wong.pizzafm.pizza_story.NYPizzaStore;
import com.wong.pizzafm.pizza_story.PizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nystore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        
        Pizza pizza = nystore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
