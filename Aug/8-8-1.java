package com.bittech.java9;
import java.sql.*;

import com.bittech.java9.util.CommUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

/**
 * @Author: yuisama
 * @Date: 2019-08-08 11:35
 * @Description:
 */
public class JDBCTest {
    private static String url;
    private static String userName;
    private static String password;

    static {
        // 1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Properties pros = CommUtils.loadProperties("db.properties");
        url = pros.getProperty("url");
        userName = pros.getProperty("username");
        password = pros.getProperty("password");
    }

    @Test
    // 测试JDBC的查询操作
    public void queryTest() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();
            String user = "test2' --";
            String ps = "666666";
            String sql = "SELECT * FROM user WHERE username='"+user+" AND password = '"+ps+"'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("登录成功");
            }else {
                System.out.println("用户名或密码不正确，登录失败");
            }
        }catch (SQLException e) {

        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    // 测试JDBC的插入操作
    public void insertTest() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
            String sql = "INSERT INTO user(username, password) VALUES('test3','456')";
            statement =connection.createStatement();
            int rows = statement.executeUpdate(sql);
            Assert.assertEquals(1,rows);
        }catch (SQLException e) {
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void deleteTest() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
            String sql = "DELETE FROM user WHERE id = '5'";
            statement =connection.createStatement();
            int rows = statement.executeUpdate(sql);
            Assert.assertEquals(1,rows);
        }catch (SQLException e) {

        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void updateTest() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
            String sql = "UPDATE user SET password = '123' WHERE id = '2'";
            statement =connection.createStatement();
            int rows = statement.executeUpdate(sql);
            Assert.assertEquals(1,rows);
        }catch (SQLException e) {

        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
