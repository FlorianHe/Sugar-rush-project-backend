package com.templateproject.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.templateproject.api.entity.Comment;
import com.templateproject.api.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private final CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable("id") Long id, @RequestBody String updatedComment) {
        return commentService.updateComment(id, updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("id") Long id) {
        boolean deleted = commentService.deleteComment(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // TODO Not sure if this is needed here since it's already in ArticleController
    // @GetMapping("/article/{articleId}/comments")
    // public List<Comment> getCommentsByArticle(@PathVariable("articleId") Integer
    // articleId) {
    // Article article = articleService.getArticleById(articleId);
    // return commentService.getCommentsByArticle(article);
    // }
}