package com.wong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/sayHello")
    public void SayHello(){
        System.out.println("sayHello");
    }
}