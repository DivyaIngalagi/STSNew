package com.example.repo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.model.Article;

public class ArticleSpecificationFactory {

    public Specification<Article> allArticlesWithTag(String tag) {

        return new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return cb.like(root.get(Author), "%" + tag + "%");
            }
        };

    }

    public Specification<Article> byTitle(String title) {
        return new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {

                return null;
            }
        };
    }

    public Specification<Article> byTitlePart(String titlePart) {

        return new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {

                return null;

            }

        };

    }

}
