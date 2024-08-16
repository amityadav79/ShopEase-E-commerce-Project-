package com.shopease.Menu;

import com.shopease.Entities.*;
import com.shopease.Inputs.*;
import com.shopease.Print.*;
import com.shopease.Services.*;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {

    private final CartItemService cartItemService;
    private final OrderItemService orderItemService;
    private final PaymentService paymentService;
    private final ReviewService reviewService;
    private final ProductService productService;
    private final UserService userService;

    private final Scanner scanner = new Scanner(System.in);

    public CustomerMenu(CartItemService cartItemService, OrderItemService orderItemService,
                        PaymentService paymentService, ReviewService reviewService,
                        ProductService productService, UserService userService) {
        this.cartItemService = cartItemService;
        this.orderItemService = orderItemService;
        this.paymentService = paymentService;
        this.reviewService = reviewService;
        this.productService = productService;
        this.userService = userService;
    }

    public void showMenu() {
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Make Payment");
            System.out.println("6. View Orders");
            System.out.println("7. Leave Review");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    placeOrder();
                    break;
                case 5:
                    makePayment();
                    break;
                case 6:
                    viewOrders();
                    break;
                case 7:
                    leaveReview();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void viewProducts() {
        List<Product> products = productService.getAllProducts();
        new PrintProducts().print(products);
    }

    private void addToCart() {
        CartItemInput cartItemInput = new CartItemInput(productService, userService);
        CartItem newCartItem = cartItemInput.getCartItemInput();
        cartItemService.saveCartItem(newCartItem);
        System.out.println("Product added to cart successfully.");
    }

    private void viewCart() {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        new PrintCartItems().print(cartItems);
    }

    private void placeOrder() {
        OrderItemInput orderItemInput = new OrderItemInput(cartItemService);
        OrderItem newOrderItem = orderItemInput.getOrderItemInput();
        orderItemService.saveOrderItem(newOrderItem);
        System.out.println("Order placed successfully.");
    }

    private void makePayment() {
        PaymentInput paymentInput = new PaymentInput(orderItemService);
        Payment newPayment = paymentInput.getPaymentInput();
        paymentService.savePayment(newPayment);
        System.out.println("Payment made successfully.");
    }

    private void viewOrders() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        new PrintOrderItems().print(orderItems);
    }

    private void leaveReview() {
        ReviewInput reviewInput = new ReviewInput(productService, userService);
        Review newReview = reviewInput.getReviewInput();
        reviewService.saveReview(newReview);
        System.out.println("Review submitted successfully.");
    }
}
