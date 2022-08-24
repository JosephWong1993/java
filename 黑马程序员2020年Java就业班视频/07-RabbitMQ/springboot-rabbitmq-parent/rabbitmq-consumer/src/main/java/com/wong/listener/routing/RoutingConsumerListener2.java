package com.wong.listener.routing;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 路由模式，消费者监听器2，用于接收routing队列中的消息
 */
@Component
@RabbitListener(queues = "routing_queue_2")
public class RoutingConsumerListener2 {
    // 监听消息的回调方法，用于处理消息
    @RabbitHandler
    public void workHandler(String msg) {
        System.out.println("路由模式接收消息监听器【2】：" + msg);
    }
}