package com.br.jotab.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

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
