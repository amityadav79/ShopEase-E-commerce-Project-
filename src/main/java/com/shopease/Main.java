package com.shopease;

import com.shopease.Menu.AdminMenu;
import com.shopease.Menu.CustomerMenu;
import com.shopease.Menu.MainMenu;
import com.shopease.Services.*;
import com.shopease.ServicesImpl.*;

import com.shopease.utils.HibernateUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialize services
        ProductService productService = new ProductServiceImpl();
        UserService userService = new UserServiceImpl();
        UserRoleService userRoleService = new UserRoleServiceImpl();
        CartItemService cartItemService = new CartItemServiceImpl();
        OrderItemService orderItemService = new OrderItemServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();
        ReviewService reviewService = new ReviewServiceImpl();
        FeedbackService feedbackService = new FeedbackServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();

        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main menu instance
        MainMenu mainMenu = new MainMenu(scanner, userService, userRoleService);

        boolean exit = false;
        while (!exit) {
            mainMenu.displayMenu();
            int choice = mainMenu.getMenuChoice();

            switch (choice) {
                case 1: // Admin login
                    AdminMenu adminMenu = new AdminMenu(scanner, productService, userService, userRoleService, categoryService, cartItemService, orderItemService, paymentService, reviewService, feedbackService);
                    adminMenu.displayAdminMenu();
                    break;
                case 2: // Customer login
                    CustomerMenu customerMenu = new CustomerMenu(scanner, productService, userService, cartItemService, orderItemService, paymentService, reviewService, feedbackService);
                    customerMenu.displayCustomerMenu();
                    break;
                case 3: // Exit
                    System.out.println("Exiting the application. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // Close resources and shutdown Hibernate
        scanner.close();
        HibernateUtils.shutdown();
    }
}
