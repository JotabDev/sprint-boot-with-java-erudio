package com.br.jotab.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.jotab.expections.ResourceNotFoundException;
import com.br.jotab.model.Person;
import com.br.jotab.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findByAll() {

		logger.info("Find All People");

		return repository.findAll();

	}

	public Person findById(Long id) {

		logger.info("finding one person");

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records " + "Found for This ID!"));
	}

	public Person create(Person personCreate) {
		logger.info("create one person");

		return repository.save(personCreate);
	}

	public Person update(Person personUpdate) {
		logger.info("updating one person");

		Person entity = repository.findById(personUpdate.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Not Records " + "Found for This ID!"));

		entity.setFirstName(personUpdate.getFirstName());
		entity.setLastName(personUpdate.getLastName());
		entity.setAndress(personUpdate.getAndress());
		entity.setGender(personUpdate.getGender());

		return repository.save(personUpdate);
	}

	public void delete(Long id) {
		logger.info("Deleting in person for Id");

		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found ID in Fiding"));
		repository.delete(entity);
	}
}
