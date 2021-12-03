package com.wong.study.dubbo.service;

/**
 * 用户服务
 */
public interface UserService {
    /**
     * 用户名密码登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    boolean login(String username, String password);
}
