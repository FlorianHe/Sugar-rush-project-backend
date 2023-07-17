package com.templateproject.api.repository;

import com.templateproject.api.entity.Comment;
import com.templateproject.api.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<Comment> getComments(Long userId);

}
