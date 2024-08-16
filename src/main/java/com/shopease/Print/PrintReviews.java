package com.shopease.Print;

import com.shopease.Entities.Review;

import java.util.List;

public class PrintReviews {

    public void print(List<Review> reviews) {
        for (Review review : reviews) {
            System.out.println("Review ID: " + review.getId());
            System.out.println("Product: " + review.getProduct().getName());
            System.out.println("User: " + review.getUser().getUsername());
            System.out.println("Rating: " + review.getRating());
            System.out.println("Comment: " + review.getComment());
            System.out.println("----------------------");
        }
    }
}
