package com.wong.controller;

import com.wong.pojo.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * 消费者的控制层，提供服务，访问提供者接口，为真实用户返回信息
 */
@RestController
public class ConsumerController {
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public ConsumerController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

//    @GetMapping("/consumer/{id}")
//    public User consumerSendRequest(@PathVariable Integer id) {
//        String url = "http://localhost:8080/user/query_by_id?id=" + id;
//        return restTemplate.getForObject(url, User.class);
//    }

    @GetMapping("/consumer/{name}/{id}")
    public Integer restOne(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id);
        return id;
    }

    /**
     * 通过注册中心的注册列表，访问服务提供者，实现url地址host和port动态获取
     */
    @GetMapping("/consumer/{id}")
    public User consumerSendRequest(@PathVariable Integer id) {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("provider-service");
        ServiceInstance providerServiceInstance = serviceInstanceList.get(0);
        String host = providerServiceInstance.getHost();
        int port = providerServiceInstance.getPort();
        Map<String, String> metadata = providerServiceInstance.getMetadata();
        System.out.println("当前provider-service服务的元数据：：" + metadata);
        // 动态拼接访问地址
        String url = "http://" + host + ":" + port + "/user/query_by_id?id=" + id;
        return restTemplate.getForObject(url, User.class);
    }

    @GetMapping("/ribbon_consumer/{id}")
    public User ribbonQueryById(@PathVariable Integer id) {
        // 负载均衡访问服务的url地址，注意host和port变为服务名称，传统的地址随即失效
        String url = "http://provider-service/user/query_by_id?id=" + id;
        return restTemplate.getForObject(url, User.class);
    }
}