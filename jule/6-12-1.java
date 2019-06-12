package com.lqh.main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Respance extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应头： refresh
        //response.setHeader("refresh","2");//间隔两秒刷新
        //response.setHeader("refresh","3;/adv.html") 间隔3秒后调转到adv.html
        

    }
}
