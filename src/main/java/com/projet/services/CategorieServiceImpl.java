package com.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.DaoArticle;
import com.projet.dao.DaoCategorie;
import com.projet.dao.DaoCategorieImpl;
import com.projet.model.Categorie;

@Service
public class CategorieServiceImpl implements CategorieService{
	private DaoCategorie cat;
	@Autowired
	DaoCategorie daoCategorie;
	
	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return daoCategorie.getAllCategorie();
	}

	@Override
	public Categorie getUneCategorie(Long id) {
		return daoCategorie.getUneCategorie(id);
	}

	@Override
	public void insertCategorie(Categorie categorie) {
		daoCategorie.insertCategorie(categorie);
		
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		daoCategorie.updateCategorie(categorie);
		
	}

	@Override
	public void deleteCategorie(Categorie cat) {
		daoCategorie.deleteCategorie(cat);
		
	}
	
}
