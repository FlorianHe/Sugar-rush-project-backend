package com.templateproject.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.templateproject.api.OffsetBasedPageRequest;
import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Category;
import com.templateproject.api.entity.Comment;
import com.templateproject.api.entity.Paragraph;
import com.templateproject.api.repository.ArticleRepository;
import com.templateproject.api.repository.CommentRepository;
import com.templateproject.api.repository.ParagraphRepository;

@Service
public class ArticleService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    private final ParagraphRepository paragraphRepository;
    
    private final CategoryService categoryService;
    

    public ArticleService(CommentRepository commentRepository, ArticleRepository articleRepository,ParagraphRepository paragraphRepository,
            CategoryService categoryService) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
        this.categoryService = categoryService;
        this.paragraphRepository = paragraphRepository;
    }

    public List<Comment> getCommentsByArticle(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        return commentRepository.findByArticle(article);
    }

    public List<Article> getAllArticles(int limit, int offset) {
        Pageable pageable = new OffsetBasedPageRequest(limit, offset);
        return articleRepository.findAll(pageable).getContent();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).get();
    }

    public Article create(Article article) {
        List<Paragraph> listParagraphs = article.getListParagraphs();
        Article articleReturn = articleRepository.save(article);
        for (Paragraph paragraph : listParagraphs) {
            paragraph.setArticle(articleReturn);
            paragraphRepository.save(paragraph);
        }
        return articleReturn;
        
    }

    public Article update(Long id, Article article) {
        // getting article
        Article articleToUpdate = articleRepository.findById(id).get();
        articleToUpdate.setMain(article.isMain());
        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setSlug(article.getSlug());
        articleToUpdate.setModificationDate(new Date());
        articleToUpdate.setLeads(article.getLeads());
        //articleToUpdate.setContent(article.getContent());
        articleToUpdate.setPublicationImage(article.getPublicationImage());
        articleToUpdate.setAuthor(article.getAuthor());
        articleToUpdate.setCategory(article.getCategory());

        return articleRepository.save(articleToUpdate);
    }

    public boolean delete(Long id) {
        articleRepository.deleteById(id);
        return true;
    }

    public List<Article> findArticlesByCategory(String categorySlug, int limit, int offset) {
        Category category = categoryService.findCategoryBySlug(categorySlug);
        Pageable pageable = new OffsetBasedPageRequest(limit, offset);
        return articleRepository.findByCategory(category, pageable);
    }

}
