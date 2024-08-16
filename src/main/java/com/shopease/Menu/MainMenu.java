package com.shopease.Menu;

import com.shopease.Services.*;

import java.util.Scanner;

public class MainMenu {

    private final AdminMenu adminMenu;
    private final CustomerMenu customerMenu;

    private final Scanner scanner = new Scanner(System.in);

    public MainMenu(AdminMenu adminMenu, CustomerMenu customerMenu) {
        this.adminMenu = adminMenu;
        this.customerMenu = customerMenu;
    }

    public void showMenu() {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    adminMenu.showMenu();
                    break;
                case 2:
                    customerMenu.showMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
