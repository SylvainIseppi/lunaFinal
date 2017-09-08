package com.projet.dao;

import java.util.List;

import com.projet.model.Client;

public interface DaoClient {

	List<Client> getAllClient();
	Client getUnClient(Long id);
	void insertClient(Client client);
	void updateClient(Client client);
	void deleteClient(Client client);
}