package com.shopease.Services;

import com.shopease.Entities.Review;
import java.util.List;

public interface ReviewService {
    void saveReview(Review review);
    Review getReviewById(Long id);
    List<Review> getAllReviews();
    void deleteReview(Long id);
}
