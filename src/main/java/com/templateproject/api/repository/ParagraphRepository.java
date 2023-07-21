package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Paragraph;

public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {

    List<Paragraph> findByArticle(Article article);
}
