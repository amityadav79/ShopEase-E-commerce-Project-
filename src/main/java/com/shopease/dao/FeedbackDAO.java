package com.shopease.dao;

import com.shopease.Entities.Feedback;
import com.shopease.Entities.OrderItem;

import java.util.List;

public interface FeedbackDAO {
    void saveFeedback(Feedback feedback);
    Feedback getFeedbackById(Long id);
    List<Feedback> getFeedbacksByUserId(Long userId);
    List<Feedback> getAllFeedbacks();  // Missing method added
    List<Feedback> getFeedbacksByOrderItem(OrderItem orderItem);  // New Method
    void deleteFeedback(Long id);
}
