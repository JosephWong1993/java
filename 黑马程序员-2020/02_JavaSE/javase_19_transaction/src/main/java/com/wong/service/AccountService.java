package com.wong.service;

import com.wong.dao.AccountDao;
import com.wong.domain.Account;
import com.wong.utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 转账的业务层
 * 接收用户输入数据（表现层接收，传递过来）
 * 调用dao层，获取余额，更新余额
 */
public class AccountService {
    /**
     * 创建方法，实现转账
     * 参数，付款人，收款人，金额
     */
    public void transfer(String payerName, String payeeName, double money) {
        //调用dao层，先查询账户的余额
        AccountDao accountDao = new AccountDao();
        Connection con = null;
        try {
            //业务层获取数据库连接对象
            con = DruidUtils.getConnection();
            //            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            con.setAutoCommit(false);
            //dao层方法，查询账户，付款人
            Account accountPayer = accountDao.queryAccount(payerName, con);
            //dao层方法，查询账户，收款人
            Account accountPayee = accountDao.queryAccount(payeeName, con);
            
            System.out.println(accountPayer);
            System.out.println(accountPayee);
            
            accountPayer.setMoney(accountPayer.getMoney() - money);
            accountPayee.setMoney(accountPayee.getMoney() + money);
            //调用dao层方法update转账
            accountDao.updateAccount(payerName, accountPayer.getMoney(), con);
            accountDao.updateAccount(payeeName, accountPayee.getMoney(), con);
            //SQK语句执行成功，提交事务
            //DBUtils工具类，提交事务并释放资源
            DbUtils.commitAndCloseQuietly(con);
        } catch (SQLException e) {
            e.printStackTrace();
            //SQL执行失败，回滚
            //DBUtils工具类，回滚事务并释放资源
            DbUtils.rollbackAndCloseQuietly(con);
        } finally {
            //DBUtils工具类，释放资源
            DbUtils.closeQuietly(con);
        }
    }
}
