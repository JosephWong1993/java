package com.wong.mp.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.wong.mp.enums.SexEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
//@TableName(value = "tb_user")
public class User extends Model<User> {
    //    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    @TableField(select = false, fill = FieldFill.INSERT)
    private String password;
    private String name;
    private Integer age;
    @TableField(value = "email")
    private String mail;
    @TableField(exist = false)
    private String address;
    @Version //乐观锁的版本字段
    private Integer version;
    @TableLogic
    private Integer deleted;
    private SexEnum sex;
}
