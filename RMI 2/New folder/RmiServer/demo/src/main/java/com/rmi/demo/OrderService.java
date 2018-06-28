package com.rmi.demo;

import java.util.List;


public interface OrderService {
    void placeOrder(Order order);

    List<Order> getOrders();
}
