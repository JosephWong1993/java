package com.wong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling// 开启SpringBoot的定时器功能支持
public class Springboot05TimerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05TimerApplication.class, args);
    }

}
