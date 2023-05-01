package com.ons.plats.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ons.plats.entities.Plat;
import com.ons.plats.entities.Type;

public interface PlatService {
	
	Plat savePlat(Plat pl);
	Plat updatePlat(Plat p);
	void deletePlat(Plat p);
	void deletePlatById(Long id);
	Plat getPlat(Long id);
	List<Plat> getAllPlats();
	Page<Plat> getAllPlatsParPage(int page, int size);
	
	List<Plat> findByNomPlat(String nom);
	List<Plat> findByNomPlatContains(String nom);
	List<Plat> findByNomPrix (String nom, Double prix);
	List<Plat> findByType (Type type);
	List<Plat> findByTypeIdType(Long id);
	List<Plat> findByOrderByNomPlatAsc();
	List<Plat> trierPlatNomsPrix();
	List<Type> getAllTypes();


}
