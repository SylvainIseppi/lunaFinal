package com.projet.services;

import java.util.List;

import com.projet.model.Categorie;

public interface CategorieService {
	
	List<Categorie> getAllCategorie();
	Categorie getUneCategorie(Long id);
	void insertCategorie(Categorie categorie);
	void updateCategorie(Categorie categorie);
	void deleteCategorie(Categorie cat);
	
}
