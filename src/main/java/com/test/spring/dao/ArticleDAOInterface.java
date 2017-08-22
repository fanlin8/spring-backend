package com.test.spring.dao;

import java.util.List;

import com.test.spring.entity.Article;

public interface ArticleDAOInterface {

	List<Article> getAllArticles();

	Article getArticleById(int articleId);

	void addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);

	boolean articleExists(String title, String category);

}
