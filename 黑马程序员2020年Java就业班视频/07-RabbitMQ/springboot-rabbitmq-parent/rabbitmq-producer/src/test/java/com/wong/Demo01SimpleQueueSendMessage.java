package com.wong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 消息队列的五种模式：简单模式，向消息队列发送一次消息
 * 需要向当前的测试类注入RabbitTemplate对象，发送请求
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01SimpleQueueSendMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMsg() {
        // 参数1：消息队列的名称
        // 参数2：消息的内容
        rabbitTemplate.convertAndSend("simple_queue", "Hello Rabbit!!!");
    }
}