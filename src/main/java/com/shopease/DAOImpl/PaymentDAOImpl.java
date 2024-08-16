package com.shopease.DAOImpl;

import com.shopease.Entities.Payment;
import com.shopease.dao.PaymentDAO;
import com.shopease.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public void savePayment(Payment payment) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving payment", e);
        }
    }

    @Override
    public Payment getPaymentById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Payment.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving payment by ID", e);
        }
    }

    @Override
    public List<Payment> getPaymentsByUserId(Long userId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Payment WHERE user.id = :userId", Payment.class)
                          .setParameter("userId", userId)
                          .list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving payments by user ID", e);
        }
    }

    @Override
    public List<Payment> getPaymentsByOrderId(Long orderId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Payment WHERE orderItem.id = :orderId", Payment.class)
                          .setParameter("orderId", orderId)
                          .list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving payments by order ID", e);
        }
    }

    @Override
    public void deletePayment(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Payment payment = session.get(Payment.class, id);
            if (payment != null) {
                session.delete(payment);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting payment", e);
        }
    }
    
    @Override
    public List<Payment> getAllPayments() {  // Missing method implemented
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Payment", Payment.class).list();
        }
}

}