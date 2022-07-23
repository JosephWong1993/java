package com.wong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 开启客户端发现的自动配置
public class ConsumerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    /*
    * 一旦开启@LoadBalanced，传统url地址就使用不了了
    * 传统的url地址
    * http://127.0.0.1:29091/usr/query_by_id?id=1
    * 负载均衡地址
    * http://provider-service/usr/query_by_id?id=1
    * */

    @Bean
    @LoadBalanced // 开启当前RestTemplate对象，支持负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
