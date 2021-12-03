package com.wong.thread;

import lombok.Getter;
import lombok.Setter;

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
    public int get() {
        System.out.println("消费第" + count + "个包子");
        return count;
    }

    /**
     * set方法，被生产者线程调用，++变量
     */
    public void set() {
        count++;
        System.out.println("生产第" + count + "个包子");
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
