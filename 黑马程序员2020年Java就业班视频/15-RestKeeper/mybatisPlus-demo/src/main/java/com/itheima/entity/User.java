package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_user")
public class User {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    //    @TableField(value = "username")
    private String username;
    //    @TableField(value = "password")
    private String password;
}
