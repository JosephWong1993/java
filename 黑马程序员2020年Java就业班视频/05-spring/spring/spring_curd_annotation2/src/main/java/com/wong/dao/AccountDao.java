package com.wong.dao;

import com.wong.pojo.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 账户持久层
 */
public interface AccountDao {
    /**
     * 保存
     */
    @Insert("insert into account values (#{id},#{name},#{money})")
    void insert(Account account);
    
    /**
     * 根据id删除
     */
    @Delete("delete from account where id=#{id}")
    void delete(int id);
    
    /**
     * 更新账户
     */
    @Update("update account set name=#{name},money=#{money} where id =#{id}")
    void update(Account account);
    
    /**
     * 根据id查询
     */
    @Select("select * from account where id=#{id}")
    Account getById(int id);
    
    /**
     * 根据名称查询账户
     */
    @Select("select * from account where name=#{name}")
    Account getByName(String name);
    
    /**
     * 查询所有
     */
    @Select("select * from account")
    List<Account> listAll();
}
