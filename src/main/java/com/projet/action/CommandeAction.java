package com.projet.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projet.model.Article;
import com.projet.model.Client;
import com.projet.model.Commande;
import com.projet.services.ArticleService;
import com.projet.services.ClientService;
import com.projet.services.CommandeService;

/**
 * 
 */
@Action("/accueilCommande")
@ResultPath("/pages")
@Results({ @Result(name = "SUCCES", location = "commande.jsp"),
		@Result(name = "Suppression OK", type = "redirectAction", params = { "namespace", "/", "actionName",
				"/accueilCommande" }),
		@Result(name = "insertOk", type = "redirectAction", params = { "namespace", "/", "actionName",
				"/accueilCommande" }),
		@Result(name = "ajoutArticleOK", location = "commande.jsp"), })
public class CommandeAction extends ActionSupport implements ModelDriven<Commande> {

	private static final long serialVersionUID = 1L;

	@Autowired
	CommandeService servCommande;
	@Autowired
	ClientService servClient;
	@Autowired
	ArticleService articleServ;

	List<Commande> lesCommandes;
	List<Article> lesArticles;
	List<Client> lesClients;
	Commande commande =new Commande();
	Long idCommande;
	Long idClient;
	Long idArticle;
	int quantiteArt;
	Article article;
	final static Map<Article, Integer> detailCommande = new HashMap<>();
	String modepaiement;
	Map<Article, Integer> detailCommandecopie = new HashMap<Article,Integer>();

	@Override
	public String execute() throws Exception {
		lesCommandes = servCommande.getAllCommande();
		lesClients = servClient.getAllClient();
		lesArticles = articleServ.getAllArticle();

		return "SUCCES";
	}

	@Action("/insertCommande")
	public String insertCommande() {
		commande.setClient(servClient.getUnClient(idClient));
			List<Article> articlesCommande =new ArrayList<>();
		for (Entry<Article, Integer> e : detailCommande.entrySet()) {
			for(int i=0;i<e.getValue();i++){
				articlesCommande.add(e.getKey());
			}
		}
		commande.setArticles(articlesCommande);
		commande.setModePayement(modepaiement);
		detailCommande.clear();
		servCommande.insertCommande(commande);
		return "insertOk";
	}

	@Action("/supprimerCommande")
	public String supprimerCommande() {
		servCommande.deleteCommande(servCommande.getUneCommande(idCommande));
		return "Suppression OK";
	}

	@Action("/ajoutArticleCommande")
	public String ajoutArticleCommande() {
		article = articleServ.getUnArticle(idArticle);
		System.out.println("quantite" +quantiteArt);
		detailCommande.put(article, quantiteArt);
		detailCommandecopie=detailCommande;
		lesClients = servClient.getAllClient();
		lesArticles = articleServ.getAllArticle();
		for (Entry<Article, Integer> e : detailCommande.entrySet()) {
			System.out.println("key :"+e.getKey());
			System.out.println("value :"+e.getValue());
		}
		return "ajoutArticleOK";
	}

	@Override
	public Commande getModel() {
		// TODO Auto-generated method stub
		return commande;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public List<Commande> getLesCommandes() {
		return lesCommandes;
	}

	public void setLesCommandes(List<Commande> lesCommandes) {
		this.lesCommandes = lesCommandes;
	}

	public List<Article> getLesArticles() {
		return lesArticles;
	}

	public void setLesArticles(List<Article> lesArticles) {
		this.lesArticles = lesArticles;
	}

	public List<Client> getLesClients() {
		return lesClients;
	}

	public void setLesClients(List<Client> lesClients) {
		this.lesClients = lesClients;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<Article, Integer> getDetailCommandecopie() {
		return detailCommandecopie;
	}

	public void setDetailCommandecopie(Map<Article, Integer> detailCommandecopie) {
		this.detailCommandecopie = detailCommandecopie;
	}

	public String getModepaiement() {
		return modepaiement;
	}

	public void setModepaiement(String modepaiement) {
		this.modepaiement = modepaiement;
	}

	public int getQuantiteArt() {
		return quantiteArt;
	}

	public void setQuantiteArt(int quantiteArt) {
		this.quantiteArt = quantiteArt;
	}
	
	
	

}
