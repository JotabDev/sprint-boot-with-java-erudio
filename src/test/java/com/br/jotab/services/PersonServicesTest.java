package com.br.jotab.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.br.jotab.data.vo.v1.PersonVO;
import com.br.jotab.expections.RequiredNotFoundException;
import com.br.jotab.model.Person;
import com.br.jotab.repositories.PersonRepository;

import unittests.mapper.MockPerson;

//ciclo de vida da aplicação
@TestInstance(Lifecycle.PER_CLASS)
//extends mockito 
@ExtendWith(MockitoExtension.class)

class PersonServicesTest {

	MockPerson input;

	@InjectMocks
	private PersonServices services;

	@Mock
	PersonRepository repository;

	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockPerson();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindByAll() {
		List<Person> list = input.mockEntityList();

		when(repository.findAll()).thenReturn(list);

		var people = services.findByAll();

		assertNotNull(people);
		assertEquals(14, people.size());

		var resultOne = people.get(1);

		assertNotNull(resultOne);
		assertNotNull(resultOne.getKey());
		assertNotNull(resultOne.getLinks());
		assertTrue(resultOne.toString().contains(""));

		assertTrue(resultOne.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", resultOne.getAddress());
		assertEquals("First Name Test1", resultOne.getFirstName());
		assertEquals("Last Name Test1", resultOne.getLastName());
		assertEquals("Female", resultOne.getGender());

		var resultFour = people.get(4);

		assertNotNull(resultFour);
		assertNotNull(resultFour.getKey());
		assertNotNull(resultFour.getLinks());
		assertTrue(resultFour.toString().contains(""));

		assertTrue(resultFour.toString().contains("links: [</api/person/v1/4>;rel=\"self\"]"));
		assertEquals("Addres Test4", resultFour.getAddress());
		assertEquals("First Name Test4", resultFour.getFirstName());
		assertEquals("Last Name Test4", resultFour.getLastName());
		assertEquals("Male", resultFour.getGender());

		var resultSeven = people.get(7);

		assertNotNull(resultSeven);
		assertNotNull(resultSeven.getKey());
		assertNotNull(resultSeven.getLinks());
		assertTrue(resultSeven.toString().contains(""));

		assertTrue(resultSeven.toString().contains("links: [</api/person/v1/7>;rel=\"self\"]"));
		assertEquals("Addres Test7", resultSeven.getAddress());
		assertEquals("First Name Test7", resultSeven.getFirstName());
		assertEquals("Last Name Test7", resultSeven.getLastName());
		assertEquals("Female", resultSeven.getGender());

	}

	void testFindById() {
		Person person = input.mockEntity();
		person.setId(1L);
		/*
		 * where the repository.findById o MockitO InterCepta o codigo mockandO o
		 * "person" quS criamoS
		 */
		when(repository.findById(1L)).thenReturn(Optional.of(person));

		var result = services.findById(1L);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		System.out.println(result.toString());
		assertTrue(result.toString().contains(""));
	}

	@Test
	void testCreate() {
		Person persisty = input.mockEntity(1);
		persisty.setId(1L);

		PersonVO vo = input.mockVO(1);
		vo.setKey(1L);

		when(repository.save(any(Person.class))).thenReturn(persisty);

		var result = services.create(vo);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());

		assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testCreateWithNullPerson() {

		Exception exception = assertThrows(RequiredNotFoundException.class, () -> {
			services.create(null);
		});
		String exceptedMessage = "It Allowed Not nulll ID";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(exceptedMessage));

	}

	@Test
	void testUpdate() {
		Person entity = input.mockEntity(1);
		entity.setId(1L);

		Person persisty = entity;
		persisty.setId(1L);

		PersonVO vo = input.mockVO(1);
		vo.setKey(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(persisty)).thenReturn(entity);

		var result = services.update(vo);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());

		assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testUpdateWithNullPerson() {

		Exception exception = assertThrows(RequiredNotFoundException.class, () -> {
			services.update(null);
		});
		String exceptedMessage = "It Allowed Not nulll ID";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(exceptedMessage));
	}

	@Test
	void testDelete() {
		Person entity = input.mockEntity(1);
		entity.setId(1L);

		Person persisty = entity;
		persisty.setId(1L);

		PersonVO vo = input.mockVO(1);
		vo.setKey(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		;

		services.delete(1L);
	}

}
