package com.wong.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
}
