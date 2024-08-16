package com.shopease.Print;

import com.shopease.Entities.Category;

import java.util.List;

public class PrintCategories {

    public void print(List<Category> categories) {
        for (Category category : categories) {
            System.out.println("Category ID: " + category.getId());
            System.out.println("Name: " + category.getName());
            System.out.println("----------------------");
        }
    }
}
