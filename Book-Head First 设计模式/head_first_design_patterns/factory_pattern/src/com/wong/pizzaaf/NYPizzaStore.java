package com.wong.pizzaaf;

import com.wong.pizzaaf.Pizza.CheesePizza;
import com.wong.pizzaaf.Pizza.ClamPizza;
import com.wong.pizzaaf.Pizza.PepperoniPizza;
import com.wong.pizzaaf.Pizza.Pizza;
import com.wong.pizzaaf.Pizza.VeggiePizza;
import com.wong.pizzaaf.ingredient.factory.NYPizzaIngredientFactory;
import com.wong.pizzaaf.ingredient.factory.PizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {
    
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("veggie")) {
            
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
            
        } else if (item.equals("clam")) {
            
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
            
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
            
        }
        return pizza;
    }
}
