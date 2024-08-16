package com.shopease.Inputs;

import com.shopease.Entities.User;
import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public User getUserInput() {
        User user = new User();

        System.out.print("Enter username: ");
        user.setUsername(scanner.nextLine());

        System.out.print("Enter password: ");
        user.setPassword(scanner.nextLine());

        System.out.print("Enter email: ");
        user.setEmail(scanner.nextLine());

        // Assume role is selected elsewhere and set in service layer
        return user;
    }
}
