package com.br.jotab.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.jotab.Mapper.DozerMapper;
import com.br.jotab.data.vo.v1.PersonVO;
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

		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);

	}

	public PersonVO findById(Long id) {

		logger.info("finding one person");

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records " + "Found for This ID!"));
	
		return DozerMapper.parseObject(entity, PersonVO.class);
	}

	public PersonVO create(PersonVO personCreate) {
		logger.info("create one person");

		Person entity = DozerMapper.parseObject(personCreate, Person.class);
		PersonVO vo =DozerMapper.parseObject(repository.save(entity),PersonVO.class);
				return vo;
	}

	public PersonVO update(PersonVO personUpdate) {
		logger.info("updating one person");

		Person entity = repository.findById(personUpdate.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Not Records " + "Found for This ID!"));

		entity.setFirstName(personUpdate.getFirstName());
		entity.setLastName(personUpdate.getLastName());
		entity.setAddress(personUpdate.getAddress());
		entity.setGender(personUpdate.getGender());

		PersonVO vo =DozerMapper.parseObject(repository.save(entity),PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting in person for Id");

		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found ID in Fiding"));
		repository.delete(entity);
	}
}
