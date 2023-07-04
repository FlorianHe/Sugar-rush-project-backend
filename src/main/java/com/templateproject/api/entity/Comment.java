package com.templateproject.api.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    // TODO Add @ManytoOne annotation
    // private User user;

    public Comment() {
    }

    public Comment(String content) {
        this.content = content;
        this.creation_date = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String text) {
        this.content = text;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date date) {
        this.creation_date = date;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    // public User getUser() {
    // return user;
    // }

    // public void setUser(User user) {
    // this.user = user;
    // }

}
