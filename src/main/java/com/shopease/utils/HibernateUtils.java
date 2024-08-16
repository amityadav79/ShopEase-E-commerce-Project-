package com.shopease.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.shopease.Entities.*;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();

            config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/shopease");
            config.setProperty("hibernate.connection.username", "root");
            config.setProperty("hibernate.connection.password", "12345");
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            config.setProperty("hibernate.show_sql", "true");
            config.setProperty("hibernate.format_sql", "true");
            config.setProperty("hibernate.hbm2ddl.auto", "update");

            config.addAnnotatedClass(User.class);
            config.addAnnotatedClass(UserRole.class);
            config.addAnnotatedClass(Product.class);
            config.addAnnotatedClass(CartItem.class);
            config.addAnnotatedClass(OrderItem.class);
            config.addAnnotatedClass(Payment.class);
            config.addAnnotatedClass(Category.class);
            config.addAnnotatedClass(Review.class);
            config.addAnnotatedClass(Feedback.class);
            

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build();

            sessionFactory = config.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
