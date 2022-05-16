package com.wong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${wong.spring-boot.one-example}")
    private String name;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(name);
        return "松散绑定：" + name;
    }
}
