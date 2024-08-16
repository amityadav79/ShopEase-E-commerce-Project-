package com.shopease.DAOImpl;

import com.shopease.Entities.Category;
import com.shopease.dao.CategoryDAO;
import com.shopease.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public void saveCategory(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving category", e);
        }
    }

    @Override
    public void updateCategory(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating category", e);
        }
    }

    @Override
    public Category getCategoryById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Category.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving category by ID", e);
        }
    }

    @Override
    public Category getCategoryByName(String name) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Category WHERE name = :name", Category.class)
                          .setParameter("name", name)
                          .uniqueResult();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving category by name", e);
        }
    }

    @Override
    public List<Category> getAllCategories() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Category", Category.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all categories", e);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Category category = session.get(Category.class, id);
            if (category != null) {
                session.delete(category);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting category", e);
        }
    }
}
