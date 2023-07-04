package com.templateproject.api.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private boolean is_main;
    private String title;
    private String slug;
    private Date publication_date;
    private Date modification_date;
    private String lead_;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String publication_image;
    private String author;
    private String categories;

    public Article(int id, boolean is_main, String title, String slug, Date publication_date, Date modification_date,
            String lead_, String content, String publication_image, String author, String categories) {
        Id = id;
        this.is_main = is_main;
        this.title = title;
        this.slug = slug;
        this.publication_date = publication_date;
        this.modification_date = modification_date;
        this.lead_ = lead_;
        this.content = content;
        this.publication_image = publication_image;
        this.author = author;
        this.categories = categories;
    }

    public Article() {
    }

    public int getId() {
        return Id;
    }

    public boolean is_main() {
        return is_main;
    }

    public void setMain(boolean is_main) {
        this.is_main = is_main;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public Date getModification_date() {
        return modification_date;
    }

    public void setModification_date(Date modification_date) {
        this.modification_date = modification_date;
    }

    public String getLead() {
        return lead_;
    }

    public void setLead(String lead_) {
        this.lead_ = lead_;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublication_image() {
        return publication_image;
    }

    public void setPublication_image(String publication_image) {
        this.publication_image = publication_image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

}
