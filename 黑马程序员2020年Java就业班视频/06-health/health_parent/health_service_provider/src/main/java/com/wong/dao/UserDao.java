package com.wong.dao;

import com.wong.pojo.User;

public interface UserDao {
    User findByUsername(String username);
}
