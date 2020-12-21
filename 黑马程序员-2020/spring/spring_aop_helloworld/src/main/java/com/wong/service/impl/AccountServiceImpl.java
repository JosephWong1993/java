package com.wong.service.impl;

import com.wong.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        //打印一句话，日志（前置增强）
        
        System.out.println("保存了账户");
    }
}