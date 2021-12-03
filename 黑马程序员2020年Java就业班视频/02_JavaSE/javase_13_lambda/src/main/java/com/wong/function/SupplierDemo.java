package com.wong.function;

import java.util.function.Supplier;

/**
 * JDK8接口 Supplier
 * java.util.function.Supplier 供给
 * 只有一个抽象方法 get() 带泛型，和接口一致
 */
public class SupplierDemo {
    public static void main(String[] args) {
        /*MySupplier mySupplier = new MySupplier();
        String str = mySupplier.get();
        System.out.println(str);*/

        /*String s = getString(new MySupplier());
        System.out.println(s);*/

        /*String str = getString(new Supplier<String>() {
            @Override
            public String get() {
                return "HelloWorld";
            }
        });*/

        String a = "Hello";
        String b = "World";
        String str = getString(() -> a + b);
        System.out.println(str);
    }

    public static String getString(Supplier<String> supplier) {
        String s = supplier.get();
        return s;
    }
}

/*class MySupplier implements Supplier<String> {

    @Override
    public String get() {
        return "HelloWorld";
    }
}*/
