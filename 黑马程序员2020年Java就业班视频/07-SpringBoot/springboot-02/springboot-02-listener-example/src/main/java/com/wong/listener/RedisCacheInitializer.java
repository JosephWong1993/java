package com.wong.listener;

import com.wong.controller.UserController;
import com.wong.pojo.User;
import com.wong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 初始化查询所有用户数据的缓存
 */
@Component
public class RedisCacheInitializer implements ApplicationRunner {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 初始化查询用户所有信息的缓存
        List<User> users = userService.findList();
        redisTemplate.boundValueOps(UserController.key).set(users);
    }
}
