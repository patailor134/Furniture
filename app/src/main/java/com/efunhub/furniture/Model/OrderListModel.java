package com.efunhub.furniture.Model;

/**
 * Created by PATailor on 13-02-2018.
 */

public class OrderListModel
{
    String orderImages, orderName, orderPrice, orderStrikePrice, orderDate;

    public OrderListModel() {
    }

    public String getOrderImages() {
        return orderImages;
    }

    public void setOrderImages(String orderImages) {
        this.orderImages = orderImages;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStrikePrice() {
        return orderStrikePrice;
    }

    public void setOrderStrikePrice(String orderStrikePrice) {
        this.orderStrikePrice = orderStrikePrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
