package com.templateproject.api.model;

public class User {

    // TODO Add @Entity annotation
    // TODO Add @Id annotation
    // TODO Add @GeneratedValue annotation
    // TODO Add @OneToMany annotation
    // TODO private List<Comment> comments;

    private Long id;
    private String firstname;
    private String lastname;
    private String username;

    public User() {
    }

    public User(String firstname, String lastname, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
