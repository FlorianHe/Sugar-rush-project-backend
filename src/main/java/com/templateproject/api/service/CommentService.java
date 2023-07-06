package com.templateproject.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Comment;
import com.templateproject.api.repository.ArticleRepository;
import com.templateproject.api.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;


    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // TODO Add a method to find all comments by the user id
    // TODO List<Comment> getAllCommentsByUserId(Long userId);

    public Comment createComment(Comment comment, Long articleId) {
        Article article = articleRepository.getReferenceById(articleId);
 
        // Définir l'article pour le commentaire
        comment.setArticle(article);

        // Enregistrer le commentaire
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, String updatedComment) {
        Comment existingComment = commentRepository.findById(id).orElse(null);
        if (existingComment != null) {
            existingComment.setContent(updatedComment);
            return commentRepository.save(existingComment);
        }
        return null;
    }

    public boolean deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment != null) {
            commentRepository.delete(comment);
            return true;
        }
        return false;
    }

    public List<Comment> getCommentsByArticle(Article article) {
        return commentRepository.findByArticle(article);
    }
}
