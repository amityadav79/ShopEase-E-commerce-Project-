package com.shopease.dao;

import com.shopease.Entities.Category;
import java.util.List;

public interface CategoryDAO {
    void saveCategory(Category category);
    void updateCategory(Category category);
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    void deleteCategory(Long id);
}
