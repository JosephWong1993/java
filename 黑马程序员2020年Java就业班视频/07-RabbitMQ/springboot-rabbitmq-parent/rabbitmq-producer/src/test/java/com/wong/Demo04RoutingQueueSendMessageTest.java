package com.wong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RabbitMQ五种工作模式之四：路由模式，一个生产者，多个消费者接收任务，通过路由键指定接收消息的消费者（info.error）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo04RoutingQueueSendMessageTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage() {
        for (int i = 0; i < 1000; i++) {
            String routingKey = "info";
            if (i % 2 == 0) {
                routingKey = "error";
            }
            // 参数1（exchange）：设置交换机
            // 参数2（routingKey）：设置路由键
            // 参数3（object）：设置发送内容
            rabbitTemplate.convertAndSend("routing_exchange", routingKey, "You are bad. Rabbit【" + i + "】");
        }
    }
}