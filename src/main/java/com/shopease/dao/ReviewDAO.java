package com.shopease.dao;

import com.shopease.Entities.Review;
import java.util.List;

public interface ReviewDAO {
    void saveReview(Review review);
    Review getReviewById(Long id);
    List<Review> getReviewsByProductId(Long productId);
    List<Review> getReviewsByUserId(Long userId);
    List<Review> getAllReviews();  // Missing method added
    void deleteReview(Long id);
}
