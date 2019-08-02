package com.ming.vo;

import java.util.Date;

/**
 * 商品列表
 */
public class Items {

    private int itemsId;

    private String itemsName;

    private String itemsPrice;

    private Date itemsCreatetime;

    public Items(){

    }

    public int getItemsId() {
        return itemsId;
    }

    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getItemsPrice() {
        return itemsPrice;
    }

    public void setItemsPrice(String itemsPrice) {
        this.itemsPrice = itemsPrice;
    }

    public Date getItemsCreatetime() {
        return itemsCreatetime;
    }

    public void setItemsCreatetime(Date itemsCreatetime) {
        this.itemsCreatetime = itemsCreatetime;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemsId=" + itemsId +
                ", itemsName='" + itemsName + '\'' +
                ", itemsPrice='" + itemsPrice + '\'' +
                ", itemsCreatetime=" + itemsCreatetime +
                '}';
    }
}
