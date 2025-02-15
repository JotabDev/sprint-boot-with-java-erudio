package com.br.jotab.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.br.jotab.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findByAll() {

		logger.info("Find All People");

		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person personItem = mockPerson(i);
			personList.add(personItem);
		}
		return personList;
	}

	public Person findById(String id) {

		logger.info("finding one person");

		Person person = new Person();

		person.setId(counter.incrementAndGet());
		person.setFirstName("Joao");
		person.setLastName("Batista");
		person.setAndress("Novo Maranguape");
		person.setGender("Masculino");

		return person;
	}
	
	public Person create(Person personCreate) {
		logger.info("create one person");
		
		return personCreate;
	}
	
	public Person update(Person personUpdate) {
		logger.info("updating one person");
		
		return personUpdate;
	}
	
	public void delete (String id) {
		logger.info("Deleting in person for Id");
	}
	
	

	private Person mockPerson(int i) {

		Person person = new Person();

		person.setId(counter.incrementAndGet());
		person.setFirstName("Joao name" + i);
		person.setLastName("Batista" + i);
		person.setAndress("Novo Maranguape" + i);
		person.setGender("Masculino" + i);

		return person;

	}
}
