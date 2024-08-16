package com.shopease.Services;

import com.shopease.Entities.Category;
import java.util.List;

public interface CategoryService {
    void saveCategory(Category category);
    void updateCategory(Category category);
    Category getCategoryById(Long i);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    void deleteCategory(Long id);
}
