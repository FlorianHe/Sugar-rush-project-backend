package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Category;
import com.templateproject.api.entity.Paragraphe;

public interface ParagrapheRepository extends JpaRepository<Paragraphe, Long> {

    List<Paragraphe> findByArticle(Article article);
}
