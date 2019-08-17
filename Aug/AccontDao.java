package com.lqh.client.dao;

import com.lqh.client.po.User;
import org.apache.commons.codec.digest.DigestUtils;


import java.sql.*;

public class AccontDao extends BasedDao{

    //注册 传入User
    public boolean userReg(User user){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //连接数据源
            connection = getConnection();
            //准备SQL语句
            String sqlStr ="INSERT INTO user(username, password, brief) "+
                    "VALUES (?,?,?)";
            //写入
            preparedStatement = connection.prepareStatement(sqlStr,
                    Statement.RETURN_GENERATED_KEYS);
            //给sql语句中的？赋值
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,DigestUtils.md5Hex(user.getPassword()));
            preparedStatement.setString(3,user.getBrief());
            //确定是否插入
            int flag = preparedStatement.executeUpdate();
            if(flag == 1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("用户注册失败");
            e.printStackTrace();
        }finally {
            //关闭资源
            closeConnection(connection,preparedStatement);
        }
        return false;
    }

    //登陆 传入用户名和密码  登陆成功返回User信息
    public User lobin(String userName,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //返回user
        ResultSet resultSet = null;
        try{
            //获取连接
            connection = getConnection();
            //准备sql
            String sqlStr = "SELECT * FROM user WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            //查询结果
            resultSet = preparedStatement.executeQuery();
            //如果查到了返回User信息
            if(resultSet.next()){
                User user =new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setBrief(resultSet.getString("brief"));
                return user;
            }

        }catch (SQLException e){
            System.out.println("用户登陆出错");
            e.printStackTrace();
        }finally {
            closeConnection(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
