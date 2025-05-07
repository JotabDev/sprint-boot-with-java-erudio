package com.br.jotab.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.jotab.Controllers.PersonController;
import com.br.jotab.Mapper.DozerMapper;
import com.br.jotab.data.vo.v1.PersonVO;
import com.br.jotab.expections.RequiredNotFoundException;
import com.br.jotab.expections.ResourceNotFoundException;
import com.br.jotab.model.Person;
import com.br.jotab.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findByAll() {

		logger.info("Find All People");

		var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
		// interar em casa elemento
		persons.stream()
				.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

		return persons;
	}

	public PersonVO findById(Long id) {

		logger.info("finding one person");

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records " + "Found for This ID!"));

		PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}

	public PersonVO create(PersonVO personCreate) {
		
		if(personCreate == null) throw new RequiredNotFoundException();
		
		logger.info("create one person");

		Person entity = DozerMapper.parseObject(personCreate, Person.class);
		PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

//Endepointer version V2
	/*
	 * public PersonVOv2 createV2(PersonVOv2 personCreateV2) {
	 * logger.info("create one person with v2");
	 * 
	 * // Person person = mapperVO.convertEntityPerson(personCreateV2); //
	 * PersonVOv2 v2 = mapperVO.convertEntityPersonV2(person);
	 * 
	 * Person person = mapperVO.convertEntityPerson(personCreateV2); PersonVOv2 v2 =
	 * mapperVO.convertEntityPersonV2(person); return v2; }
	 */

	public PersonVO update(PersonVO personUpdate) {
		
		if(personUpdate == null) throw new RequiredNotFoundException();
		
		logger.info("updating one person");

		Person entity = repository.findById(personUpdate.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Not Records " + "Found for This ID!"));

		entity.setFirstName(personUpdate.getFirstName());
		entity.setLastName(personUpdate.getLastName());
		entity.setAddress(personUpdate.getAddress());
		entity.setGender(personUpdate.getGender());

		PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting in person for Id");

		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found ID in Fiding"));
		repository.delete(entity);
	}
}
