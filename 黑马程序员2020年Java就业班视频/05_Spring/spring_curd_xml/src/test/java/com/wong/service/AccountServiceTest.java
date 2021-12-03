package com.wong.service;

import com.wong.dao.AccountDao;
import com.wong.pojo.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class AccountServiceTest {
    private AccountService accountService;
    
    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        accountService = applicationContext.getBean(AccountService.class);
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void insert() {
    }
    
    @Test
    public void delete() {
    }
    
    @Test
    public void update() {
        Account account = new Account();
        account.setId(3);
        account.setName("隔壁老王");
        account.setMoney(999999d);
        
        accountService.update(account);
    }
    
    @Test
    public void getById() {
        Account account=accountService.getById(1);
        System.out.println("account : " + account);
    }
    
    @Test
    public void getByName() {
        Account account=accountService.getByName("aaa");
        System.out.println("account : " + account);
    }
    
    @Test
    public void listAll() {
        List<Account> accountList = accountService.listAll();
        for (Account account : accountList) {
            System.out.println("account : " + account);
        }
    }
}