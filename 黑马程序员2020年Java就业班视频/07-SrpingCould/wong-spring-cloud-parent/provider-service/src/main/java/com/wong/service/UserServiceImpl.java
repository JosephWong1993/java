package com.wong.service;

import com.wong.mappers.UserMapper;
import com.wong.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }
}