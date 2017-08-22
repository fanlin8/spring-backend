package com.test.spring.serivce;

import java.util.List;

import com.test.spring.entity.Article;

public interface ArticleServiceInterface {
	List<Article> getAllArticles();

	Article getArticleById(int articleId);

	boolean addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);
}
