package com.templateproject.api.controller;

import com.templateproject.api.entity.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    @PostMapping()
    public User createUser(User user) {
        return userService.createUser(user);
    }
    
}
