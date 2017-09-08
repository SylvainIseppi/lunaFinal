package com.projet.services;

import java.util.List;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.projet.dao.DaoArticle;
import com.projet.dao.DaoArticleImpl;
import com.projet.model.Article;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {	
	@Autowired
	DaoArticle articleDao;
	
	
	@Override
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);

	}

	@Override
	public void insertArticle(Article article) {
		articleDao.insertArticle(article);

	}

	@Override
	public Article getUnArticle(Long id) {
		// TODO Auto-generated method stub
		return articleDao.getUnArticle(id);
	}

	@Override
	public List<Article> getAllArticle() {
		// TODO Auto-generated method stub
		return articleDao.getAllArticle();
	}

	@Override
	public void deleteArticle(Article article) {
		articleDao.deleteArticle(article);

	}
}
