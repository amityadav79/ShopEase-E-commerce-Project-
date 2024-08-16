package com.shopease.Inputs;

import com.shopease.Entities.Product;
import com.shopease.Services.CategoryService;

import java.util.Scanner;

public class ProductInput {

    private Scanner scanner = new Scanner(System.in);

    public Product getProductInput(CategoryService categoryService) {
        Product product = new Product();

        System.out.print("Enter product name: ");
        product.setName(scanner.nextLine());

        System.out.print("Enter product price: ");
        product.setPrice(scanner.nextDouble());
        scanner.nextLine(); // Consume newline

        System.out.print("Enter category ID or name: ");
        String categoryInput = scanner.nextLine();

        if (categoryInput.matches("\\d+")) { // It's an ID
            product.setCategory(categoryService.getCategoryById((long) Integer.parseInt(categoryInput)));
        } else { // It's a name
            product.setCategory(categoryService.getCategoryByName(categoryInput));
        }

        System.out.print("Enter product description: ");
        product.setDescription(scanner.nextLine());

        return product;
    }
}
