package com.test.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.DaoArticle;
import com.projet.dao.DaoCategorie;
import com.projet.dao.DaoArticle;
import com.projet.model.Article;
import com.projet.model.Categorie;
import com.projet.model.Article;


@FixMethodOrder(MethodSorters.JVM)
public class TestDaoArticle {
	static DaoArticle dao;
	static DaoCategorie daoCat;

	@Before
	public void initialisation() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-Context.xml");
		dao = (DaoArticle) context.getBean("DaoArticle");

	}

	@Test
	@Transactional
	@Rollback
	public void insertArticleTest() {
		Article Article = new Article();
		dao.insertArticle(Article);
		assertEquals((long) Article.getId(), 1);
	}

	@Test
	@Transactional
	@Rollback
	public void getAllArticleTest() {
		Article Article = new Article();
		dao.insertArticle(Article);
		List<Article> listArticle = dao.getAllArticle();
		assertEquals(listArticle.size(), 1);

	}

	@Test
	@Transactional
	@Rollback
	public void getUnArticleTest() {
		Article Article = new Article();
		dao.insertArticle(Article);
		dao.getUnArticle(1L);
		assertEquals((long) Article.getId(), 1);
	}

	@Test
	@Transactional
	@Rollback
	public void updateArticleTest() {
		Article Article = new Article();
		dao.insertArticle(Article);
		Article.setDesignation("vache qui rit");
//		clein d'oeil a notre formateur :D
		dao.updateArticle(Article);
		Article = dao.getUnArticle(1L);
		assertEquals(Article.getDesignation(), "vache qui rit");
	}

	@Test
	@Transactional
	@Rollback
	public void deleteArticleTest() {
		Article Article = new Article();
		dao.insertArticle(Article);
		dao.deleteArticle(dao.getUnArticle(1L));
		assertEquals(dao.getUnArticle(1l), null);
	}
}
