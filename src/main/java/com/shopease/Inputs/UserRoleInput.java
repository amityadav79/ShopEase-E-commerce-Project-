package com.shopease.Inputs;

import com.shopease.Entities.UserRole;
import java.util.Scanner;

public class UserRoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public UserRole getUserRoleInput() {
        UserRole userRole = new UserRole();

        System.out.print("Enter User Role (Admin or Customer): ");
        userRole.setRoleName(scanner.nextLine());

        return userRole;
    }
}
