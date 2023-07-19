package com.templateproject.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Category;
import com.templateproject.api.entity.User;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public List<Article> findByCategory(Category category, Pageable pageable);

    List<Article> findByAuthor(User user, Pageable pageable);

    Optional<Article> findFirstByIsMainTrueOrderByPublicationDateDesc();

    List<Article> findByCategoryAndIdNot(Category category, Long excludeId, Pageable pageable);
}
