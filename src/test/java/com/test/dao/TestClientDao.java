package com.test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.projet.dao.DaoClient;
import com.projet.model.Client;
import com.projet.model.Client;
import com.projet.util.Context;

@FixMethodOrder(MethodSorters.JVM)
public class TestClientDao {
		private static DaoClient dao;

		@BeforeClass
		public static void initialisation() {
			ClassPathXmlApplicationContext context = Context.getInstance();
			dao = (DaoClient) context.getBean("DaoClient");
		}
		
		@Test
		public void insertClient(){
			Client client =new Client();
			client.setMobile("0669917653");
			client.setFixe("0352321521");
			client.setCarteFidelite(false);
			client.setNom("iseppi");
			client.setPrenom("sylvain");
			dao.insertClient(client);
			assertEquals((long)client.getId(), 2);
		}
		@Test
		public void getAllClient(){
			assertEquals(dao.getAllClient().size(), 1);
		}
		@Test
		public void getOneClient(){
			assertEquals((long)dao.getUnClient(2L).getId(), 2L);
		}
		
		@Test
		public void updateClient(){
				Client client = dao.getUnClient(2L);
				client.setCarteFidelite(true);;
				dao.updateClient(client);
				client = dao.getUnClient(2L);
				assertEquals(client.isCarteFidelite(), true);
			
		}
		@Test
		public void deleteClient(){
			dao.deleteClient(dao.getUnClient(2L));
			assertEquals(dao.getUnClient(2L),null);
		}

}
