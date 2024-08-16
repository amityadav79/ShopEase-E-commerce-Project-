package com.shopease.Print;

import com.shopease.Entities.Feedback;
import java.util.List;

public class PrintFeedbacks {

    public void print(List<Feedback> feedbacks) {
        if (feedbacks.isEmpty()) {
            System.out.println("No Feedback found.");
            return;
        }

        for (Feedback feedback : feedbacks) {
            System.out.println("Feedback ID: " + feedback.getId());
            System.out.println("User: " + feedback.getUser().getUsername());
            System.out.println("Order ID: " + feedback.getOrderItem().getId());
            System.out.println("Feedback Text: " + feedback.getFeedbackText());
            System.out.println("------------------------");
        }
    }
}
