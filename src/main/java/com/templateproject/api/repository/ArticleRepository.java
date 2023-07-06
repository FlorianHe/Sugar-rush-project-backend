package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Category;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public List<Article> findByCategory(Category category, Pageable pageable);
}
