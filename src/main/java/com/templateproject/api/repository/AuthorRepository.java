package com.templateproject.api.repository;

import com.templateproject.api.entity.Author;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // custom query to search to blog post by title or content
    
}
   
