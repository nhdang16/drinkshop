package com.be.drinkshop.service;

import com.be.drinkshop.dto.CategoryDTO;
import com.be.drinkshop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category createCategory(CategoryDTO category);
    Category updateCategory(Long id, CategoryDTO categoryDetails);
    void deleteCategory(Long id);
}
