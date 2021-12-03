package com.wong.service.impl;

import com.wong.dao.AccountDao;
import com.wong.dao.impl.AccountDaoImpl;
import com.wong.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 业务接口实现类
 */
//@Component
@Service
public class AccountServiceImpl implements AccountService {
    //当前的代码耦合性强
    private AccountDao accountDao;
    
    //依赖注入（通过类型自动注入）
    @Autowired
    //当接口实现类不止一个时，无法通过类型自动注入；需要使用@Autowired + @Qualifier来实现注入
    @Qualifier("accountDaoImpl")
    // jdk提供的注入方式
    //    @Resource(name = "accountDaoImpl")
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    @Override
    public void save() {
        //调用dao层的保存账户的方法
        accountDao.saveAccount();
    }
}
