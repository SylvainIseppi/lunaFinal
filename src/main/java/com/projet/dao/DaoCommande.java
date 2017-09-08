package com.projet.dao;

import java.util.List;

import com.projet.model.Commande;

public interface DaoCommande {

	List<Commande> getAllCommande();
	Commande getUneCommande(Long id);
	void insertCommande(Commande commande);
	void updateCommande(Commande commande);
	void deleteCommande(Commande commande);
	int getQuantiteArticle(int idArticle);
}