package com.templateproject.api;

import com.templateproject.api.entity.Article;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    // custom query to search to blog post by title or content
    List<Article> findByTitleContainingOrContentContaining(String text, String textAgain);
    
}
   
