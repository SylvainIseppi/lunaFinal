package com.projet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projet.model.Client;

@Repository("DaoClient")
@Transactional
public class DaoClientImpl implements DaoClient {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClient() {
		return this.sessionFactory.getCurrentSession().createQuery("from Client").list();
	}

	@Override
	public Client getUnClient(Long id) {
		return this.sessionFactory.getCurrentSession().find(Client.class, id);
	}

	@Override
	public void insertClient(Client client) {
		this.sessionFactory.getCurrentSession().save(client);
	}

	@Override
	public void updateClient(Client client) {
		this.sessionFactory.getCurrentSession().update(client);
	}

	@Override
	public void deleteClient(Client client) {
		this.sessionFactory.getCurrentSession().delete(client);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}