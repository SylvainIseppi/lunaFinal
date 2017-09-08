package com.test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projet.dao.DaoArticle;
import com.projet.dao.DaoCategorie;
import com.projet.model.Article;
import com.projet.model.Categorie;
import com.projet.util.Context;

@FixMethodOrder(MethodSorters.JVM)
public  class TestDaoArticle {
	static DaoArticle dao;
	static DaoCategorie daoCat;
	
	@BeforeClass
	public static void initialisation() {
		ClassPathXmlApplicationContext context = Context.getInstance();
		dao = (DaoArticle) context.getBean("DaoArticle");
		daoCat = (DaoCategorie) context.getBean("DaoCategorie");
		
	}
	
	@Test
	public void insertArticle(){
		Article article=new Article();
		article.setDesignation("frigidaire");
		article.setPrixUnitaire(150);
		article.setQuantiteStock(200);
		article.setCategorie(daoCat.getUneCategorie(1L));
		dao.insertArticle(article);
		assertEquals((long)article.getId(), 4L);
	}

	@Test
	public void getAllArticle() {
		assertEquals(dao.getAllArticle().size(), 1);
	}

	@Test
	public void getOneArticle() {
		assertEquals((long) dao.getUnArticle(4L).getId(), 4L);
	}

	@Test
	public void updateArticle() {
		Article art = dao.getUnArticle(4L);
		art.setDesignation("frigo americain");
		dao.updateArticle(art);
		art = dao.getUnArticle(4L);
		assertEquals(art.getDesignation(), "frigo americain");

	}

	@Test
	@Ignore
	public void deleteArticle() {
		dao.deleteArticle(dao.getUnArticle(4L));
		assertEquals(dao.getUnArticle(4L), null);
	}
}
