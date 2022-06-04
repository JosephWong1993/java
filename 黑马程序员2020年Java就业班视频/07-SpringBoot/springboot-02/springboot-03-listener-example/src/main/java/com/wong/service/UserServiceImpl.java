package com.wong.service;

import com.wong.mapper.UserMapper;
import com.wong.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findList() {
        return userMapper.findAll();
    }
}
