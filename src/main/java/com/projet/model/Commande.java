package com.projet.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "libelle")
	private String libelle;

	@ManyToOne
	@JoinColumn(name = "idclient")
	private Client client;

	@Column(name = "modepayement")
	private String modePayement;
	
	@Column(name = "quantite")
	private int quantite;

	@Column(name = "datecommande")
	private LocalDate dateCommande;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "commande_article", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"))
	
	private List<Article> articles;

	public Commande() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getModePayement() {
		return modePayement;
	}

	public void setModePayement(String modePayement) {
		this.modePayement = modePayement;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public LocalDate getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
