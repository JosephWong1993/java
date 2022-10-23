package com.wong.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ChangegouEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChangegouEurekaApplication.class, args);
    }
}