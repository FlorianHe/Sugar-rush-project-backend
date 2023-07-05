package com.templateproject.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Category;
import com.templateproject.api.service.ArticleService;
import com.templateproject.api.service.CategoryService;

@RestController
public class CategoryController {

    private CategoryService categoryService;
    private ArticleService articleService;

    public CategoryController(CategoryService categoryService, ArticleService articleService) {
        this.categoryService = categoryService;
        this.articleService = articleService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{slug}")
    public Category getCategory(@PathVariable String slug) {
        return categoryService.findCategoryBySlug(slug);
    }

    @GetMapping("/categories/{slug}/articles")
    public List<Article> getArticlesByCategory(@PathVariable String slug, @RequestParam(defaultValue = "9") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        return articleService.findArticlesByCategory(slug, limit, offset);
    }
}