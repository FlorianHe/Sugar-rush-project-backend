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
public class ArticleContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private Long introduction_Id;
    private Long conclusion_Id;


    
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    
    @OneToMany(mappedBy = "paragraphe")
    @JsonManagedReference
    @JsonIgnore
    private List<Paragraphe> paragraphes;

    public ArticleContent(Long introduction_Id,
     Long conclusion_Id, Paragraphe paragraphes ) {
        
        this.introduction_Id = introduction_Id ;
        this.conclusion_Id = conclusion_Id;
        //this.paragraphes = paragraphes;
        
    }

    public ArticleContent() {
    }

    public Long getId() {
        return Id;
    }
  
    public Long getIntroId() {
        return introduction_Id;
    }
    
    public void setIntroId(Long introduction_Id) {
         this.introduction_Id = introduction_Id;
    }
  
        
    public Long getConcluId() {
        return conclusion_Id;
    }
    
    public void setConcluId(Long conclusion_Id) {
         this.conclusion_Id = conclusion_Id;
    }
    

    public List<Paragraphe> getParagraphes() {
        return paragraphes;
    }

    public void setParagraphes(List<Paragraphe> paragraphes) {
        this.paragraphes = paragraphes;
    }
}
