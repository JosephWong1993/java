package com.wong.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息Controller类，用于向消息队列发送消息
 */
@RestController
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 向消息队列中发送消息
     * http://127.0.0.1:48080/direct/sendMsg?exchange=order_exchange&routingKey=order.A&msg=购买苹果手机
     */
    @RequestMapping("/direct/sendMsg")
    public String sendMsg(@RequestParam String exchange, String routingKey, String msg) {
        // 执行消息的发送
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        return "消息已投递！";
    }
}