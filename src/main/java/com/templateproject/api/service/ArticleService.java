package com.templateproject.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Comment;
import com.templateproject.api.repository.ArticleRepository;
import com.templateproject.api.repository.CommentRepository;

@Service
public class ArticleService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public ArticleService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    public List<Comment> getCommentsByArticle(Article article) {
        return commentRepository.findByArticle(article);
    }

    public Article getArticleById(Integer articleId) {
        return articleRepository.findById(articleId).orElse(null);
    }

}
