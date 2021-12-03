package com.wong.dao;

import com.wong.pojo.Account;

import java.util.List;

/**
 * 账户的业务层方法
 *
 * @author jiahuiw
 */
public interface AccountDao {
    /**
     * 保存
     */
    void save(Account account);

    /**
     * 根据id删除
     */
    void delete(Integer id);

    /**
     * 更新账户
     */
    void update(Account account);

    /**
     * 根据id查询
     */
    Account findById(Integer id);

    /**
     * 根据名称查询账户
     */
    Account findByName(String name);

    /**
     * 查询所有
     */
    List<Account> findAll();
}
