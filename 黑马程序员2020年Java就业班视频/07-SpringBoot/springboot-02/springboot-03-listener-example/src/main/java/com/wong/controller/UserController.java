package com.wong.controller;

import com.wong.pojo.User;
import com.wong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    // 缓存的唯一标识
    public static final String key = UserController.class.getName() + ".findAll()";

    /**
     * 查询所有用户信息
     */
    @RequestMapping("find_all")
    public List<User> findAll() {
        /*
         * 首先从redis缓存取数据：key，service接口的全限定名称+方法名称
         * 如果有：返回给用户
         * 如果没有：从数据库中查询，然后返回给用户，并存储到redis缓存中
         */
        //service接口的全限定名称+方法名称
//        String key = userService.getClass().getName() + "findAll";
        //首先从redis缓存取数据
        List<User> users = (List<User>) redisTemplate.boundValueOps(key).get();
        //判断用户数据是否存在
        if (null == users) {
            //没有：从数据库中查询，然后返回给用户，并存储到redis缓存中
            users = userService.findList();
            redisTemplate.boundValueOps(key).set(users);
            System.out.println("从数据库中取数据");
        } else {
            System.out.println("从Redis缓存中取数据");
        }
        //有：返回给用户
        return users;
    }
}
