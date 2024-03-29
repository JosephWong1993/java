package com.itheima.nacos.entity;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String userName;

    private String password;

    private String province;

    private String city;

    private String area;

    private int sex;

    private int phone;
}
