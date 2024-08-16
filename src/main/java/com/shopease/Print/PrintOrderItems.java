package com.shopease.Print;

import com.shopease.Entities.OrderItem;

import java.util.List;

public class PrintOrderItems {

    public void print(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            System.out.println("Order ID: " + orderItem.getId());
            System.out.println("Product: " + orderItem.getProduct().getName());
            System.out.println("User: " + orderItem.getUser().getUsername());
            System.out.println("Quantity: " + orderItem.getQuantity());
            System.out.println("----------------------");
        }
    }
}
