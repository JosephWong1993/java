package com.wong.thread09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private int tickets = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            lock.lock();
            //线程休眠
            try {
                if (tickets > 0) {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "出售第::" + tickets--);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}