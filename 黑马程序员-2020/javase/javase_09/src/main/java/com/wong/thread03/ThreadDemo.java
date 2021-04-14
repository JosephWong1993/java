package com.wong.thread03;

/**
 * 获取线程的名字
 * <p>
 * 每个线程都有名字，
 * 默认的是Thread-0，Thread-1
 * Thread类有方法
 * String getName() 获取线程名
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
