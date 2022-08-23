package com.wong.listener.work;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 工作模式，消费者监听器1，用于接收工作队列中的消息
 */
@Component
@RabbitListener(queues = "work_queue")
public class WorkConsumerListener1 {
    // 监听消息的回调方法，用于处理消息
    @RabbitHandler
    public void workHandler(String msg) {
        System.out.println("工作队列接收消息监听器【1】：" + msg);
    }
}
