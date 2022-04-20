package com.wong.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ConfigurationProperties 批量注入配置信息到对象中，必备条件：
 * 第一：导入spring-boot-configuration-processor坐标
 * 第二：把当前的对象，注入到Spring的容器中
 */
@ConfigurationProperties(prefix = "person")
@Component
@Data
public class Person {
    private String name;

    private Integer age;

    private String address;

    private String[] cityArray;

    private List<Animal> animals;
}
