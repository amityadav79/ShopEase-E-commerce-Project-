package com.shopease.Print;

import com.shopease.Entities.UserRole;
import java.util.List;

public class PrintUserRoles {

    public void print(List<UserRole> userRoles) {
        if (userRoles.isEmpty()) {
            System.out.println("No User Roles found.");
            return;
        }

        for (UserRole userRole : userRoles) {
            System.out.println("Role ID: " + userRole.getId());
            System.out.println("Role: " + userRole.getRoleName());
            System.out.println("------------------------");
        }
    }
}
