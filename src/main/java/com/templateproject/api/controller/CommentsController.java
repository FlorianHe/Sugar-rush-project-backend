package com.templateproject.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.entity.Comment;
import com.templateproject.api.model.User;
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

    @PostMapping
    public Comment createComment(@RequestBody Comment commentDto) {
        Comment comment = new Comment(commentDto.getText());
        return commentService.createComment(comment);
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
}