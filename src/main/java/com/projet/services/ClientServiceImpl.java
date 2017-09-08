package com.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.DaoCategorieImpl;
import com.projet.dao.DaoClient;
import com.projet.dao.DaoClientImpl;
import com.projet.model.Client;
@Service
public class ClientServiceImpl  implements ClientService{
	@Autowired
	DaoClient dao;
	
	private DaoClient getInstance(){
		return new DaoClientImpl();
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return dao.getAllClient();
	}

	@Override
	public Client getUnClient(Long id) {
		// TODO Auto-generated method stub
		return dao.getUnClient(id);
	}

	@Override
	public void insertClient(Client client) {
		dao.insertClient(client);
		
	}

	@Override
	public void updateClient(Client client) {
		dao.updateClient(client);
		
	}

	@Override
	public void deleteClient(Client client) {
		dao.deleteClient(client);
	}
}
