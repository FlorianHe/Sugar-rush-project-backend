package com.templateproject.api.entity;

import java.time.*; 
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import java.util.Date;


import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name="Article")
public class Article {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private int categ;
    private int auth;

    private boolean isMain;
    private String title;
    
    private String slug;
    
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime publicationDate;
    
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime modificationDate;
    
    @Column(name="leads", columnDefinition = "TEXT")
    private String leads;
    
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    
    @Column(columnDefinition = "TEXT")
    private String publicationImage;
    
        //private int categoryId;
    	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
        @JoinColumn(name = "categoryId", nullable = false) // Band obligatoire
	private Category category;
    
        //private int authorId;
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
        @JoinColumn(name = "authorId", nullable = false) // Band obligatoire
	private Author author;

    
    public Article() {  }

    public Article(String Restoration) {}
  
    public Article(
            int categ,
            int auth,
            String title, String slug, 
            String content, String leads,
            boolean isMain,
            LocalDateTime publicationDate, LocalDateTime modificationDate,
            String publicationImage,
            Article restorearticle) {
        this.categ = categ;
        this.auth = auth;
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.leads = leads;
        //this.author = author;
        //this.category = category;
        this.isMain = isMain;
        this.publicationDate = publicationDate;
        this.modificationDate = modificationDate;
        this.publicationImage = publicationImage;
 
    }

    public int getId() {
        return id;
    }
    
    public int getCateg() {
        return categ;
    }
    
    public void setCateg(int categ) {
        this.categ = categ;
    }
    
    
    public int getAuth() {
        return auth;
    }
    
    public void setAuth(int auth) {
        this.auth = auth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
        public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    
    
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    
}
