package com.templateproject.api.controller;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Comment;
import com.templateproject.api.entity.LoginRequest;
import com.templateproject.api.entity.LoginResponse;
import com.templateproject.api.entity.User;
import com.templateproject.api.repository.UserRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.service.ArticleService;
import com.templateproject.api.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping()
public class UserController {

    private final UserService userService;
    private final ArticleService articleService;
    private final UserRepository userRepository;

    public UserController(UserService userService, ArticleService articleService, UserRepository userRepository) {
        this.userService = userService;
        this.articleService = articleService;
        this.userRepository = userRepository;
    }

    @Operation(summary = "Find users", description = "Find all users")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Find user", description = "Find a user")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        return userService.login(email, password);
    }

    @GetMapping("/users/{id}/articles")
    public List<Article> getArticlesByUser(@PathVariable("id") Long id, @RequestParam(defaultValue = "9") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        return articleService.getArticlesByUser(id, limit, offset);
    }

    @GetMapping("/users/{id}/comments")
    public List<Comment> getCommentsByUserId(@PathVariable("id") Long id, @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        return userService.getCommentsByUser(id, limit, offset);
    }

}
