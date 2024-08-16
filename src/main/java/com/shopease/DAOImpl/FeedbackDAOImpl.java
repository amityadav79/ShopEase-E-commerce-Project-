package com.shopease.DAOImpl;

import com.shopease.Entities.Feedback;
import com.shopease.Entities.OrderItem;
import com.shopease.dao.FeedbackDAO;
import com.shopease.utils.HibernateUtils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FeedbackDAOImpl implements FeedbackDAO {

    @Override
    public void saveFeedback(Feedback feedback) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(feedback);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving feedback", e);
        }
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Feedback.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving feedback by ID", e);
        }
    }

    @Override
    public List<Feedback> getFeedbacksByUserId(Long userId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Feedback WHERE user.id = :userId", Feedback.class)
                          .setParameter("userId", userId)
                          .list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving feedbacks by user ID", e);
        }
    }

    @Override
    public List<Feedback> getAllFeedbacks() {  // Missing method implemented
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Feedback", Feedback.class).list();
        }
    }
    
    @Override
    public List<Feedback> getFeedbacksByOrderItem(OrderItem orderItem) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<Feedback> query = session.createQuery("FROM Feedback WHERE orderItem = :orderItem", Feedback.class);
            query.setParameter("orderItem", orderItem);
            return query.getResultList();
        }
    }
    
    @Override
    public void deleteFeedback(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Feedback feedback = session.get(Feedback.class, id);
            if (feedback != null) {
                session.delete(feedback);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting feedback", e);
        }
    }
}
