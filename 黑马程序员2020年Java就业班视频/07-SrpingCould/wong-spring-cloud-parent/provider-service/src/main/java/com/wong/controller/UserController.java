package com.wong.controller;

import com.wong.pojo.User;
import com.wong.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RefreshScope // 刷新配置
public class UserController {
    private final UserService userService;

    @Value("${server.port}")
    private String port;

    @Value("${test.hello}")
    private String name;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 根据id查询
     */
    @RequestMapping("/findById")
    public User findById(@RequestParam("id") Integer id) {
//        Thread.sleep(3000);
        // 手动抛出异常
        if (id == 1) {
            throw new RuntimeException("啊，我死掉了！！！");
        }
        User user = userService.queryById(id);
        user.setNote("当前服务端口：" + port + "; name = " + name);
        return user;
    }
}