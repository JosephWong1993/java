package com.wong.function;

import java.util.function.Predicate;

/**
 * java.util.function.PredicateDemo 接口
 * 抽象方法：
 * Predicate<String>
 * boolean test(T t);
 */
public class PredicateDemo {
    public static void main(String[] args) {
        boolean b = getBoolean(s -> s.length() > 5, "Hello");
        System.out.println(b);
    }

    public static boolean getBoolean(Predicate<String> predicate, String str) {
        return predicate.test(str);
    }
}
