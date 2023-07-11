/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.templateproject.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Article;
import com.templateproject.api.entity.Paragraphe;
import com.templateproject.api.repository.ArticleRepository;
import com.templateproject.api.repository.ParagrapheRepository;

/**
 *
 * @author harle
 */
@Service
public class ParagrapheService {
    
    private final ParagrapheRepository paragrapheRepository;
    private final ArticleRepository articleRepository;


    public ParagrapheService(ParagrapheRepository paragrapheRepository, ArticleRepository articleRepository) {
        this.paragrapheRepository = paragrapheRepository;
        this.articleRepository = articleRepository;
    }

    public List<Paragraphe> getAllParagraphes() {
        return paragrapheRepository.findAll();
    }

    // TODO Add a method to find all paragraphes by the user id
    // TODO List<Paragraphe> getAllParagraphesByUserId(Long userId);

    public Paragraphe createParagraphe(Paragraphe paragraphe, Long id) {
        Article article = articleRepository.getReferenceById(id);
 
        // Définir l'article pour le paragrapheaire
        paragraphe.setArticle(article);
        //paragraphe.setCreation_date(new Date());

        // Enregistrer le paragrapheaire
        return paragrapheRepository.save(paragraphe);
    }

    public Paragraphe updateParagraphe(Long id, String updatedParagraphe) {
        Paragraphe existingParagraphe = paragrapheRepository.findById(id).orElse(null);
        if (existingParagraphe != null) {
            existingParagraphe.setContent(updatedParagraphe);
            return paragrapheRepository.save(existingParagraphe);
        }
        return null;
    }

    public boolean deleteParagraphe(Long id) {
        Paragraphe paragraphe = paragrapheRepository.findById(id).orElse(null);
        if (paragraphe != null) {
            paragrapheRepository.delete(paragraphe);
            return true;
        }
        return false;
    }

    public List<Paragraphe> getParagraphesByArticle(Article article) {
        return paragrapheRepository.findByArticle(article);
    }
    
}
