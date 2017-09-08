package com.projet.services;

import java.util.List;

import com.projet.model.Client;

public interface ClientService {
	List<Client> getAllClient();
	Client getUnClient(Long id);
	void insertClient(Client client);
	void updateClient(Client client);
	void deleteClient(Client client);
}
