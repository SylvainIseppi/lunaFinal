package com.test.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
import com.projet.dao.DaoCommande;
import com.projet.dao.DaoCommande;
import com.projet.model.Article;
import com.projet.model.Commande;
import com.projet.model.Commande;

@FixMethodOrder(MethodSorters.JVM)
public class TestCommandeDao {

	private static DaoCommande dao;
	private static DaoArticle daoArt;

	@Before
	public  void initialisation() {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-Context.xml");
		dao = (DaoCommande) context.getBean("DaoCommande");
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void insertCommandeTest(){
		Commande Commande =new Commande();
		dao.insertCommande(Commande);
		assertEquals((long)Commande.getId(), 1);
	}
	
	@Test
	@Transactional
	@Rollback
	public void getAllCommandeTest(){
		Commande Commande = new Commande();
		dao.insertCommande(Commande);
		List<Commande> listCommande = dao.getAllCommande();
		assertEquals(listCommande.size(), 1);
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void getUnCommandeTest(){
		Commande Commande = new Commande();
		dao.insertCommande(Commande);
		dao.getUneCommande(1L);
		assertEquals((long) Commande.getId(), 1);
	}
	
	@Test
	@Transactional
	@Rollback
	public void updateCommandeTest(){
			Commande Commande = new Commande();
			dao.insertCommande(Commande);
			Commande.setLibelle("ax");;
			dao.updateCommande(Commande);
			Commande = dao.getUneCommande(1L);
			assertEquals(Commande.getLibelle(), "ax");
	}
	
	@Test
	@Transactional
	@Rollback
	public void deleteCommandeTest(){
		Commande Commande = new Commande();
		dao.insertCommande(Commande);
		dao.deleteCommande(dao.getUneCommande(1L));
		assertEquals(dao.getUneCommande(1l),null);
	}
}
