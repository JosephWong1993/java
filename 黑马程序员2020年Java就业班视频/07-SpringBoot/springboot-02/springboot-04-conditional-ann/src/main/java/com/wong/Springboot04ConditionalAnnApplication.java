package com.wong;

import com.wong.pojo.Dog;
import com.wong.config.SpringConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class Springboot04ConditionalAnnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot04ConditionalAnnApplication.class, args);
        Dog dog = context.getBean(Dog.class);
        System.out.println(dog);
    }
}
