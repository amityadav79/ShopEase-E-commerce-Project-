package com.shopease.dao;

import com.shopease.Entities.Product;
import java.util.List;

public interface ProductDAO {
    void saveProduct(Product product);
    void updateProduct(Product product);
    Product getProductById(Long id);
    List<Product> getProductsByCategoryId(Long categoryId);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
}
