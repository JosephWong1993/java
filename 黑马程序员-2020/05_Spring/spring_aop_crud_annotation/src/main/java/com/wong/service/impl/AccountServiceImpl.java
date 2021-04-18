package com.wong.service.impl;

import com.wong.dao.AccountDao;
import com.wong.pojo.Account;
import com.wong.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户业务实现类
 */
@Service
public class AccountServiceImpl implements AccountService {

    //依赖注入
    private AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public void transfer(String source, String target, double money) {
        //1.根据name获取账户对象
        //汇款人
        Account sourceAccount = accountDao.findByName(source);
        //收款人
        Account targetAccount = accountDao.findByName(target);
        //2.更新汇款人和收款人账户对象金额
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        //3.数据库持久化更新
        accountDao.update(sourceAccount);
        int i = 1 / 0;
        accountDao.update(targetAccount);
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
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
    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
