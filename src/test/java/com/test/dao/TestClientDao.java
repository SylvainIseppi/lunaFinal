package com.test.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.DaoClient;
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
		@Transactional
		@Rollback(true)
		public void insertClientTest(){
			Client client =new Client();
			client.setMobile("0669917653");
			client.setFixe("0352321521");
			client.setCarteFidelite(false);
			client.setNom("iseppi");
			client.setPrenom("sylvain");
			dao.insertClient(client);
			assertEquals((long)client.getId(), 1);
		}
		
		@Test
		@Transactional
		@Rollback(true)
		public void getAllClientTest(){
			Client client = new Client();
			dao.insertClient(client);
			List<Client> listclient = dao.getAllClient();
			assertEquals(listclient.size(), 2);
		}
		
		@Test
		@Transactional
		@Rollback(true)
		public void getUnClientTest(){
			Client client = new Client();
			dao.insertClient(client);
			dao.getUnClient(1L);
			assertEquals((long) client.getId(), 4);
		}
		
		@Test
		@Transactional
		@Rollback(true)
		public void updateClientTest(){
				Client client = new Client();
				dao.insertClient(client);
				client.setNom("PLESSIS");
				dao.updateClient(client);
				client = dao.getUnClient(3L);
				assertEquals(client.getNom(), null);
		}
		
		@Test
		@Transactional
		@Rollback(true)
		public void deleteClientTest(){
			Client client = new Client();
			dao.insertClient(client);
			dao.deleteClient(dao.getUnClient(1L));
			assertEquals(dao.getUnClient(1l),null);
		}

}
