package com.springboot.backend.api.rest.app.model.service;

import java.util.List;

import com.springboot.backend.api.rest.app.model.entity.Client;

public interface ClientService {

	public List<Client> getClients();
	
	public Client getClient(Long id);
	
	public Client save(Client client);
	
	public void delete(Long id);
	
	
}
