package com.projet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.projet.model.Article;

@Repository("DaoArticle")
@Transactional
public class DaoArticleImpl implements DaoArticle {
	

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticle() {
		System.out.println(this.sessionFactory);
		return this.sessionFactory.getCurrentSession().createQuery("from Article").list();
		
	}

	@Override
	public Article getUnArticle(Long id) {
		return this.sessionFactory.getCurrentSession().find(Article.class, id);
	}

	@Override
	public void insertArticle(Article article) {
		this.sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public void updateArticle(Article article) {
		this.sessionFactory.getCurrentSession().update(article);		
	}

	@Override
	public void deleteArticle(Article article) {
		this.sessionFactory.getCurrentSession().delete(article);		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}