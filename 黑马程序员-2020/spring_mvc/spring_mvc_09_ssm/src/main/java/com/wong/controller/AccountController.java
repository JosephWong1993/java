package com.wong.controller;

import com.wong.pojo.Account;
import com.wong.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 账户的控制层
 */

@RestController
@RequestMapping("account")
public class AccountController {
    //依赖注入AccountService对象
    private AccountService accountService;
    
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    /**
     * 改
     */
    @RequestMapping("update")
    public String update(@RequestBody Account account) {
        //调用Service层的修改方法
        accountService.update(account);
        return "修改成功";
    }
    
    /**
     * 查（根据id 查询账户对象）
     */
    @RequestMapping("findById")
    public Account findById(Integer id) {
        //调用service， 获取指定id 对应的account对象
        Account account = accountService.findById(id);
        return account;
    }
    
    /**
     * 查（查询所有账户对象）
     */
    @RequestMapping("findAll")
    public List<Account> findAll() {
        System.out.println("findAll 执行了");
        //调用service，获取所有的账户信息
        List<Account> accountList = accountService.findAll();
        return accountList;
    }
}