package com.templateproject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.templateproject.api.entity.Category;

import com.templateproject.api.repository.CategoryRepository;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> index() {
        return (List<Category>) categoryRepository.findAll();
    }

    // Une route /categories/{slug}/articles qui récupère les articles de la
    // catégories défini dans slug avec une limite et un offset pour l’auto scroll
    // (ex : /articles?offset=xx&limit=xx). Il faut prévoir un next, un previous et
    // un count en plus des résultats
}