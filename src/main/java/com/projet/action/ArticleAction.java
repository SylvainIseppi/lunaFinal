package com.projet.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projet.model.Article;
import com.projet.model.Categorie;

import com.projet.services.ArticleService;

import com.projet.services.CategorieService;


@Action("/accueilArticle")
@ResultPath("/pages")
@Results({
		@Result(name = "SUCCESS", location = "article.jsp"),
		@Result(name = "insertOk", type = "redirectAction", params = { "namespace", "/", "actionName","/accueilArticle" }),
		@Result(name = "suppresionOk", type = "redirectAction", params = { "namespace", "/", "actionName","/accueilArticle" }),
		@Result(name = "updateConfirm", type = "redirectAction", params = { "namespace", "/", "actionName","/accueilArticle" }),
		@Result(name = "updateOk", location = "updateArticle.jsp"),

})

public class ArticleAction extends ActionSupport implements ModelDriven<Article> {
	@Autowired
	ArticleService articleServ;
	@Autowired
	CategorieService categorieServ;
	Long idCateg;
	Long idArticle;
	Article article = new Article();
	Article article2;
	List<Article> lesArticles;
	List<Categorie> lesCategories;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		lesArticles = articleServ.getAllArticle();
		lesCategories = categorieServ.getAllCategorie();
		for (Article article : lesArticles) {
			System.out.println(article.getId());
		}
		return "SUCCESS";
	}

	@Action("/insertArticle")
	public String insertArticle() {
		
		article.setCategorie(categorieServ.getUneCategorie(idCateg));
		articleServ.insertArticle(article);
		return "insertOk";
	}
	@Action("/supprimerArticle")
	public String supprimerArticle(){
		articleServ.deleteArticle(articleServ.getUnArticle(idArticle));
		return "suppresionOk";
	}
	@Action("/updateArticle")
	public String updateArticle(){
		lesCategories = categorieServ.getAllCategorie();
		article2=articleServ.getUnArticle(idArticle);
		return "updateOk";
	}
	@Action("/valideUpdateArticle")
	public String valideUpdate(){
		article2.setCategorie(categorieServ.getUneCategorie(idCateg));
		articleServ.updateArticle(article2);
		return "updateConfirm";
	}
	
	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}

	public List<Article> getLesArticles() {
		return lesArticles;
	}

	public void setLesArticles(List<Article> lesArticles) {
		this.lesArticles = lesArticles;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Categorie> getLesCategories() {
		return lesCategories;
	}

	public void setLesCategories(List<Categorie> lesCategories) {
		this.lesCategories = lesCategories;
	}

	public Long getIdCateg() {
		return idCateg;
	}

	public void setIdCateg(Long idCateg) {
		this.idCateg = idCateg;
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public Article getArticle2() {
		return article2;
	}

	public void setArticle2(Article article2) {
		this.article2 = article2;
	}
	
	
}
