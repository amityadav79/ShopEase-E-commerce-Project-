package com.shopease.ServicesImpl;

import com.shopease.dao.ProductDAO;
import com.shopease.Entities.Product;
import com.shopease.Services.ProductService;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    public ProductServiceImpl() {
        this.productDAO = productDAO;
    }

    @Override
    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productDAO.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public void deleteProduct(Long id) {
        productDAO.deleteProduct(id);
    }
}
