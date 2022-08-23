package com.wong.listener.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 简单的消息队列监听器,监听器，监听队列中是否有消息
 * 如果有消息触发接受方法，将消息打印到控制台
 * 注意：必须把监听器注入Spring的容器中
 *
 * @RabbitListener(queues = "simple_queue") 注解作用：声明当前类为消费者接受消息的监听器
 * queues：设置当前监听的消息队列名称
 */
@Component
@RabbitListener(queues = "simple_queue")
public class SimpleConsumerListener {
    /**
     * @param msg
     * @RabbitHandler 注解作用：指定当前监听器中方法，处理接收请求
     * 当前监听方法，参数必须有一个String,用来接收消息内容
     */
    @RabbitHandler
    public void SimpleConsumerHandler(String msg) {
        System.out.println("简单消息队列接收消息内容：" + msg);
    }
}