package com.wong.service.impl;

import com.wong.dao.AccountDao;
import com.wong.dao.impl.AccountDaoImpl;
import com.wong.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 业务接口实现类
 */
//@Component
@Service
public class AccountServiceImpl implements AccountService {
    //当前的代码耦合性强
    private AccountDao accountDao = new AccountDaoImpl();
    
    @Override
    public void save() {
        //调用dao层的保存账户的方法
        accountDao.saveAccount();
    }
}
