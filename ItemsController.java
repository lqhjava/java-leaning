package com.lqh.controller;


import com.lqh.po.Items;
import com.lqh.po.ItemsCustom;
import com.lqh.po.ItemsVO;
import com.lqh.services.ItemsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 控制层
 */
@Controller
public class ItemsController {

    @Autowired
    private ItemsServices itemsServices;

    //商品列表查询 全查
    @RequestMapping(value = "/queryitemsbyname")
    public ModelAndView queryItemsList(HttpServletResponse response,
                                       ItemsVO itemsVO) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        //查询
        List<ItemsCustom> li = itemsServices.queryItemsByAll(itemsVO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsListKey",li);
        modelAndView.setViewName("itemsList");

        return modelAndView;
    }

    @RequestMapping(value = "/queryItemsList2")
    public void queryItensList2(HttpServletRequest request,
                                HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        /**
         * think about it how do you to do it?
         */
        List<ItemsCustom> itemsCustomList =  itemsServices.queryItemsByAll(null);
        request.setAttribute("itemsListKey",itemsCustomList);
        request.getRequestDispatcher("/jsp/itemsList.jsp").forward(request,response);
        //response.sendRedirect();
    }


    //商品修改信息展示
    @RequestMapping(value = "/modifyInfoShow")
    public String modifyInfoShow(Model model, HttpServletRequest request,
                                 HttpServletResponse response) throws  Exception{
        response.setContentType("text/html;charset=UTF-8");

        Items items;
        String linkId = request.getParameter("id");

        if(linkId == null){
            String strId = request.getParameter("selItem");
            int checkBoxId = Integer.parseInt(strId);
            items = itemsServices.queryItemsById(checkBoxId);
        }else{
            int linkId_int = Integer.parseInt(linkId);
            items = itemsServices.queryItemsById(linkId_int);
        }
        model.addAttribute("itemsKey", items);
        return "edit";
    }

    /**
     * 真正的去修改
     * @return
     */
    @RequestMapping(value = "/editSubmit")
    public String modifyInfoSubmit(Integer id,Items items,HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        String myId = request.getParameter("id");
        System.out.println("myId = " + myId);
        itemsServices.montifyId(id,items);
        return "redirect:queryitemsbyname.action";
        //return "forward:queryitemsbyname.action";


    }

    //添加查询: 去添加页面
    @RequestMapping(value = "/addItems")
    public String addItesmController(){
        // how do I to do it?
        return "redirect:/jsp/addItems.jsp";
    }

    //添加查询: 添加
    //参数绑定
    @RequestMapping(value = "/addItemsOperator")
    public void addItesmController1(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception{

        response.setContentType("text/html;charset=UTF-8");

        String myFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat);
        String strDate = request.getParameter("itemsTime");
        Date myDate = simpleDateFormat.parse(strDate);
        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName(request.getParameter("itemsName"));
        itemsCustom.setPrice(Float.valueOf(request.getParameter("itemsPrice")));
        itemsCustom.setCreatetime(myDate);
        itemsCustom.setDetail(request.getParameter("itemsInfo"));


        itemsServices.addItems(itemsCustom);
        request.getRequestDispatcher("/queryitemsbyname.action").forward(request,response);
    }

    //删除一组ID值
    @RequestMapping(value = "/deleteIds")
    public void deleteItemsByIds(HttpServletRequest request,
                                 HttpServletResponse response)throws Exception{
        //call by service
        String [] ids = request.getParameterValues("selItem");
        Integer [] idss = new Integer[ids.length];
        for (int i = 0 ; i < ids.length; i++) {
            idss[i] = Integer.valueOf(ids[i]);
        }
        itemsServices.delItemById(idss);
        request.getRequestDispatcher("/queryitemsbyname.action").forward(request,response);
    }

    //deletebyId
    @RequestMapping(value = "/deleteByid")
    public String deleteItemsById(@RequestParam(value = "id") Integer myid)throws Exception{
        itemsServices.delItemById(myid);
        return "redirect:queryitemsbyname.action";
    }

    //批量跟新展示页面
    @RequestMapping(value = "/updateShow")
    public String updateInfoShow(Model model, HttpServletRequest request,
                                 HttpServletResponse response)throws Exception{

        response.setContentType("text/html;charset=UTF-8");
        String [] ids = request.getParameterValues("selItem");
        Integer [] idss = new Integer[ids.length];
        for (int i = 0 ; i < ids.length; i++) {
            idss[i] = Integer.valueOf(ids[i]);
        }

        List<ItemsCustom> items = itemsServices.queryItemsByIds(idss);

        model.addAttribute("itemsListKey", items);
        return "update";
    }

    //批量跟新
    @RequestMapping(value = "/updateItems")
    public String updateItems(ItemsVO itemsVO)throws Exception{
        itemsServices.updateItems(itemsVO);
        System.out.println(itemsVO.toString());
        return "redirect:queryitemsbyname.action";
        //request.getRequestDispatcher("/queryitemsbyname.action").forward(request,response);
    }
}
