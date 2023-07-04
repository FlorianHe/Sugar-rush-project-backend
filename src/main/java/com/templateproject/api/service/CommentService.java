package com.templateproject.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Comment;
import com.templateproject.api.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // TODO Add a method to find all comments by the user id
    // TODO List<Comment> getAllCommentsByUserId(Long userId);

    public Comment createComment(Comment comment) {
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
}
