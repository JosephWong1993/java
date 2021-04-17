package com.wong.thread;

import lombok.Getter;
import lombok.Setter;

/**
 * 资源对象，包子
 * 被线程调用的
 */
public class BaoZiPu {
    /**
     * set方法，被生产者线程调用，++变量
     */
    @Getter
    @Setter
    private int count;
}
