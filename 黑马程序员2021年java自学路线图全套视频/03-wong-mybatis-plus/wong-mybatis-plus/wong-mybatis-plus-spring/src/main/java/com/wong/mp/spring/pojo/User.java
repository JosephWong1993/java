package com.wong.mp.spring.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "tb_user")
@Data
public class User {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;
}
