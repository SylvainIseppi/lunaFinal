package com.projet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projet.model.Commande;

@Repository("DaoCommande")
@Transactional
public class DaoCommandeImpl implements DaoCommande {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> getAllCommande() {
		return this.sessionFactory.getCurrentSession().createQuery("from Commande").list();
	}

	@Override
	public Commande getUneCommande(Long id) {
		return this.sessionFactory.getCurrentSession().find(Commande.class, id);
	}

	@Override
	public void insertCommande(Commande commande) {
		this.sessionFactory.getCurrentSession().save(commande);		
	}

	@Override
	public void updateCommande(Commande commande) {
		this.sessionFactory.getCurrentSession().update(commande);
	}

	@Override
	public void deleteCommande(Commande commande) {
		this.sessionFactory.getCurrentSession().delete(commande);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int getQuantiteArticle(int idArticle) {
		NativeQuery<Integer> nativ= this.sessionFactory.getCurrentSession().createNativeQuery("SELECT count('article_id')  FROM `commande_article` WHERE article_id="+idArticle);
		return nativ.getSingleResult();
	}
}