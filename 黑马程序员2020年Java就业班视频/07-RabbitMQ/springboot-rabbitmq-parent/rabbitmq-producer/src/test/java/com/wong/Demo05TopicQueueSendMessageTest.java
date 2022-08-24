package com.wong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RabbitMQ五种工作模式之五：通配符模式，一个生产者，多个消费者接收任务，
 * 通过路由键指定接收消息的消费者。路由键是字符串带着通配符 * #
 * 通配符#，匹配一个或多个词，每个词之间是点分割
 * 通配符*，仅仅只匹配一个词
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05TopicQueueSendMessageTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage() {
        // 参数1（exchange）：设置交换机
        // 参数2（routingKey）：设置路由键，通配符模式（item.#，info.*）
        // 参数3（object）：设置发送内容
        rabbitTemplate.convertAndSend("topic_exchange", "items.insert.abc", "路由键【items.insert.abc】");
        rabbitTemplate.convertAndSend("topic_exchange", "items.update", "路由键【items.update】.");
    }
}