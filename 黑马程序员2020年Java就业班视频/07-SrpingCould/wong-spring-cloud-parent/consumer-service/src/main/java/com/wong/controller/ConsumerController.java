package com.wong.controller;

import com.wong.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者的控制层，提供服务，访问提供者接口，为真实用户返回信息
 */
@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/{id}")
    public User consumerSendRequest(@PathVariable Integer id) {
        String url = "http://localhost:8080/user/query_by_id?id=" + id;
        return restTemplate.getForObject(url, User.class);
    }

    @GetMapping("/consumer/{name}/{id}")
    public Integer restOne(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id);
        return id;
    }
}