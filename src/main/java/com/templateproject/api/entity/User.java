package com.templateproject.api.entity;

public class User {

    // TODO Add @Entity annotation
    // TODO Add @Id annotation
    // TODO Add @GeneratedValue annotation
    // TODO Add @OneToMany annotation
    // TODO private List<Comment> comments;

    private Long id;
    private String name;
    private String email;
    private String password;

    public User() {
    }

    public User(String name, String email, String password) {
        // TODO Set the name, email and password
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
