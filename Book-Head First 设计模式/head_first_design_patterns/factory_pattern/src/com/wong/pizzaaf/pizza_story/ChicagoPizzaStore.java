package com.wong.pizzaaf.pizza_story;

import com.wong.pizzaaf.pizza.CheesePizza;
import com.wong.pizzaaf.pizza.ClamPizza;
import com.wong.pizzaaf.pizza.PepperoniPizza;
import com.wong.pizzaaf.pizza.Pizza;
import com.wong.pizzaaf.pizza.VeggiePizza;
import com.wong.pizzaaf.ingredient_factory.ChicagoPizzaIngredientFactory;
import com.wong.pizzaaf.ingredient_factory.PizzaIngredientFactory;

public class ChicagoPizzaStore extends PizzaStore {
    
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        
        if (item.equals("cheese")) {
            
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
            
        } else if (item.equals("veggie")) {
            
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("Chicago Style Veggie Pizza");
            
        } else if (item.equals("clam")) {
            
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
            
        } else if (item.equals("pepperoni")) {
            
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("Chicago Style Pepperoni Pizza");
            
        }
        return pizza;
    }
}
