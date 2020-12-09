package com.wong.pizzaaf;

import com.wong.pizzaaf.ingredient.Cheese;
import com.wong.pizzaaf.ingredient.Clams;
import com.wong.pizzaaf.ingredient.Dough;
import com.wong.pizzaaf.ingredient.Pepperoni;
import com.wong.pizzaaf.ingredient.Sauce;
import com.wong.pizzaaf.ingredient.Veggies;

/**
 * 披萨原料工厂
 */
public interface PizzaIngredientFactory {
    /**
     * 生产面团
     */
    public Dough createDough();
    
    /**
     * 生产酱料
     */
    public Sauce createSauce();
    
    /**
     * 生产芝士
     */
    public Cheese createCheese();
    
    /**
     * 生产蔬菜
     */
    public Veggies[] createVeggies();
    
    /**
     * 生产意式腊肠
     */
    public Pepperoni createPepperoni();
    
    /**
     * 生产蛤蜊
     */
    public Clams createClam();
}
