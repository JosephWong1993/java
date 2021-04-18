package com.wong.service.impl;

import com.wong.dao.AccountDao;
import com.wong.pojo.Account;
import com.wong.service.AccountService;
import com.wong.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

/**
 * 账户业务层接口实现类
 */
@Service
public class AccountServiceImpl implements AccountService {
    public AccountServiceImpl() {
        
    }
    
    private TransactionManager transactionManager;
    
    public AccountServiceImpl(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    //依赖注入
    private AccountDao accountDao;
    
    @Autowired(required = false)
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    //转账
    @Override
    public void transfer(String resource, String target, double money) {
        //1.根据name获取账户对象
        Account resourceAccount = accountDao.getByName(resource);
        //查看当前代码执行所在的线程对象
        System.out.println("当前线程：" + Thread.currentThread().getName());
        
        Account targetAccount = accountDao.getByName(target);
        //2.更新账户对象中金额
        resourceAccount.setMoney(resourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        //3.更新数据库中账户对象的金额
        accountDao.update(resourceAccount);
        /*int i = 1 / 0;*/
        accountDao.update(targetAccount);
    }
    
    @Override
    public void insert(Account account) {
        accountDao.insert(account);
    }
    
    @Override
    public void delete(int id) {
        accountDao.delete(id);
    }
    
    @Override
    public void update(Account account) {
        accountDao.update(account);
    }
    
    @Override
    public Account getById(int id) {
        return accountDao.getById(id);
    }
    
    @Override
    public Account getByName(String name) {
        return accountDao.getByName(name);
    }
    
    @Override
    public List<Account> listAll() {
        return accountDao.listAll();
    }
}
