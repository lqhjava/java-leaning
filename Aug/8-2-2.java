package com.ming.controller;


import com.ming.vo.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 处理器 Handler (控制器)--->适配器(适配一定的规则)
 */

public class ShowItemsController implements Controller {


    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        List<Items> itemsList = new ArrayList<Items>();

        Items items1  = new Items();
        items1.setItemsId(1);
        items1.setItemsName("thinkpad T590");
        items1.setItemsPrice("12000");
        items1.setItemsCreatetime(new Date());

        Items items2  = new Items();
        items2.setItemsId(2);
        items2.setItemsName("thinkpad x390");
        items2.setItemsPrice("13800");
        items2.setItemsCreatetime(new Date());

        Items items3  = new Items();
        items3.setItemsId(3);
        items3.setItemsName("Mac pro");
        items3.setItemsPrice("230000");
        items3.setItemsCreatetime(new Date());

        itemsList.add(items1);
        itemsList.add(items2);
        itemsList.add(items3);

        ModelAndView modelAndView = new ModelAndView();
        //request.setAttribute(key,value);
        modelAndView.addObject("itemsListKey",itemsList);
        //request.getRequestDispatcher("showItemsList.jsp").forward(request,response);
        modelAndView.setViewName("showItemsList");
        return modelAndView;
    }
}
