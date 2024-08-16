package com.shopease.Print;

import com.shopease.Entities.User;

import java.util.List;

public class PrintUsers {

    public void print(List<User> users) {
        for (User user : users) {
            System.out.println("User ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("----------------------");
        }
    }
}
