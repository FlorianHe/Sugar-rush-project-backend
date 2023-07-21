package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Comment;
import com.templateproject.api.entity.User;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByArticle(Article article);

    List<Comment> findCommentsByUser(User user, Pageable pageable);

}
