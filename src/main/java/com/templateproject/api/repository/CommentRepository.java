package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // TODO Add a method to find all comments by the user id
    // TODO List<Comment> findAllByUserId(Long userId);

    List<Comment> findByArticle(Article article);

}
