package com.shopease.ServicesImpl;

import com.shopease.dao.CategoryDAO;
import com.shopease.Entities.Category;
import com.shopease.Services.CategoryService;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    public CategoryServiceImpl() {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void saveCategory(Category category) {
        categoryDAO.saveCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDAO.getCategoryById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryDAO.getCategoryByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryDAO.deleteCategory(id);
    }
}
