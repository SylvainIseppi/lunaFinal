package com.projet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projet.model.Categorie;

@Repository("DaoCategorie") // Va etre scanner par Spring, objet gerer par spring donc backend
@Transactional 
public class DaoCategorieImpl implements DaoCategorie{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return	 this.sessionFactory.getCurrentSession().createQuery("from Categorie").list();
	}

	@Override
	public Categorie getUneCategorie(Long id) {
		return this.sessionFactory.getCurrentSession().find(Categorie.class, id);
	
	}

	@Override
	public void insertCategorie(Categorie categorie) {
		this.sessionFactory.getCurrentSession().save(categorie);
		
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		this.sessionFactory.getCurrentSession().update(categorie);
		
	}

	@Override
	public void deleteCategorie(Categorie cat) {
		this.sessionFactory.getCurrentSession().delete(cat);
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
