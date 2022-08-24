package com.wong.listener.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 发布订阅模式（广播模式），消费者监听器1，用于接收fanout队列中的消息
 */
@Component
@RabbitListener(queues = "fanout_queue_1")
public class FanoutConsumerListener1 {
    // 监听消息的回调方法，用于处理消息
    @RabbitHandler
    public void workHandler(String msg) {
        System.out.println("广播模式接收消息监听器【1】：" + msg);
    }
}
