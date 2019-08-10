package com.lqh.mapper;

import com.lqh.po.OrderEx;
import com.lqh.po.Orders;
import com.lqh.po.UserEx;

import java.util.List;

public interface OrderMapper {

    public List<OrderEx> queryOrderToUser();

    public List<Orders> queryOrderToItems();
}
