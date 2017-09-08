package com.test.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projet.dao.DaoArticle;
import com.projet.dao.DaoCommande;
import com.projet.model.Article;
import com.projet.model.Commande;
import com.projet.util.Context;

@FixMethodOrder(MethodSorters.JVM)
public class TestCommandeDao {

	private static DaoCommande dao;
	private static DaoArticle daoArt;

	@BeforeClass
	public static void initialisation() {
		ClassPathXmlApplicationContext context = Context.getInstance();
		dao = (DaoCommande) context.getBean("DaoCommande");
		daoArt= (DaoArticle) context.getBean("DaoArticle");
	}

	@Test
	public void insertCommande() {
		Commande commande = new Commande();
		commande.setLibelle("c56c23");
		List<Article> listArt= new ArrayList<>();
		listArt.add(daoArt.getUnArticle(4L));
		listArt.add(daoArt.getUnArticle(4L));
		listArt.add(daoArt.getUnArticle(4L));
		listArt.add(daoArt.getUnArticle(4L));
		listArt.add(daoArt.getUnArticle(4L));
		commande.setArticles(listArt);
		dao.insertCommande(commande);
		

		
		assertEquals((long) commande.getId(), 3);
	}

	@Test
	public void getAllCommande() {
		assertEquals(dao.getAllCommande().size(), 1);
	}

	@Test
	public void getOneCommande() {
		assertEquals((long) dao.getUneCommande(3L).getId(), 3L);
	}

	@Test
	public void updateCommande() {
		Commande Commande = dao.getUneCommande(3L);
		Commande.setLibelle("x23c5");
		
		dao.updateCommande(Commande);
		Commande = dao.getUneCommande(3L);
		assertEquals(Commande.getLibelle(), "x23c5");

	}

	@Test
	@Ignore
	public void deleteCommande() {
		dao.deleteCommande(dao.getUneCommande(3L));
		assertEquals(dao.getUneCommande(3L), null);
	}

}
