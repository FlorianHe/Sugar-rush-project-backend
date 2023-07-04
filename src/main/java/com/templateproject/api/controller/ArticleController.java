package com.templateproject.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.OffsetBasedPageRequest;
import com.templateproject.api.entity.Article;
import com.templateproject.api.repository.ArticleRepository;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public List<Article> getAllEmployees(int limit, int offset) {
        Pageable pageable = new OffsetBasedPageRequest(limit, offset);
        return articleRepository.findAll(pageable).getContent();
    }

    @GetMapping("/{id}")
    public Article show(@PathVariable int id) {
        return articleRepository.findById(id).get();
    }

    @PostMapping
    public Article create(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    @PutMapping("/{id}")
    public Article update(@PathVariable int id, @RequestBody Article article) {
        // getting article
        Article articleToUpdate = articleRepository.findById(id).get();
        articleToUpdate.setMain(article.is_main());
        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setSlug(article.getSlug());
        articleToUpdate.setModification_date(new Date());
        articleToUpdate.setLead(article.getLead());
        articleToUpdate.setContent(article.getContent());
        articleToUpdate.setPublication_image(article.getPublication_image());
        articleToUpdate.setAuthor(article.getAuthor());
        articleToUpdate.setCategories(article.getCategories());

        return articleRepository.save(articleToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        articleRepository.deleteById(id);
        return true;
    }

    // Not sure if this is needed since it's already in the CommentsController
    // @GetMapping("/{articleId}/comments")
    // public List<Comment> getCommentsByArticle(@PathVariable("articleId") Long
    // articleId) {
    // Article article = articleService.getArticleById(articleId);
    // return articleService.getCommentsByArticle(article);
    // }

}
