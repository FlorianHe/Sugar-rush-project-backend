package com.templateproject.api.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Paragraphe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;
    
    // I for Intro - C for Conclusion - P for paragraph
    private char typeContent;
    
    @Column(columnDefinition = "TEXT")
    private String content;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    
       
    public Paragraphe( String title, char typeContent,
             String content, Article article) {
        
        this.title = title;
        this.typeContent = typeContent;
        this.content = content;
        this.article = article;
    }

    public Paragraphe() {
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public char getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(char typeContent) {
        this.typeContent = typeContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
}
