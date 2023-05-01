package com.ons.plats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ons.plats.entities.Type;
import com.ons.plats.repos.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	TypeRepository typeRepository;

	@Override
	public List<Type> getAllTypes() {
		 return typeRepository.findAll();
	}

	@Override
	public Type getType(Long id) {
		return typeRepository.findById(id).get();
	}


	@Override
	public void deleteTypeById(Long id) {
		typeRepository.deleteById(id);		
	}

	@Override
	public Type saveType(Type tp) {
		return typeRepository.save(tp);

	}

	@Override
	public Type updateType(Type tp) {
		return typeRepository.save(tp);

	}

	@Override
	public void deleteType(Type t) {
		typeRepository.delete(t);
		
	}

}
