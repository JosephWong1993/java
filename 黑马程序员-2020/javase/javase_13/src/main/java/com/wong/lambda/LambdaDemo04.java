package com.wong.lambda;

import com.wong.domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lambda表达式的好处和弊端
 * <p>
 * 弊端：使用场景局限太大
 * 适用于接口，接口中只能有一个抽象方法
 * Runnable接口，只有一个抽象方法run
 * Comparator接口，只有一个抽象方法compare
 * <p>
 * 好处：
 * 减少代码量
 * 可推导可省略
 * 1：方法体：只有一行代码，{}可以不写
 * 2：方法依赖接口，明确返回int类型 return int;
 * 3：方法参数
 * sort(list)集合排序，list集合明确了存储的数据类型 泛型 <Person>
 * 比较器接口Comparator，比较的对象也是Person
 * 参数类型可以省略
 */
interface A {
    public abstract void show();

    //    public abstract void show2();
    public default void method() {

    }
}

public class LambdaDemo04 {
    public static void main(String[] args) {
        /*A a = new A() {
            @Override
            public void show() {

            }
        };

        A a2 = () -> {
        };*/

        List<Person> list = new ArrayList<>();
        list.add(new Person("杨幂", 30));
        list.add(new Person("杨紫", 32));
        System.out.println(list);

//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });

        Collections.sort(list, (Person p1, Person p2) -> p2.getAge() - p1.getAge());
        System.out.println(list);
    }
}
