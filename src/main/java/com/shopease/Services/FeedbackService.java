package com.shopease.Services;

import com.shopease.Entities.Feedback;
import com.shopease.Entities.OrderItem;

import java.util.List;

public interface FeedbackService {
    void saveFeedback(Feedback feedback);
    Feedback getFeedbackById(Long id);
    List<Feedback> getAllFeedbacks();
    List<Feedback> getFeedbacksByOrderItem(OrderItem orderItem);  // New Method
    void deleteFeedback(Long id);
}
