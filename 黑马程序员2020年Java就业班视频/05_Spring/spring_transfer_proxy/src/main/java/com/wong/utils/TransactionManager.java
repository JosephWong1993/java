package com.wong.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 管理事务的工具类
 */
@Component
public class TransactionManager {
    @Autowired
    private Connection connection;
    
    /**
     * 开启事务
     */
    public void begin() {
        try {
            //查看当前代码执行所在的线程对象
            /*System.out.println("当前线程：" + Thread.currentThread().getName());*/
            System.out.println("开启事务 connection = " + connection);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 提交事务
     */
    public void commit() {
        try {
            //查看当前代码执行所在的线程对象
            /*System.out.println("当前线程：" + Thread.currentThread().getName());*/
            System.out.println("提交事务 connection = " + connection);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            //查看当前代码执行所在的线程对象
            /*System.out.println("当前线程：" + Thread.currentThread().getName());*/
            System.out.println("回滚事务 connection = " + connection);
            
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 释放连接
     */
    public void close() {
        try {
            //查看当前代码执行所在的线程对象
            /*System.out.println("当前线程：" + Thread.currentThread().getName());*/
            System.out.println("释放连接 connection = " + connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
