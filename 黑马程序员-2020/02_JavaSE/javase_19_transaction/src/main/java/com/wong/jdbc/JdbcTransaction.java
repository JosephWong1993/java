package com.wong.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC实现转账，保证数据安全
 * 使用事务技术
 * 需求：tom -1000 ，jerry +1000
 * <p>
 * Connection连接对象方法：
 * void setAutoCommit(false)设置事务的提交方式，传false阻止自动提交
 * commit()提交事务
 * rollback()回滚
 */
public class JdbcTransaction {
    public static void main(String[] args) {
        Connection con = null;
        try {
            //读取配置文件，返回输入流
            InputStream in = JdbcTransaction.class.getClassLoader().getResourceAsStream("db.properties");
            //创建集合键值对
            Properties properties = new Properties();
            //集合IO关联使用
            properties.load(in);
            //取出集合中的键值对
            String driverClass = properties.getProperty("driverClass");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            
            //注册驱动
            Class.forName(driverClass);
            //获取连接对象
            con = DriverManager.getConnection(url, user, password);
            //阻止事务自动提交，开启事务
            con.setAutoCommit(false);
            //获取SQL语句执行对象
            Statement stat = con.createStatement();
            //拼写tom-1000的SQL语句
            String sqlOut = "UPDATE account set money=money-1000 where name='tom'";
            //执行SQL
            stat.executeUpdate(sqlOut);
            int a = 1 / 0;
            //拼写jerry+1000的SQL语句
            String sqlIn = "UPDATE account set money=money+1000 where name='jerry'";
            //执行SQL
            stat.executeUpdate(sqlIn);
            //提交事务
            con.commit();
        } catch (Exception e) {
            //程序执行catch，出现一次，SQL语句执行失败，回滚
            e.printStackTrace();
            try {
                //回滚
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        } finally {
            //释放资源
            try {
                if (null != con) {
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
