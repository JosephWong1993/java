package com.wong.listener.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 通配符模式，消费者监听器1，用于接收topic队列中的消息
 */
@Component
@RabbitListener(queues = "topic_queue_1")
public class TopicConsumerListener1 {
    // 监听消息的回调方法，用于处理消息
    @RabbitHandler
    public void workHandler(String msg) {
        System.out.println("通配符模式接收消息监听器【1】：" + msg);
    }
}