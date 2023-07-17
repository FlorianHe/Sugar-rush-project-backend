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
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private boolean isMain;

    private String title;

    private String slug;

    private Date publicationDate;
    
    private Date modificationDate;
    
    private String leads;

    @Column(columnDefinition = "TEXT")
    private String content;
    
    private String publicationImage;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Transient
    private String categorySlug;

    @OneToMany(mappedBy = "article")
    @JsonManagedReference
    @JsonIgnore
    private List<Comment> listComments;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name= "user_id")
    private User author;

    public Article(boolean isMain, String title, String slug,
            String leads, String content, String publicationImage, String author, Category category) {
        this.isMain = isMain;
        this.title = title;
        this.slug = slug;
        this.publicationDate = new Date();
        this.modificationDate = new Date();
        this.leads = leads;
        this.content = content;
        this.publicationImage = publicationImage;
        this.category = category;
    }

    public Article() {
    }

    public Long getId() {
        return Id;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean isMain) {
        this.isMain = isMain;
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
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

    public String getPublicationImage() {
        return publicationImage;
    }

    public void setPublicationImage(String publicationImage) {
        this.publicationImage = publicationImage;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
