package com.wong.service;

import com.wong.pojo.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;
    
    @Before
    public void setUp() throws Exception {
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
        Account account = accountService.getById(1);
        System.out.println("account : " + account);
    }
    
    @Test
    public void getByName() {
        Account account = accountService.getByName("aaa");
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