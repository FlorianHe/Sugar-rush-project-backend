package com.templateproject.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.entity.Article;
import com.templateproject.api.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAllArticles(int limit, int offset) {
        return articleService.getAllArticles(limit, offset);
    }

    @GetMapping("/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

    @PostMapping
    public Article create(@RequestBody Article article) {
        return articleService.create(article);
    }

    @PutMapping("/{id}")
    public Article update(@PathVariable Long id, @RequestBody Article article) {
        return articleService.update(id, article);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return articleService.delete(id);
    }

    // Not sure if this is needed since it's already in the CommentsController
    // @GetMapping("/{articleId}/comments")
    // public List<Comment> getCommentsByArticle(@PathVariable("articleId") Long
    // articleId) {
    // Article article = articleService.getArticleById(articleId);
    // return articleService.getCommentsByArticle(article);
    // }

}
