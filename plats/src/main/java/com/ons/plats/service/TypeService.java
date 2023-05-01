package com.ons.plats.service;

import java.util.List;

import com.ons.plats.entities.Type;

public interface TypeService {

	List<Type> getAllTypes();

	Type getType(Long id);

	Type updateType(Type type);
	void deleteType(Type t);

	void deleteTypeById(Long id);

	Type saveType(Type type);



}
