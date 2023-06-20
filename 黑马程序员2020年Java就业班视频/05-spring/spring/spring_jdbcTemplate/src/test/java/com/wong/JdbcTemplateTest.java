package com.wong;

import com.wong.config.SpringConfig;
import com.wong.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringJUnitConfig(classes = SpringConfig.class)
public class JdbcTemplateTest {
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired(required = false)
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    /**
     * 增
     */
    @Test
    public void save() {
        Account account = new Account();
        account.setName("校花");
        account.setMoney(6666d);
        String sql = "insert into account values(?,?,?)";
        Object[] params = { account.getId(), account.getName(), account.getMoney() };
        jdbcTemplate.update(sql, params);
    }
    
    /**
     * 删
     */
    @Test
    public void deleteById() {
        String sql = "delete from account where id=?";
        jdbcTemplate.update(sql, 8);
    }
    
    /**
     * 改
     */
    @Test
    public void update() {
        Account account = new Account();
        account.setId(9);
        account.setName("校花");
        account.setMoney(66d);
        String sql = "UPDATE account set name=?,money=? WHERE id=?";
        Object[] params = { account.getName(), account.getMoney(), account.getId() };
        jdbcTemplate.update(sql, params);
    }
    
    /**
     * 根据id查询
     */
    @Test
    public void findById() {
        String sql = "SELECT * FROM account WHERE id=?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), 9);
        System.out.println("account = " + account);
    }
    
    //查询所有记录的条数
    @Test
    public void findTotalCount() {
        String sql = "SELECT COUNT(1) FROM account";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("count = " + count);
    }
    
    //查询所有
    @Test
    public void findAll() {
        String sql = "SELECT * FROM account";
        List<Account> accountList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
    
    //查询所有(sql语句的字段与 pojo中的属性名不一致的情况 如何赋值)
    @Test
    public void findAll2() {
        String sql = "SELECT id AS ids,name AS names,money AS moneys FROM account";
        List<Account> accountList = jdbcTemplate.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int index) throws SQLException {
                Account account = new Account();
                //为当前的account对象赋值
                account.setId(resultSet.getInt("ids"));
                account.setName(resultSet.getString("names"));
                account.setMoney(resultSet.getDouble("moneys"));
                return account;
            }
        });
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}
