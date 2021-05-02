package com.wong.study.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wong.study.dubbo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        System.out.println("[登录]u：" + username + "，p：" + password);

        boolean success = userService.login(username, password);
        if (success) {
            return "login success";
        }
        return "login fail";
    }
}
