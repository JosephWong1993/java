package com.itheima.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExampleWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleWebApplication.class,args);
    }
}
