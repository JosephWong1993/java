package com.wong.pizzaaf.pizza;

import com.wong.pizzaaf.ingredient_factory.PizzaIngredientFactory;

public class PepperoniPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    
    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();
    }
}
