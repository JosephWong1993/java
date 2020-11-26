package com.wong.service;

import com.wong.pojo.Account;

import java.util.List;

public interface AccountService {
    /**
     * 转载
     *
     * @param resource 汇款人
     * @param target   收款人
     * @param money    转账金额
     */
    void transfer(String resource, String target, double money);
    
    /**
     * 保存
     */
    void insert(Account account);
    
    /**
     * 根据id删除
     */
    void delete(int id);
    
    /**
     * 更新账户
     */
    void update(Account account);
    
    /**
     * 根据id查询
     */
    Account getById(int id);
    
    /**
     * 根据名称查询账户
     */
    Account getByName(String name);
    
    /**
     * 查询所有
     */
    List<Account> listAll();
}
