package com.wong.controller;

import com.wong.pojo.User;
import com.wong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 根据id查询
     */
    @RequestMapping("/query_by_id")
    public User queryById(@RequestParam("id") Integer id) {
        return userService.queryById(id);
    }
}