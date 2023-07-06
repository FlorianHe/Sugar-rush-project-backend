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
import com.templateproject.api.entity.Comment;
import com.templateproject.api.service.ArticleService;
import com.templateproject.api.service.CommentService;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final CommentService commentService;

    public ArticleController(ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
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

    @GetMapping("/{id}/comments")
    public List<Comment> getCommentsByArticle(@PathVariable("id") Long id) {
        Article article = articleService.getArticleById(id);
        return articleService.getCommentsByArticle(article);
    }

    
    @PostMapping("/{id}/comments")
    public Comment createComment(@PathVariable("id") Long id, @RequestBody Comment commentDto) {
        return commentService.createComment(commentDto, id);
    }

}
