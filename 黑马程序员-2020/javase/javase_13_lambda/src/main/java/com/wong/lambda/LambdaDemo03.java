package com.wong.lambda;

import com.wong.domain.Person;

import java.util.*;

/**
 * 带有返回值和参数的lambda表达式
 * 分析：
 * 目的是集合排序，自定义比较器
 * 不得已，实现接口Comparator，重写方法compare
 * sort方法，传递接口实现类
 * <p>
 * lambda 去掉面向对象束缚
 * <p>
 * 实现接口，重写方法
 */
public class LambdaDemo03 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("杨幂", 30));
        list.add(new Person("杨紫", 32));
        System.out.println(list);

        //集合排序
//        Collections.sort(list, new MyComparator());

//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });

        //Lambda表达式，简化匿名内部类
        //(参数Person对象)->参数传递到方法体
        //{方法体，可以直接使用参数}
        Collections.sort(list, (Person p1, Person p2) -> {
            return p2.getAge() - p1.getAge();
        });

        System.out.println(list);
    }
}

class MyComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p2.getAge() - p1.getAge();
    }
}
