package com.wong.pizzaaf.ingredient.factory;

import com.wong.pizzaaf.ingredient.Cheese;
import com.wong.pizzaaf.ingredient.Clams;
import com.wong.pizzaaf.ingredient.Dough;
import com.wong.pizzaaf.ingredient.BlackOlives;
import com.wong.pizzaaf.ingredient.Eggplant;
import com.wong.pizzaaf.ingredient.FrozenClams;
import com.wong.pizzaaf.ingredient.MozzarellaCheese;
import com.wong.pizzaaf.ingredient.PlumTomatoSauce;
import com.wong.pizzaaf.ingredient.SlicedPepperoni;
import com.wong.pizzaaf.ingredient.Spinach;
import com.wong.pizzaaf.ingredient.ThickCrustDough;
import com.wong.pizzaaf.ingredient.Pepperoni;
import com.wong.pizzaaf.ingredient.Sauce;
import com.wong.pizzaaf.ingredient.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }
    
    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
    
    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }
    
    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new BlackOlives(), new Spinach(), new Eggplant() };
        return veggies;
    }
    
    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }
    
    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
