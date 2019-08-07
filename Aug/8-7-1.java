package com.lqh.dao;

import com.lqh.po.User;
import com.lqh.tools.DbManger;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //查询数据库

    public List<User> queryUserDao(){
        List<User> list = null;
        try{
            //准备查询语句
            String str = "select * from user";
            ResultSet re = new DbManger().executeQueryForUser(str);
            list = new ArrayList<User>();
            while (re.next()){
                User user = new User();
                user.setUserId(re.getInt("userId"));
                user.setUserName(re.getString("userNmae"));
                user.setUserAddr(re.getString("userAddr"));
                list.add(user);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
