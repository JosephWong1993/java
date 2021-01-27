package com.wong.function;

import java.util.function.Supplier;

/**
 * 函数式接口Supplier，实现数组最大值获取
 */
public class SupplierDemo02 {
    public static void main(String[] args) {
        int[] array = {1, 4, 5, 2, 6, 8, 0};
        int arrayMax = getArrayMax(() -> {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        });
        System.out.println(arrayMax);
    }

    public static int getArrayMax(Supplier<Integer> supplier) {
        return supplier.get();
    }
}
