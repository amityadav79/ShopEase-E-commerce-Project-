package com.shopease.DAOImpl;

import com.shopease.Entities.CartItem;
import com.shopease.dao.CartItemDAO;
import com.shopease.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CartItemDAOImpl implements CartItemDAO {

    @Override
    public void saveCartItem(CartItem cartItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cartItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving cart item", e);
        }
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(cartItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating cart item", e);
        }
    }

    @Override
    public CartItem getCartItemById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(CartItem.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving cart item by ID", e);
        }
    }

    @Override
    public List<CartItem> getCartItemsByUserId(Long userId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM CartItem WHERE user.id = :userId", CartItem.class)
                          .setParameter("userId", userId)
                          .list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving cart items by user ID", e);
        }
    }
    
    @Override
    public List<CartItem> getAllCartItems() {  // Missing method implemented
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM CartItem", CartItem.class).list();
        }
    }


    @Override
    public void deleteCartItem(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CartItem cartItem = session.get(CartItem.class, id);
            if (cartItem != null) {
                session.delete(cartItem);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting cart item", e);
        }
    }
}
