package com.test.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.spring.entity.Article;

@Transactional
@Repository
public class ArticleDAO implements ArticleDAOInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Article getArticleById(int articleId) {
		// TODO Auto-generated method stub
		return entityManager.find(Article.class, articleId);
	}

	@Override
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		entityManager.persist(article);
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		Article article2 = getArticleById(article.getArticleId());
		article2.setTitle(article.getTitle());
		article2.setCategory(article.getTitle());
		entityManager.flush();
	}

	@Override
	public void deleteArticle(int articleId) {
		// TODO Auto-generated method stub
		entityManager.remove(getArticleById(articleId));
	}

	@Override
	public boolean articleExists(String title, String category) {
		// TODO Auto-generated method stub
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category).getResultList()
				.size();
		return count > 0 ? true : false;
	}

}
