package com.lqh.controller;

import com.lqh.po.User;
import com.lqh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//采用注解的方式
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/showUserList")
    public ModelAndView userController() throws Exception{

        List<User> li = userService.querUserService();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userKey",li);
        modelAndView.setViewName("showuser");
        return modelAndView;
    }

//    @RequestMapping("/hello")
//    public void sayHello(){
//        System.out.println("****************");
//    }

}
