package com.shopease.Inputs;

import com.shopease.Entities.Review;
import com.shopease.Entities.Product;
import com.shopease.Entities.User;
import com.shopease.Services.ProductService;
import com.shopease.Services.UserService;

import java.util.Scanner;

public class ReviewInput {

    private final ProductService productService;
    private final UserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public ReviewInput(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    public Review getReviewInput() {
        System.out.print("Enter User ID: ");
        Long userId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Product ID: ");
        Long productId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        User user = userService.getUserById(userId);
        Product product = productService.getProductById(productId);

        System.out.print("Enter Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Comment: ");
        String comment = scanner.nextLine();

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setRating(rating);
        review.setComment(comment);

        return review;
    }
}
