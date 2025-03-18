package com.br.jotab.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.br.jotab.data.vo.v1.PersonVO;
import com.br.jotab.model.Person;

public class DozerMapper {

	// private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	private static ModelMapper mapper = new ModelMapper();
	
	static {
		mapper
		.createTypeMap(Person.class, PersonVO.class)
		.addMapping(Person::getId, PersonVO::setKey);
		mapper
		.createTypeMap(PersonVO.class,Person.class)
		.addMapping(PersonVO::getKey, Person::setId);
	}

	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> DestinationObjectList = new ArrayList<D>();
		for (O o : origin) {
			DestinationObjectList.add(mapper.map(o, destination));
		}
		return DestinationObjectList;
	}

	public static <O, D> D parseObject(O origin, Class<D> destination) {

		return mapper.map(origin, destination);
	}
	

}
