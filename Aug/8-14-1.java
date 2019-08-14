package com.lqh.service;

import com.lqh.mapper.UserMapper;
import com.lqh.po.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    //与mapper层关联  有spring管理  applicationContext-service.xml
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> querUserService() throws Exception {
        return userMapper.querUser();
    }

    @Override
    public int deletUserById(User user) throws Exception {
        return userMapper.deletUserById(user);
    }
}
