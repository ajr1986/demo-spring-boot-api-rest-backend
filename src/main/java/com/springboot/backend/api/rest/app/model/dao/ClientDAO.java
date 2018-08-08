package com.springboot.backend.api.rest.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.api.rest.app.model.entity.Client;

public interface ClientDAO extends CrudRepository<Client, Long> {

}
