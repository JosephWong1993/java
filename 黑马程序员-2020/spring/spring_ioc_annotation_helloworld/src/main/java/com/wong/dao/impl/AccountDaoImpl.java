package com.wong.dao.impl;

import com.wong.dao.AccountDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
@Repository
@Scope("prototype")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("模拟保存账户");
    }
    
    //构造方法执行完毕后执行
    @PostConstruct
    public void init() {
        System.out.println("AccountDaoImpl对象初始化");
    }
    
    //对象销毁前执行的方法
    @PreDestroy
    public void destroy() {
        System.out.println("AccountDaoImpl对象销毁");
    }
}
