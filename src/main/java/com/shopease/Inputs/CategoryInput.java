package com.shopease.Inputs;

import com.shopease.Entities.Category;

import java.util.Scanner;

public class CategoryInput {

    private Scanner scanner = new Scanner(System.in);

    public Category getCategoryInput() {
        Category category = new Category();

        System.out.print("Enter category name: ");
        category.setName(scanner.nextLine());

        return category;
    }
}
