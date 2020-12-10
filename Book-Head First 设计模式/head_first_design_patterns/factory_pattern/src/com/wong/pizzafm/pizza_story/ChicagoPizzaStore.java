package com.wong.pizzafm.pizza_story;

import com.wong.pizzafm.pizza.ChicagoStyleCheesePizza;
import com.wong.pizzafm.pizza.ChicagoStyleClamPizza;
import com.wong.pizzafm.pizza.ChicagoStylePepperoniPizza;
import com.wong.pizzafm.pizza.ChicagoStyleVeggiePizza;
import com.wong.pizzafm.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    
    protected Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        } else if (item.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } else if (item.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else
            return null;
    }
}