package com.br.jotab.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.jotab.model.Person;
import com.br.jotab.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonServices services;

//	@RequestMapping(value = "/{id}", 
	// method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)

	@GetMapping("/{id}")
	public Person findById(@PathVariable() String id) {
		return services.findById(id);
	}
	@PostMapping
	public Person create(@RequestBody Person person) {
		return services.create(person);
	}
	
	@PutMapping
	public Person update(@RequestBody Person person) {
		return services.update(person);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable() String id) {
		services.delete(id);
	}
	
	@GetMapping
	public List<Person> findAll() {
		return services.findByAll();
	}

}
