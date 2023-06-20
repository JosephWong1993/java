package com.wong.service;

import com.wong.config.SpringConfig;
import com.wong.pojo.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//加载的xml配置文件
//@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
//加载的注解形式的java文件
@ContextConfiguration(classes = { SpringConfig.class })
public class AccountServiceTest {
    @Autowired
    /*@Qualifier("proxyAccountService")*/
    @Qualifier("cgLibAccountService")
    private AccountService accountService;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void transfer() {
        accountService.transfer("aaa", "bbb", 100d);
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