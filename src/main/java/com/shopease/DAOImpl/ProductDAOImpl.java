package com.shopease.DAOImpl;

import com.shopease.Entities.Product;
import com.shopease.dao.ProductDAO;
import com.shopease.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving product", e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating product", e);
        }
    }

    @Override
    public Product getProductById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving product by ID", e);
        }
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product WHERE category.id = :categoryId", Product.class)
                          .setParameter("categoryId", categoryId)
                          .list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving products by category ID", e);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product", Product.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all products", e);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting product", e);
        }
    }
}
