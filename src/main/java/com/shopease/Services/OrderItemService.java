package com.shopease.Services;

import com.shopease.Entities.OrderItem;
import java.util.List;

public interface OrderItemService {
    void saveOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(Long id);
    List<OrderItem> getAllOrderItems();
    void deleteOrderItem(Long id);
}
