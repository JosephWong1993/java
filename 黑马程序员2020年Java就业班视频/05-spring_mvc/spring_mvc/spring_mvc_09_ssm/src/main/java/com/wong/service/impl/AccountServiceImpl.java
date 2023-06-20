package com.wong.service.impl;

import com.wong.dao.AccountDao;
import com.wong.pojo.Account;
import com.wong.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的service接口实现类
 */
@Service
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    @Override
    public void save(Account account) {
        accountDao.save(account);
    }
    
    @Override
    public void deleteById(Integer id) {
        accountDao.deleteById(id);
    }
    
    @Override
    public void update(Account account) {
        accountDao.update(account);
    }
    
    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }
    
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
