package com.wong.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.wong")
public class Properties {
    private Integer id;
    private String username;
    private String password;
}