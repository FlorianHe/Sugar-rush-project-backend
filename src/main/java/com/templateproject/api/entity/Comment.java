package com.templateproject.api.entity;

import java.util.Date;

import com.templateproject.api.folderClassUser.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    // TODO Add @ManytoOne annotation
    private User user;

    public Comment() {
    }

    public Comment(String text, User user) {
        this.text = text;
        this.user = user;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
