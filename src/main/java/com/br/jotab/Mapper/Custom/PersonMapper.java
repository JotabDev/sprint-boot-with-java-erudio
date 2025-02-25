package com.br.jotab.Mapper.Custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.br.jotab.data.vo.v2.PersonVOv2;
import com.br.jotab.model.Person;

@Service
public class PersonMapper {

	public PersonVOv2 convertEntityPersonV2(Person person) {
		PersonVOv2 v2 = new PersonVOv2();
		v2.setAddress(person.getAddress());
		v2.setBirthDay(new Date());
		v2.setFirstName(person.getFirstName());
		v2.setGender(person.getGender());
		v2.setId(person.getId());
		v2.setLastName(person.getLastName());
		return v2;
	}
	
	public Person convertEntityPerson(PersonVOv2 person) {
		Person v2 = new Person();
		v2.setAddress(person.getAddress());
		// v2.setBirthDay(new Date());
		v2.setFirstName(person.getFirstName());
		v2.setGender(person.getGender());
		v2.setId(person.getId());
		v2.setLastName(person.getLastName());
		return v2;
	}
}
