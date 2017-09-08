package com.projet.action;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projet.model.Client;
import com.projet.services.ClientService;
import com.projet.services.ClientServiceImpl;

@Action("/accueilClient")
@ResultPath("/pages")
@Results({ 
		@Result(name = "SUCCES", location = "client.jsp"),
		@Result(name = "suppression OK", type = "redirectAction", params = { "namespace", "/", "actionName","/accueilClient" }),
		@Result(name = "insertOk", type = "redirectAction", params = { "namespace", "/", "actionName","/accueilClient" }),
		@Result(name = "updateConfirm", type = "redirectAction", params = { "namespace", "/", "actionName","/accueilClient" }),
		@Result(name = "updateOk", location = "updateClient.jsp"),
})
public class ClientAction extends ActionSupport implements ModelDriven<Client> {
	List<Client> lesClients;
	Client client;
	Long idClient;
	@Autowired
	ClientService servClient;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		lesClients = servClient.getAllClient();
		return "SUCCES";
	}
	@Action("/insertClient")
	public String insertClient(){
		client.setDateCreation(new Date());
		System.out.println(client.isCarteFidelite());
		servClient.insertClient(client);
		return "insertOk";
	}
	
	@Action("/supprimerClient")
	public String supprimerClient() {
		servClient.deleteClient(servClient.getUnClient(idClient));
		return "suppression OK";
	}
	
	@Action("/updateClient")
	public String updateClient() {
		lesClients = servClient.getAllClient();
		client = servClient.getUnClient(idClient);
		return "updateOk";
	}
	
	@Action("/valideUpdateClient")
	public String valideUpdate() {
		servClient.updateClient(client);
		return "updateClient";
	}

	public List<Client> getLesClients() {
		return lesClients;
	}

	public void setLesClients(List<Client> lesClients) {
		this.lesClients = lesClients;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	@Override
	public Client getModel() {
		// TODO Auto-generated method stub
		return client;
	}
}
