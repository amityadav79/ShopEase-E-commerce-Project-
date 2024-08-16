package com.shopease.DAOImpl;

import com.shopease.dao.UserDAO;
import com.shopease.Entities.User;
import com.shopease.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }

    @Override
    public void deleteUser(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
