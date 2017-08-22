package com.test.spring.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.dao.ArticleDAOInterface;
import com.test.spring.entity.Article;

@Service
public class ArticleService implements ArticleServiceInterface {
	@Autowired
	private ArticleDAOInterface articleDAO;

	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return articleDAO.getAllArticles();
	}

	@Override
	public Article getArticleById(int articleId) {
		// TODO Auto-generated method stub
		Article article = articleDAO.getArticleById(articleId);
		return article;
	}

	@Override
	public synchronized boolean addArticle(Article article) {
		// TODO Auto-generated method stub
		if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
			return false;
		} else {
			articleDAO.addArticle(article);
			return true;
		}
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		articleDAO.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		// TODO Auto-generated method stub
		articleDAO.deleteArticle(articleId);
	}

}
