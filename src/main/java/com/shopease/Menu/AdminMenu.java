package com.shopease.Menu;

import com.shopease.Entities.*;
import com.shopease.Inputs.*;
import com.shopease.Print.*;
import com.shopease.Services.*;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;
    private final OrderItemService orderItemService;
    private final PaymentService paymentService;
    private final ReviewService reviewService;
    private final FeedbackService feedbackService;

    private final Scanner scanner = new Scanner(System.in);

    public AdminMenu(CategoryService categoryService, ProductService productService, UserService userService,
                     OrderItemService orderItemService, PaymentService paymentService, ReviewService reviewService,
                     FeedbackService feedbackService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.orderItemService = orderItemService;
        this.paymentService = paymentService;
        this.reviewService = reviewService;
        this.feedbackService = feedbackService;
    }

    public void showMenu() {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Manage Categories");
            System.out.println("2. Manage Products");
            System.out.println("3. Manage Users");
            System.out.println("4. Manage Orders");
            System.out.println("5. Manage Payments");
            System.out.println("6. View Reviews");
            System.out.println("7. Manage Feedbacks");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manageCategories();
                    break;
                case 2:
                    manageProducts();
                    break;
                case 3:
                    manageUsers();
                    break;
                case 4:
                    manageUsers();
                    break;
                case 5:
                    managePayments();
                    break;
                case 6:
                    viewReviews();
                    break;
                case 7:
                    manageFeedbacks();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void manageCategories() {
        CategoryInput categoryInput = new CategoryInput();

        while (true) {
            System.out.println("Manage Categories:");
            System.out.println("1. Add Category");
            System.out.println("2. View All Categories");
            System.out.println("3. Delete Category");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Category newCategory = categoryInput.getCategoryInput();
                    categoryService.saveCategory(newCategory);
                    System.out.println("Category added successfully.");
                    break;
                case 2:
                    List<Category> categories = categoryService.getAllCategories();
                    new PrintCategories().print(categories);
                    break;
                case 3:
                    System.out.print("Enter Category ID to delete: ");
                    Long categoryId = scanner.nextLong();
                    categoryService.deleteCategory(categoryId);
                    System.out.println("Category deleted successfully.");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void manageProducts() {
        ProductInput productInput = new ProductInput();

        while (true) {
            System.out.println("Manage Products:");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Delete Product");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Product newProduct = productInput.getProductInput(categoryService);
                    productService.saveProduct(newProduct);
                    System.out.println("Product added successfully.");
                    break;
                case 2:
                    List<Product> products = productService.getAllProducts();
                    new PrintProducts().print(products);
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    Long productId = scanner.nextLong();
                    productService.deleteProduct(productId);
                    System.out.println("Product deleted successfully.");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void manageUsers() {
        UserInput userInput = new UserInput();

        while (true) {
            System.out.println("Manage Users:");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Delete User");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    User newUser = userInput.getUserInput();
                    userService.saveUser(newUser);
                    System.out.println("User added successfully.");
                    break;
                case 2:
                    List<User> users = userService.getAllUsers();
                    new PrintUsers().print(users);
                    break;
                case 3:
                    System.out.print("Enter User ID to delete: ");
                    Long userId = scanner.nextLong();
                    userService.deleteUser(userId);
                    System.out.println("User deleted successfully.");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void manageOrders(CartItemService cartItemService) {
        OrderItemInput orderItemInput = new OrderItemInput(cartItemService);

        while (true) {
            System.out.println("Manage Orders:");
            System.out.println("1. View All Orders");
            System.out.println("2. Delete Order");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    List<OrderItem> orderItems = orderItemService.getAllOrderItems();
                    new PrintOrderItems().print(orderItems);
                    break;
                case 2:
                    System.out.print("Enter Order ID to delete: ");
                    Long orderId = scanner.nextLong();
                    orderItemService.deleteOrderItem(orderId);
                    System.out.println("Order deleted successfully.");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void managePayments() {
        PaymentInput paymentInput = new PaymentInput(orderItemService);

        while (true) {
            System.out.println("Manage Payments:");
            System.out.println("1. View All Payments");
            System.out.println("2. Delete Payment");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    List<Payment> payments = paymentService.getAllPayments();
                    new PrintPayments().print(payments);
                    break;
                case 2:
                    System.out.print("Enter Payment ID to delete: ");
                    Long paymentId = scanner.nextLong();
                    paymentService.deletePayment(paymentId);
                    System.out.println("Payment deleted successfully.");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void viewReviews() {
        System.out.println("View Reviews:");
        List<Review> reviews = reviewService.getAllReviews();
        new PrintReviews().print(reviews);
    }

    private void manageFeedbacks() {
        FeedbackInput feedbackInput = new FeedbackInput();

        while (true) {
            System.out.println("Manage Feedbacks:");
            System.out.println("1. View All Feedbacks");
            System.out.println("2. Delete Feedback");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
                    new PrintFeedbacks().print(feedbacks);
                    break;
                case 2:
                    System.out.print("Enter Feedback ID to delete: ");
                    Long feedbackId = scanner.nextLong();
                    feedbackService.deleteFeedback(feedbackId);
                    System.out.println("Feedback deleted successfully.");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
