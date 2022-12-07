package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Author author;

    @Column(unique = true)
    private String title;

    public Article() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String content;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> tags = new ArrayList();

    public Article(Author author, String title) {
        super();
        this.author = author;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}
