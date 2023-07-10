package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Category;
import com.templateproject.api.entity.ArticleContent;

public interface ArticleContentRepository extends JpaRepository<ArticleContent, Long> {

    //public List<Article> findByCategory(Category category, Pageable pageable);
}
