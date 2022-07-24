package com.wong.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wong.pojo.User;
import com.wong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * 通过Feign客户端发送请求
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallBackMethods") // 设置全局的
public class FeignConsumerController {

    // 注入Feign客户端的接口
    private final UserService userService;

    public FeignConsumerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/feign-consumer/{id}")
    public User consumerSendRequest(@PathVariable Integer id) {
        return userService.queryById(id);
    }
}