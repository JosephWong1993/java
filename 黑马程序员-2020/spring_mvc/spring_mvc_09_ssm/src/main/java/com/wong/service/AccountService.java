package com.wong.service;

import com.wong.pojo.Account;

import java.util.List;

public interface AccountService {
    /**
     * 增
     *
     * @param account
     */
    void save(Account account);
    
    /**
     * 删
     *
     * @param id
     */
    void deleteById(Integer id);
    
    /**
     * 改
     *
     * @param account
     */
    void update(Account account);
    
    /**
     * 查（根据id查询账户）
     *
     * @param id
     * @return
     */
    Account findById(Integer id);
    
    /**
     * 查（查询所有账户）
     *
     * @return
     */
    List<Account> findAll();
}
