package com.rmi.demo;

import java.util.List;
import java.util.ArrayList;

public class OrderServiceImpl implements OrderService {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void placeOrder(Order order) {
        System.out.print("We have received an order to create " + order.toString());
        orders.add(order);
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

}

