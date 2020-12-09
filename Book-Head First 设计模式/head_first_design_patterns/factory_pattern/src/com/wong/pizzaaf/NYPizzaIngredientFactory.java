package com.wong.pizzaaf;

import com.wong.pizzaaf.ingredient.Cheese;
import com.wong.pizzaaf.ingredient.Clams;
import com.wong.pizzaaf.ingredient.Dough;
import com.wong.pizzaaf.ingredient.Impl.FreshClams;
import com.wong.pizzaaf.ingredient.Impl.Garlic;
import com.wong.pizzaaf.ingredient.Impl.MarinaraSauce;
import com.wong.pizzaaf.ingredient.Impl.Mushroom;
import com.wong.pizzaaf.ingredient.Impl.Onion;
import com.wong.pizzaaf.ingredient.Impl.RedPepper;
import com.wong.pizzaaf.ingredient.Impl.ReggianoCheese;
import com.wong.pizzaaf.ingredient.Impl.SlicedPepperoni;
import com.wong.pizzaaf.ingredient.Impl.ThinCrustDough;
import com.wong.pizzaaf.ingredient.Pepperoni;
import com.wong.pizzaaf.ingredient.Sauce;
import com.wong.pizzaaf.ingredient.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }
    
    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }
    
    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }
    
    @Override
    public Veggies[] createVeggies() {
        return new Veggies[] { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
    }
    
    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }
    
    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
