package com.shopease.DAOImpl;

import com.shopease.Entities.OrderItem;
import com.shopease.dao.OrderItemDAO;
import com.shopease.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderItemDAOImpl implements OrderItemDAO {

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(orderItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving order item", e);
        }
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(orderItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating order item", e);
        }
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(OrderItem.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving order item by ID", e);
        }
    }

    @Override
    public List<OrderItem> getOrderItemsByUserId(Long userId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM OrderItem WHERE user.id = :userId", OrderItem.class)
                          .setParameter("userId", userId)
                          .list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving order items by user ID", e);
        }
    }
    
    @Override
    public List<OrderItem> getAllOrderItems() {  // Missing method implemented
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM OrderItem", OrderItem.class).list();
        }
    }

    @Override
    public void deleteOrderItem(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            OrderItem orderItem = session.get(OrderItem.class, id);
            if (orderItem != null) {
                session.delete(orderItem);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting order item", e);
        }
    }
}
