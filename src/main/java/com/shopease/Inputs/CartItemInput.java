package com.shopease.Inputs;

import com.shopease.Entities.CartItem;
import com.shopease.Entities.Product;
import com.shopease.Entities.User;
import com.shopease.Services.ProductService;
import com.shopease.Services.UserService;

import java.util.Scanner;

public class CartItemInput {

    private final ProductService productService;
    private final UserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public CartItemInput(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    public CartItem getCartItemInput() {
        System.out.print("Enter User ID: ");
        Long userId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Product ID: ");
        Long productId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        User user = userService.getUserById(userId);
        Product product = productService.getProductById(productId);

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        CartItem cartItem = new CartItem();
        cartItem.setUser(user);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        return cartItem;
    }
}
