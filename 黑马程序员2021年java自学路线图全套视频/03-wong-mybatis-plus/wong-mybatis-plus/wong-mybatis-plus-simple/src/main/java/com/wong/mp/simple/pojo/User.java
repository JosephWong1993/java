package com.wong.mp.simple.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;
}
