package com.wong.service;

import com.wong.pojo.User;

public interface UserService {
    User findByUsername(String username);
}
