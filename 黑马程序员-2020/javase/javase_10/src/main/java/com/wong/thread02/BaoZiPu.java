package com.wong.thread02;

/**
 * 资源对象，包子
 * 被线程调用的
 */
public class BaoZiPu {

    private int count;

    /**
     * 定义布尔变量，标志位
     */
    private boolean flag;

    /**
     * get方法，被消费者线程调用，输出
     */
    public synchronized void get() {
        //判断标志位，是否允许消费
        while (flag == false) {//没有包子，等，不能消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费第" + count + "个包子");
        flag = false;
        this.notifyAll();
    }

    /**
     * set方法，被生产者线程调用，++变量
     */
    public synchronized void set() {
        //判断标志位，是否允许生产
        while (flag == true) {//有包子，不能生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println("生产第" + count + "个包子");
        flag = true;
        this.notifyAll();
    }
}
