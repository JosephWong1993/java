package com.wong.service.impl;

import com.wong.dao.AccountDao;
import com.wong.pojo.Account;
import com.wong.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 账户业务实现类
 */
@Service
//开启Spring的事务控制
@Transactional
public class AccountServiceImpl implements AccountService {

    //依赖注入
    private AccountDao accountDao;

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
        //int i = 1 / 0;
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

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
