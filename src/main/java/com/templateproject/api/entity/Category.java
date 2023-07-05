package com.templateproject.api.entity;


import java.time.*; 
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="slug")
    private String slug;
    
    @OneToMany(mappedBy = "category")
    private List<Article> article;


    public Category() {
    }
    
    public Category(String Restoration) {
    }
    
    public Category(String name, String slug, Category Restoration) {
        this.name = name;
        this.slug = slug;
         }

    // getters 
    public int GetId(){
		return this.id;
		}
    
    public String GetName(){
		return this.name;
		}

	public String GetSlug(){
		return this.slug;
		}		
		
	// setters	
	
	
	public void SetName(String name){
		 this.name = name;
		}
		
	public void SetSlug(String slug){
		 this.slug = slug;
		}	
		
	
	public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }	
	
}
