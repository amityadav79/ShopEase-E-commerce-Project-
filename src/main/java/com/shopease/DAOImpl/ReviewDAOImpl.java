package com.shopease.DAOImpl;

import com.shopease.Entities.Review;
import com.shopease.dao.ReviewDAO;
import com.shopease.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {

    @Override
    public void saveReview(Review review) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(review);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving review", e);
        }
    }

    @Override
    public Review getReviewById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Review.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving review by ID", e);
        }
    }

    @Override
    public List<Review> getReviewsByProductId(Long productId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Review WHERE product.id = :productId", Review.class)
                          .setParameter("productId", productId)
                          .list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving reviews by product ID", e);
        }
    }

    @Override
    public List<Review> getReviewsByUserId(Long userId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Review WHERE user.id = :userId", Review.class)
                          .setParameter("userId", userId)
                          .list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving reviews by user ID", e);
        }
    }
    
    @Override
    public List<Review> getAllReviews() {  // Missing method implemented
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Review", Review.class).list();
        }
    }


    @Override
    public void deleteReview(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Review review = session.get(Review.class, id);
            if (review != null) {
                session.delete(review);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting review", e);
        }
    }
}
