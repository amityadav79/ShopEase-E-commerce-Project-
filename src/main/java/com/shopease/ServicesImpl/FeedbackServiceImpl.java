package com.shopease.ServicesImpl;

import com.shopease.dao.FeedbackDAO;
import com.shopease.Entities.Feedback;
import com.shopease.Entities.OrderItem;
import com.shopease.Services.FeedbackService;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackDAO feedbackDAO;

    public FeedbackServiceImpl() {
        this.feedbackDAO = feedbackDAO;
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackDAO.saveFeedback(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackDAO.getFeedbackById(id);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackDAO.getAllFeedbacks();
    }
    
    @Override
    public List<Feedback> getFeedbacksByOrderItem(OrderItem orderItem) {
        return feedbackDAO.getFeedbacksByOrderItem(orderItem);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackDAO.deleteFeedback(id);
    }
}
