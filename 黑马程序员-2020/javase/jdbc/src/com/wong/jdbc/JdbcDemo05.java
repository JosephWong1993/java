package com.wong.jdbc;

import com.wong.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDemo05 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //调用静态方法，获取连接
        Connection con = JdbcUtils.getConnection();
        System.out.println(con);
        
        JdbcUtils.close(null, null, con);
    }
}
