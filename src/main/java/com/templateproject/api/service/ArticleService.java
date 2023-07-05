package com.templateproject.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.templateproject.api.OffsetBasedPageRequest;
import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Category;
import com.templateproject.api.entity.Comment;
import com.templateproject.api.repository.ArticleRepository;
import com.templateproject.api.repository.CommentRepository;

@Service
public class ArticleService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    private final CategoryService categoryService;

    public ArticleService(CommentRepository commentRepository, ArticleRepository articleRepository,
            CategoryService categoryService) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
        this.categoryService = categoryService;
    }

    public List<Comment> getCommentsByArticle(Article article) {
        return commentRepository.findByArticle(article);
    }

    public Article getArticleById(Long articleId) {
        return articleRepository.findById(articleId).orElse(null);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public List<Article> findArticlesByCategory(String categorySlug, int limit, int offset) {
        Category category = categoryService.findCategoryBySlug(categorySlug);
        Pageable pageable = new OffsetBasedPageRequest(limit, offset);
        return articleRepository.findByCategory(category, pageable);
    }

}
