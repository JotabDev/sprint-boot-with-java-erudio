package com.br.jotab.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.jotab.data.vo.v1.PersonVO;
import com.br.jotab.data.vo.v2.PersonVOv2;
import com.br.jotab.services.PersonServices;

@RestController
@RequestMapping("api/person/v1")
public class PersonController {

	@Autowired
	PersonServices services;

//	@RequestMapping(value = "/{id}", 
	// method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)

	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable() Long id) {
		return services.findById(id);
	}
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) {
		return services.create(person);
	}
	
	@PostMapping("/v2")
	public PersonVOv2 createV2(@RequestBody PersonVOv2 personVOv2) {
		return services.createV2(personVOv2);
	}
	
	@PutMapping
	public PersonVO update(@RequestBody PersonVO person) {
		return services.update(person);
	}
	// inclusion of ResponseEntity is application StatusCode
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable() Long id) {
		services.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public List<PersonVO> findAll() {
		return services.findByAll();
	}

}
