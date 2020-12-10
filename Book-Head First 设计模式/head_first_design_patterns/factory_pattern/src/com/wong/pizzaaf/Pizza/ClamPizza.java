package com.wong.pizzaaf.Pizza;

import com.wong.pizzaaf.ingredient.factory.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    
    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }
}
