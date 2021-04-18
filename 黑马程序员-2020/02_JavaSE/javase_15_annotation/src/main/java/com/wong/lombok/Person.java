package com.wong.lombok;

import lombok.*;

/**
 * lombok 第三方jar包 注解使用
 * <p>
 *
 * @Getter @Setter 生成get/set方法
 * 使用，写在类上，所有的成员变量，都生效
 * 如果写在成员变量上，只有这个变量可以使用
 * @AllArgsConstructor 生成满参数构造方法
 * @NoArgsConstructor 生成无参数构造方法
 * @ToString 生成toString()
 * @EqualsAndHashCode 生成hashCode()和equals()方法
 * @Data = @Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
 * <p>
 * 编译原理，安装插件
 * 使用注解，插件帮助写出这些方法
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private String address;
}