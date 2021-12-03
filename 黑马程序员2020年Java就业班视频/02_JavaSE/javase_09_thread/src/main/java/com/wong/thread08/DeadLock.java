package com.wong.thread08;

/**
 * 实现同步代码块的嵌套：死锁
 * <p>
 * t0 执行A，再执行B
 * <p>
 * t1 执行B，在执行A
 * <p>
 * 正常写程序，死锁不能出现
 * 死锁题目：看看我们是否理解同步原理
 */
public class DeadLock implements Runnable {
    private boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            //判断变量值
            if (flag == true) {
                //flag=true 先进入A同步，再进入B同步
                synchronized (LockA.lockA) {
                    System.out.println("if...A");
                    synchronized (LockB.lockB) {
                        System.out.println("if...B");
                    }
                }
            } else {
                //flag=false 先进入B同步，再进入A同步
                synchronized (LockB.lockB) {
                    System.out.println("else...B");
                    synchronized (LockA.lockA) {
                        System.out.println("else...B");
                    }
                }
            }
        }
    }
}