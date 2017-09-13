package com.test.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.DaoCategorie;
import com.projet.model.Categorie;
import com.projet.util.Context;

public class TestCategorieDao {

	private static DaoCategorie dao;

	@BeforeClass
	public static void initialisation() {
		ClassPathXmlApplicationContext context = Context.getInstance();
		dao = (DaoCategorie) context.getBean("DaoCategorie");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void insertCategorieTest() {
		Categorie cat = new Categorie();
		cat.setLibelle("electromenager");
		dao.insertCategorie(cat);
		assertEquals((long) cat.getId(), 1);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void getAllCategorieTest() {
		Categorie cat = new Categorie();
		dao.insertCategorie(cat);
		List<Categorie> listcat = dao.getAllCategorie();
		assertEquals(listcat.size(), 4);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void getUneCategorieTest() {
		Categorie cat = new Categorie();
		dao.insertCategorie(cat);
		dao.getUneCategorie(1L);
		assertEquals((long) cat.getId(), 2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void updateCategorieTest() {
		Categorie cat = new Categorie();
		dao.insertCategorie(cat);
		cat.setLibelle("electromenager");
		dao.updateCategorie(cat);
		cat = dao.getUneCategorie(3L);
		assertEquals(cat.getLibelle(), null);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void deleteCategorieTest() {
		Categorie cat = new Categorie();
		dao.insertCategorie(cat);
		dao.deleteCategorie(dao.getUneCategorie(1L));
		assertEquals(dao.getUneCategorie(1l), null);
	}
}