package com.springboot.backend.api.rest.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.api.rest.app.model.dao.ClientDAO;
import com.springboot.backend.api.rest.app.model.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	public ClientDAO clientDAO;

	@Override
	public List<Client> getClients() {

		return (List<Client>) clientDAO.findAll();
	}

	@Override
	public Client getClient(Long id) {

		return clientDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Client save(Client client) {

		return clientDAO.save(client);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		clientDAO.deleteById(id);
	}

}
