package com.wong.thread03;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程名字::" + getName());
    }
}
