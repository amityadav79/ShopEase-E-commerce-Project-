package com.shopease.ServicesImpl;

import com.shopease.dao.OrderItemDAO;
import com.shopease.Entities.OrderItem;
import com.shopease.Services.OrderItemService;
import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemDAO orderItemDAO;

    public OrderItemServiceImpl() {
        this.orderItemDAO = orderItemDAO;
    }

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemDAO.saveOrderItem(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemDAO.getOrderItemById(id);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemDAO.getAllOrderItems();
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemDAO.deleteOrderItem(id);
    }
}
