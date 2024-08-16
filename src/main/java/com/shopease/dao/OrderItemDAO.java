package com.shopease.dao;

import com.shopease.Entities.OrderItem;
import java.util.List;

public interface OrderItemDAO {
    void saveOrderItem(OrderItem orderItem);
    void updateOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(Long id);
    List<OrderItem> getOrderItemsByUserId(Long userId);
    List<OrderItem> getAllOrderItems();  // Missing method added
    void deleteOrderItem(Long id);
}
