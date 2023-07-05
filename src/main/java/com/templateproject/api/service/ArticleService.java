package com.templateproject.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.templateproject.api.OffsetBasedPageRequest;
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

    public List<Article> getAllArticles(int limit, int offset) {
        Pageable pageable = new OffsetBasedPageRequest(limit, offset);
        return articleRepository.findAll(pageable).getContent();
    }

    public Article show(int id) {
        return articleRepository.findById(id).get();
    }

    public Article create(Article article) {
        return articleRepository.save(article);
    }

    public Article update(int id, Article article) {
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
        articleToUpdate.setCategory(article.getCategory());

        return articleRepository.save(articleToUpdate);
    }

    public boolean delete(int id) {
        articleRepository.deleteById(id);
        return true;
    }
}
