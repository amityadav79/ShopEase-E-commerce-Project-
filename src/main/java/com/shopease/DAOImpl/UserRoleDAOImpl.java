package com.shopease.DAOImpl;

import com.shopease.dao.UserRoleDAO;
import com.shopease.Entities.UserRole;
import com.shopease.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserRoleDAOImpl implements UserRoleDAO {

    @Override
    public void saveUserRole(UserRole userRole) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(userRole);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public UserRole getUserRoleById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(UserRole.class, id);
        }
    }

    @Override
    public UserRole getUserRoleByName(String roleName) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM UserRole UR WHERE UR.roleName = :roleName", UserRole.class)
                          .setParameter("roleName", roleName)
                          .uniqueResult();
        }
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM UserRole", UserRole.class).list();
        }
    }

    @Override
    public void deleteUserRole(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            UserRole userRole = session.get(UserRole.class, id);
            if (userRole != null) {
                session.delete(userRole);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
