package com.wong.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 实现 JDBC的工具类
 * 获取数据库连接对象
 * 数据库连接四大信息：
 * url地址，驱动类名字，用户名和密码
 * 卸载配置文件中
 * <p>
 * 读取配置文件中的连接信息！！
 */
public class JdbcUtils {
    //定义4个静态成员变量
    private static String driverClass;
    
    private static String url;
    
    private static String user;
    
    private static String password;
    
    //static代码块：读取配置文件，注册驱动
    static {
        try {
            //读取配置文件，返回输入流
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            //创建集合键值对
            Properties properties = new Properties();
            //集合IO关联使用
            properties.load(in);
            //取出集合中的键值对
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            
            Class.forName(driverClass);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 定义方法，调用者调用方法，获取连接
     */
    public static Connection  getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
    
    /**
     * 定义方法，实现资源释放
     * Connection,Statement,ResultSet
     * 加参数：传递哪个关闭哪个
     */
    public static void close(ResultSet rs, Statement stat, Connection con) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        if (stat != null)
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        
        if (con != null)
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }
}
