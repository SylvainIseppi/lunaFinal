package com.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.DaoCommande;
import com.projet.dao.DaoCommandeImpl;
import com.projet.model.Commande;
@Service
public class CommandeServiceImpl implements CommandeService{
	
	@Autowired
	DaoCommande dao;
	@Override
	public List<Commande> getAllCommande() {
		// TODO Auto-generated method stub
		return dao.getAllCommande();
	}

	@Override
	public Commande getUneCommande(Long id) {
		// TODO Auto-generated method stub
		return dao.getUneCommande(id);
	}

	@Override
	public void insertCommande(Commande commande) {
		dao.insertCommande(commande);
		
	}

	@Override
	public void updateCommande(Commande commande) {
		dao.updateCommande(commande);
		
	}

	@Override
	public void deleteCommande(Commande commande) {
		dao.deleteCommande(commande);
		
	}

}
