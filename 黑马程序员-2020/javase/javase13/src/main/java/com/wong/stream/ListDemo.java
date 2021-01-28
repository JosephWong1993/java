package com.wong.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求：操作集合
 * list集合存储一些元素
 * <p>
 * list集合，获取出所有姓张的，保存
 * <p>
 * 姓张集合中，获取名字是三个字的，保存
 * <p>
 * 集合操作弊端，代码量大，重复性高，浪费内存
 * <p>
 * JDK8出现新特性，Stream流对象
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //定义集合，保存姓张的
        List<String> zhangList = new ArrayList<>();
        //遍历list集合，找元素是姓张的，存储在zhangList
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }

        System.out.println(zhangList);

        //定义集合，保存名字是三个字
        List<String> sanList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                sanList.add(name);
            }
        }
        System.out.println(sanList);
    }
}
