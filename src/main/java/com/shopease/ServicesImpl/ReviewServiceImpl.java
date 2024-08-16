package com.shopease.ServicesImpl;

import com.shopease.dao.ReviewDAO;
import com.shopease.Entities.Review;
import com.shopease.Services.ReviewService;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    private ReviewDAO reviewDAO;

    public ReviewServiceImpl() {
        this.reviewDAO = reviewDAO;
    }

    @Override
    public void saveReview(Review review) {
        reviewDAO.saveReview(review);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewDAO.getReviewById(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewDAO.getAllReviews();
    }

    @Override
    public void deleteReview(Long id) {
        reviewDAO.deleteReview(id);
    }
}
