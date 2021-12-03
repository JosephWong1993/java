package com.wong.thread01;

/**
 * 线程：也是对象
 * java.lang.Thread类，描述了线程对象
 * 实现多线程程序的方式一：
 * 1：定义类继承Thread
 * 2：重写方法run
 * 3：创建子类对象
 * 4：子类对象调用方法start()
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //3：创建子类对象
        MyThread myThread = new MyThread();
        //4：子类对象调用方法start()
        myThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main方法..." + i);
        }
    }
}
