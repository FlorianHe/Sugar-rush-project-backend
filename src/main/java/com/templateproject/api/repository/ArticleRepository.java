package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
