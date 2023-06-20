package com.wong.dao;

import com.wong.pojo.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Insert("INSERT INTO account (name,money) values(#{name},#{money})")
    void save(Account account);

    /**
     * 根据id删除
     */
    @Delete("DELETE FROM account WHERE id=#{id}")
    void delete(Integer id);

    /**
     * 更新账户
     */
    @Update("UPDATE account SET name=#{name},money=#{money} WHERE id=#{id}")
    void update(Account account);

    /**
     * 根据id查询
     */
    @Select("SELECT * FROM account WHERE id=#{id}")
    Account findById(Integer id);

    /**
     * 根据名称查询账户
     */
    @Select("SELECT * FROM account WHERE name=#{name}")
    Account findByName(String name);

    /**
     * 查询所有
     */
    @Select("SELECT * FROM account")
    List<Account> findAll();
}
