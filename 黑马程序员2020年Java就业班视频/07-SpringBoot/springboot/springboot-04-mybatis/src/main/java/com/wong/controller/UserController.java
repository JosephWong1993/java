package com.wong.controller;

import com.wong.pojo.User;
import com.wong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     */
    @RequestMapping("find_all")
    public List<User> findAll() {
        return userService.findList();
    }
}
