package com.wong.service;

import com.wong.dao.UserDao;
import com.wong.pojo.User;

import java.sql.SQLException;

/**
 * 注册功能的业务
 * web层调用业务层的方法，传递User对象
 * 业务层调用dao层方法，传递User
 */
public class UserService {
    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @return User对象
     */
    public User login(String username, String password) {
        //调用dao层方法，传递参数，获取结果集
        UserDao userDao = new UserDao();
        User user = null;
        try {
            user = userDao.login(username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public void register(User user) {
        UserDao userDao = new UserDao();
        try {
            userDao.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
