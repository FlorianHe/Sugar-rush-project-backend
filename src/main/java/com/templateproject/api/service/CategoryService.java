package com.templateproject.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Category;
import com.templateproject.api.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryBySlug(String slug) {
        return categoryRepository.findBySlug(slug);
    }
}
