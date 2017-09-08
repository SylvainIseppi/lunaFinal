package com.projet.dao;

import java.util.List;

import com.projet.model.Article;

public interface DaoArticle {

	List<Article> getAllArticle();
	Article getUnArticle(Long id);
	void insertArticle(Article article);
	void updateArticle(Article article);
	void deleteArticle(Article article);
}