package com.templateproject.api.entity;

import java.time.*; 
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String firstname;
    private String lastname;
    
    @OneToMany(mappedBy = "author")
    private List<Article> article;

    
    public Author() {  }

    
    public Author(String Restoration) {
    }
    
    public Author(String firstname, String lastname, Author restoreauthor) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

   
    public int getId() {
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

    
    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }


    
}
