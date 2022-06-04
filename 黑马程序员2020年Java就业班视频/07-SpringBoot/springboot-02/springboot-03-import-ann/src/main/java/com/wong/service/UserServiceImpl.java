package com.wong.service;

import org.springframework.stereotype.Service;

import java.util.List;

// 不写@Service的注入的注解
//@Service
public class UserServiceImpl implements UserService {
    @Override
    public List findAll() {
        System.out.println("==假装我是一个service层的实现类防范==");
        return null;
    }
}
