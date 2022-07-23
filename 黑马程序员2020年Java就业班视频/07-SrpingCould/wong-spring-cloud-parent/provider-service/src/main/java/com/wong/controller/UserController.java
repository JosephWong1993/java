package com.wong.controller;

import com.wong.pojo.User;
import com.wong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Value("${server.port}")
    private String port;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 根据id查询
     */
    @RequestMapping("/query_by_id")
    public User queryById(@RequestParam("id") Integer id) throws InterruptedException {
//        Thread.sleep(3000);
        // 手动抛出异常
        if (id == 1) {
            throw new RuntimeException("啊，我死掉了！！！");
        }
        User user = userService.queryById(id);
        user.setNote("当前服务端口：" + port);
        return user;
    }


}