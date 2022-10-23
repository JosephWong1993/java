package com.wong.changgou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.wong.changgou.goods.dao")
public class ChanggouServiceGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChanggouServiceGoodsApplication.class, args);
    }
}
