package com.wong.service.impl;

import com.wong.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        System.out.println("保存账户...");
        int i = 1 / 0;
    }
    
    @Override
    public void update(int i) {
        System.out.println("更新账户..." + i);
    }
    
    @Override
    public int delete() {
        System.out.println("删除账户...");
        return 999;
    }
}
