package com.wong.test;

import com.wong.utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDruid {
    public static void main(String[] args) throws SQLException {
        Connection connection = DruidUtils.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
