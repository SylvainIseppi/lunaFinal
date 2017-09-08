package com.projet.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projet.model.Categorie;
import com.projet.services.CategorieService;


@Action("/accueilCategorie")
@ResultPath("/pages")
@Results({
	@Result(name = "SUCCESS", location = "categorie.jsp"),
	@Result(name = "insertOk", type="redirectAction", params={"namespace","/" ,"actionName" ,"/accueilCategorie"}),
	@Result(name = "suppresionOk", type = "redirectAction", params = { "namespace", "/", "actionName","/accueilCategorie" }),
	@Result(name = "updateConfirm", type = "redirectAction", params = { "namespace", "/", "actionName","/accueilCategorie" }),
	@Result(name = "updateOk", location = "updateCategorie.jsp"),
})

public class CategorieAction extends ActionSupport implements ModelDriven<Categorie>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Categorie> lesCategories;
	Categorie categorie=new Categorie();
	Categorie categorie2;
	Long idCategorie;
	@Autowired
	CategorieService serviceCategorie;
	@Override
	public Categorie getModel() {
		// TODO Auto-generated method stub
		return new Categorie();
	}
	
	@Override
	public String execute() throws Exception {
		lesCategories=serviceCategorie.getAllCategorie();
		return "SUCCESS";
	}
	
	@Action("/insertCategorie")
	public String insertCategorie(){
		serviceCategorie.insertCategorie(categorie);
		return "insertOk";
	}
	@Action("/supprimerCategorie")
	public String supprimerArticle(){
		serviceCategorie.deleteCategorie(serviceCategorie.getUneCategorie(idCategorie));
		return "suppresionOk";
	}
	@Action("/updateCategorie")
	public String updateArticle(){
		categorie2=serviceCategorie.getUneCategorie(idCategorie);
		return "updateOk";
	}
	@Action("/valideUpdateCategorie")
	public String valideUpdate(){
		serviceCategorie.updateCategorie(categorie2);
		return "updateConfirm";
	}
	
	public List<Categorie> getLesCategories() {
		return lesCategories;
	}
	public void setLesCategories(List<Categorie> lesCategories) {
		this.lesCategories = lesCategories;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Categorie getCategorie2() {
		return categorie2;
	}

	public void setCategorie2(Categorie categorie2) {
		this.categorie2 = categorie2;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	
}
