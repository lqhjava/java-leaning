package com.bittech.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * DB
 */
public class DbManager {

    public String username = "root";
    public String password = "root";
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3306/ming";

    public Connection conn = null;
    public Statement state = null;
    public ResultSet resultSet = null;

    public DbManager(){

    }

    //acquire db connection
    public Connection getConnection(){
        try {
            Class.forName(driver);
            System.out.println("it is success that load driver from db");
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("connection success....");
            return conn;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }

    // query all of form user will be executed when you call this method
    public ResultSet executeQueryForUser(String strSql){
        try{
            conn = this.getConnection();
            state = conn.createStatement();
            resultSet = state.executeQuery(strSql);
            return resultSet;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  resultSet;
    }

    //close connection
    public void closeConnection(){
        try {
            if(resultSet != null) resultSet.close();
            if(state != null) state.close();
            if(conn != null) conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
