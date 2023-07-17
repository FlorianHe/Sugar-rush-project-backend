package com.templateproject.api.controller;

import java.util.List;

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
    public Boolean deleteComment(@PathVariable("id") Long id) {
        return commentService.deleteComment(id);
    }

}