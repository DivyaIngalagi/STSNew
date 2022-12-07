package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.model.Article;
import com.example.model.Author;

public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

    default List<Article> findAllWrittenBy(Author author) {

        return null;
    }

    default List<Article> findAllTagsOfArticle(String title) {

        return null;
    }

    default List<Article> findByAuthorOrTitle(Author author, String title) {

        return null;
    }

    default List<Article> findAuthorOfArticleByTitle(String title) {

        return null;
    }
}
