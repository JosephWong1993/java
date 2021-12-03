package com.wong.service;

import com.wong.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * dao，service测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountServiceTest {
    
    //依赖注入 AccountService
    @Autowired
    private AccountService accountService;
    
    @Test
    public void save() {
        Account account = new Account();
        account.setName("小强");
        account.setMoney(888d);
        accountService.save(account);
    }
    
    @Test
    public void deleteById() {
        accountService.deleteById(10);
    }
    
    @Test
    public void update() {
        Account account = new Account();
        account.setId(11);
        account.setName("小强");
        account.setMoney(888888d);
        accountService.update(account);
    }
    
    @Test
    public void findById() {
        Account account = accountService.findById(11);
        System.out.println("account = " + account);
    }
    
    @Test
    public void findAll() {
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}