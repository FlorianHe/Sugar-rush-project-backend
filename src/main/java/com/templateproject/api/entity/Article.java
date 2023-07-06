package com.templateproject.api.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private boolean is_main;
    private String title;
    private String slug;
    private Date publication_date;
    private Date modification_date;
    private String leads;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String publication_image;
    private String author;

    @JsonIdentityReference(alwaysAsId = true)
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Transient
    private String categorySlug;

    @OneToMany(mappedBy = "article")
    @JsonManagedReference
    @JsonIgnore
    private List<Comment> listComments;

    public Article(boolean is_main, String title, String slug,
            String leads, String content, String publication_image, String author, Category category) {
        this.is_main = is_main;
        this.title = title;
        this.slug = slug;
        this.publication_date = new Date();
        this.modification_date = new Date();
        this.leads = leads;
        this.content = content;
        this.publication_image = publication_image;
        this.author = author;
        this.category = category;
    }

    public Article() {
    }

    public Long getId() {
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

    public String getLeads() {
        return leads;
    }

    public void setLeads(String leads) {
        this.leads = leads;
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

    public String getCategorySlug() {
        return this.category.getSlug();
    }

    public void setCategorySlug(String categorySlug) {
        this.category.setSlug(categorySlug);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getListComments() {
        return listComments;
    }

    public void setListComments(List<Comment> listComments) {
        this.listComments = listComments;
    }
}
