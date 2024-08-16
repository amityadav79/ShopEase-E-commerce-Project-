package com.shopease.Services;

import com.shopease.Entities.Product;
import java.util.List;

public interface ProductService {
    void saveProduct(Product product);
    void updateProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
}
