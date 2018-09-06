package com.springboot.backend.api.rest.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.api.rest.app.model.entity.Client;
import com.springboot.backend.api.rest.app.model.service.ClientService;

@CrossOrigin(origins = { "https://demo-angular-api-rest-client.herokuapp.com" })
@RestController
@RequestMapping(value = "/api")
public class ClientRestController {

	@Autowired
	private ClientService clientService;

	@GetMapping(value = "/clients")
	public List<Client> index() {
		return clientService.getClients();
	}

	@GetMapping(value = "/clients/{id}")
	public Client details(@PathVariable(name = "id") Long id) {
		return clientService.getClient(id);
	}

	@PostMapping(value = "/clients")
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		return clientService.save(client);
	}
	
	@PutMapping(value = "/clients/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Client update(@RequestBody Client client, @PathVariable(name = "id") Long id) {
		
		Client currentClient = clientService.getClient(id);
		
		currentClient.setName(client.getName());
		currentClient.setLastName(client.getLastName());
		currentClient.setEmail(client.getEmail());
		
		return clientService.save(currentClient);
	}
	
	@DeleteMapping(value = "/clients/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(name = "id") Long id) {
		clientService.delete(id);
	}
}
