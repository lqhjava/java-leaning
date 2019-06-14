package com.bite.test.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 显示登录次数
 */
public class ShowServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取ServletContext
        ServletContext servletContext =
                this.getServletContext();
        //获取cishu
        Integer cishu = (Integer) servletContext.getAttribute("count");
        response.getWriter().write("当前用户登录的总次数是:"+cishu);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
