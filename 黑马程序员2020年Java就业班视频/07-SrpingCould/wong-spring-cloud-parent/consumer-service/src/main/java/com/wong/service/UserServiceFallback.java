package com.wong.service;

import com.wong.pojo.User;
import org.springframework.stereotype.Component;

/**
 * 服务降级的处理类，写feign客户端中RestTemplate请求异常的服务降级处理方法
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public User queryById(Integer id) {
        User user = new User();
        user.setUsername("您好，非常抱歉，用户信息不存在！");
        return user;
    }
}
