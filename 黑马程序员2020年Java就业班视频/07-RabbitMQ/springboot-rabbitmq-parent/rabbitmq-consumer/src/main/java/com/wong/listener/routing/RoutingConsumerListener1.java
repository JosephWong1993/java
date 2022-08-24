package com.wong.listener.routing;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 路由模式，消费者监听器1，用于接收routing队列中的消息
 */
@Component
@RabbitListener(queues = "routing_queue_1")
public class RoutingConsumerListener1 {
    // 监听消息的回调方法，用于处理消息
    @RabbitHandler
    public void workHandler(String msg) {
        System.out.println("路由模式接收消息监听器【1】：" + msg);
    }
}