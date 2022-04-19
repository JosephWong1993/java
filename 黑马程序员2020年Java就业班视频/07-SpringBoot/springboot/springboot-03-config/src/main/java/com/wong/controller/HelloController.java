package com.wong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 向浏览器输出一个字符串：Hi, my name is SpringBoot!!!
 */
@RestController
public class HelloController {

    @Value("${message1}")
    private String message1;

    @Value("${message2}")
    private String message2;

    @RequestMapping("say_hello")
    public String sayHello() {
        System.out.println(message1);
        System.out.println(message2);
        return "Hi, my name is SpringBoot!!!message1 : " + message1 + "; message2 : " + message2;
    }
}