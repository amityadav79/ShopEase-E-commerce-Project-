package com.shopease.Inputs;

import com.shopease.Entities.Feedback;
import com.shopease.Entities.OrderItem;
import com.shopease.Entities.User;
import java.util.Scanner;

public class FeedbackInput {

    private final Scanner scanner = new Scanner(System.in);

    public Feedback getFeedbackInput(User user, OrderItem orderItem) {
        Feedback feedback = new Feedback();

        System.out.print("Enter Feedback Text: ");
        feedback.setFeedbackText(scanner.nextLine());

        feedback.setUser(user);
        feedback.setOrderItem(orderItem);

        return feedback;
    }
}
