package com.rmi.demo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String item;
    private int quantity;
    private Date date = new Date();

    public  Order(String item, int quantity){
        this.item = item;
        this.quantity = quantity;

    }

    public Order(){

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "item='" + item + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}

