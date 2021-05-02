package com.wong.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wong.study.dubbo.service.UserService;

@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String username, String password) {
        System.out.println("[登录]u：" + username + "，p：" + password);
        return "admin".equals(username) && "123".equals(password);
    }
}