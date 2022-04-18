package com.wong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 向浏览器输出一个字符串：Hi, my name is SpringBoot!!!
 */
@RestController
public class HelloController {
    @RequestMapping("say_hello")
    public String sayHello() {
        return "Hi, my name is SpringBoot!!!";
    }
}
