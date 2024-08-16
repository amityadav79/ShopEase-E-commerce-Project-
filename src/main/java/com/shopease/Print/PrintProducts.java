package com.shopease.Print;

import com.shopease.Entities.Product;

import java.util.List;

public class PrintProducts {

    public void print(List<Product> products) {
        for (Product product : products) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Category: " + product.getCategory().getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("----------------------");
        }
    }
}
