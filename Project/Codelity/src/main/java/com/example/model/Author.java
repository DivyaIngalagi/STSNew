package com.codility.domain;

import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

     @Query(value = "select * from Article a where a.name=:#{#author.name} ",        nativeQuery = true)
     List<Article> findAllWrittenBy(@Param("author") Author author);

    @Query(value = "select tags from Article_Tags a join Article at on a.article_id=at.id where at.title=:title ",nativeQuery = true)
    List<String> findAllTagsOfArticle(@Param("title") String title);

 @Query(value = "select * from Article a where a.name=:#{#author.name} or a.title=:title ",        nativeQuery = true)
List<Article> findByAuthorOrTitle(@Param("author") Author author,@Param("title")  String title);

    @Query(value = "select a.author from Article a where  a.title=:title ",        nativeQuery = true)    
    Optional<Author> findAuthorOfArticleByTitle(@Param("title") String title);
}
