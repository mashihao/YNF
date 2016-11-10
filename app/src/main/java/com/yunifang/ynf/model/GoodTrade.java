package com.yunifang.ynf.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class GoodTrade extends BmobObject {

    private String owner = ""; // 出售者
    private String item = ""; // 商品名称
    private String type = ""; // 类型
    private String description = ""; // 描述
    private String price = ""; // 价格
    private String phone = ""; // 联系电话
    private BmobFile picTradeItem = null; // 物品主图


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BmobFile getPicTradeItem() {
        return picTradeItem;
    }

    public void setPicTradeItem(BmobFile picTradeItem) {
        this.picTradeItem = picTradeItem;
    }


}
