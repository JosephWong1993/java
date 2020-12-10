package com.wong.chocolate;

public class ChocolateBoiler {
    private boolean empty;
    
    private boolean boiled;
    
    private static ChocolateBoiler uniqueInstance;
    
    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }
    
    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating unique instance of Chocolate Boiler");
            uniqueInstance = new ChocolateBoiler();
            System.out.println("Returning instance of Chocolate Boiler");
        }
        return uniqueInstance;
    }
    
    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            //在锅炉内填满巧克力和牛奶的混合物
        }
    }
    
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            //排出煮沸的巧克力和牛奶
            empty = true;
        }
    }
    
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            //将炉内物煮沸
            boiled = true;
        }
    }
    
    public boolean isEmpty() {
        return empty;
    }
    
    public boolean isBoiled() {
        return boiled;
    }
}
