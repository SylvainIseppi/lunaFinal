package com.projet.services;

import java.util.List;

import com.projet.model.Article;

public interface ArticleService {

	List<Article> getAllArticle();
	Article getUnArticle(Long id);
	void insertArticle(Article article);
	void updateArticle(Article article);
	void deleteArticle(Article article);
}
