package com.wong.pizzaaf.pizza_story;

import com.wong.pizzaaf.pizza.CheesePizza;
import com.wong.pizzaaf.pizza.ClamPizza;
import com.wong.pizzaaf.pizza.PepperoniPizza;
import com.wong.pizzaaf.pizza.Pizza;
import com.wong.pizzaaf.pizza.VeggiePizza;
import com.wong.pizzaaf.ingredient_factory.NYPizzaIngredientFactory;
import com.wong.pizzaaf.ingredient_factory.PizzaIngredientFactory;

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
