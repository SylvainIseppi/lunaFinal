package com.test.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projet.dao.DaoCategorie;
import com.projet.dao.DaoCategorieImpl;
import com.projet.model.Categorie;
import com.projet.util.Context;

@FixMethodOrder(MethodSorters.JVM)
public class TestCategorieDao {

	private static DaoCategorie dao;

	@BeforeClass
	public static void initialisation() {
		ClassPathXmlApplicationContext context = Context.getInstance();
		dao = (DaoCategorie) context.getBean("DaoCategorie");
	}

	@Test
	public void insertCategorie() {
		Categorie cat = new Categorie();
		cat.setLibelle("electromenager");

		dao.insertCategorie(cat);
		assertEquals((long) cat.getId(), 1);

	}

	@Test
	public void getAllCat() {
		List<Categorie> listcat = dao.getAllCategorie();
		assertEquals(listcat.size(), 1);
	}

	@Test
	public void getOneCat() {
		Categorie cat = dao.getUneCategorie(1L);
		assertEquals((long) cat.getId(), 1);
	}

	@Test
	public void updateCat() {
		Categorie cat = dao.getUneCategorie(1L);
		cat.setLibelle("electromenager2");
		dao.updateCategorie(cat);
		cat = dao.getUneCategorie(1L);
		assertEquals(cat.getLibelle(), "electromenager2");
	}

	@Test
	@Ignore
	public void TestDelCat() {
		dao.deleteCategorie(dao.getUneCategorie(1L));
		assertEquals(dao.getUneCategorie(1l), null);
	}

}
