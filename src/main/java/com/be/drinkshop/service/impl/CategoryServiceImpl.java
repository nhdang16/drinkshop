package com.be.drinkshop.service.impl;

import com.be.drinkshop.dto.CategoryDTO;
import com.be.drinkshop.model.Category;
import com.be.drinkshop.repository.CategoryRepository;
import com.be.drinkshop.repository.ProductRepository;
import com.be.drinkshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory(CategoryDTO category) {
        Optional<Category> existing = categoryRepository.findCategoryByNameIgnoreCase(category.getName());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Category name already exists");
        }
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDetails) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(categoryDetails.getName());
            category.setDescription(categoryDetails.getDescription());
            return categoryRepository.save(category);
        }).orElseThrow(() -> new RuntimeException("Category not found!"));
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        try {
            productRepository.deleteByCategoryId(id);
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
