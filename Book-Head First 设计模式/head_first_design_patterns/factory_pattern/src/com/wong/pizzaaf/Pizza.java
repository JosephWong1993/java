package com.wong.pizzaaf;

import com.wong.pizzaaf.ingredient.Cheese;
import com.wong.pizzaaf.ingredient.Clams;
import com.wong.pizzaaf.ingredient.Dough;
import com.wong.pizzaaf.ingredient.Pepperoni;
import com.wong.pizzaaf.ingredient.Sauce;
import com.wong.pizzaaf.ingredient.Veggies;

public abstract class Pizza {
    String name;
    
    Dough dough;
    
    Sauce sauce;
    
    Veggies veggies[];
    
    Cheese cheese;
    
    Pepperoni pepperoni;
    
    Clams clam;
    
    abstract void prepare();
    
    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    
    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    
    void box() {
        System.out.println("Place pizza in officialPizzaStore box");
    }
    
    void setName() {
        this.name = name;
    }
    
    String getName() {
        return name;
    }
    
    public String toString() {
        //这里是打印披萨的代码
        StringBuffer result = new StringBuffer();
        result.append("---- " + name + " ----\n");
        if (dough != null) {
            result.append(dough);
            result.append("\n");
        }
        if (sauce != null) {
            result.append(sauce);
            result.append("\n");
        }
        if (cheese != null) {
            result.append(cheese);
            result.append("\n");
        }
        if (veggies != null) {
            for (int i = 0; i < veggies.length; i++) {
                result.append(veggies[i]);
                if (i < veggies.length - 1) {
                    result.append(", ");
                }
            }
            result.append("\n");
        }
        if (clam != null) {
            result.append(clam);
            result.append("\n");
        }
        if (pepperoni != null) {
            result.append(pepperoni);
            result.append("\n");
        }
        return result.toString();
    }
}
