package com.ming;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.imageio.spi.IIOServiceProvider;

public class Client {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserManager iusermanager = (IUserManager) context.getBean("userManagerImpl");
        iusermanager.addUserInfo("arvin","123");
        iusermanager.delUserInfo(1);
        //**********************
        iusermanager.queryUserbyId(1);
        iusermanager.modifyUserInfo("jerry","111",1);


    }
}
