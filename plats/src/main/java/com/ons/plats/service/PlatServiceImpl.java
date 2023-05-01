package com.ons.plats.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ons.plats.entities.Plat;
import com.ons.plats.entities.Type;
import com.ons.plats.repos.PlatRepository;
import com.ons.plats.repos.TypeRepository;

@Service
public class PlatServiceImpl implements PlatService {

	@Autowired
	PlatRepository platRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
	@Override
	public Plat savePlat(Plat pl) {
		return platRepository.save(pl);
	}

	@Override
	public Plat updatePlat(Plat p) {
		return platRepository.save(p);
	}

	@Override
	public void deletePlat(Plat p) {
		platRepository.delete(p);		
	}

	@Override
	public void deletePlatById(Long id) {
		platRepository.deleteById(id);
		
	}

	@Override
	public Plat getPlat(Long id) {
		return platRepository.findById(id).get();

	}

	@Override
	public List<Plat> getAllPlats() {
		return platRepository.findAll();

	}
	@Override
	public Page<Plat> getAllPlatsParPage(int page, int size) {
	return platRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Plat> findByNomPlat(String nom) {
		return platRepository.findByNomPlat(nom);
	}

	@Override
	public List<Plat> findByNomPlatContains(String nom) {
		return platRepository.findByNomPlatContains(nom);
	}

	@Override
	public List<Plat> findByNomPrix(String nom, Double prix) {
		return platRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Plat> findByType(Type type) {
		return platRepository.findByType(type);
	}

	@Override
	public List<Plat> findByTypeIdType(Long id) {
		return platRepository.findByTypeIdType(id);
	}

	@Override
	public List<Plat> findByOrderByNomPlatAsc() {
		return platRepository.findByOrderByNomPlatAsc();
	}

	@Override
	public List<Plat> trierPlatNomsPrix() {
		return platRepository.trierPlatsNomsPrix();
	}

	@Override
	public List<Type> getAllTypes() {
		return typeRepository.findAll();
	}

}
