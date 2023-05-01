package com.ons.plats.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ons.plats.entities.Plat;
import com.ons.plats.service.PlatService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PlatRESRTController {
	@Autowired
	PlatService platService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Plat> getAllPlats() {
	return platService.getAllPlats();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Plat getProduitById(@PathVariable("id") Long id) {
	return platService.getPlat(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Plat createProduit(@RequestBody Plat plat) {
	return platService.savePlat(plat);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Plat updatePlat(@RequestBody Plat plat) {
	return platService.updatePlat(plat);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePlat(@PathVariable("id") Long id)
	{
	platService.deletePlatById(id);
	}
	
	@RequestMapping(value="/pltype/{idType}",method = RequestMethod.GET)
	public List<Plat> getPlatsByTypeId(@PathVariable("idType") Long idType) {
		return platService.findByTypeIdType(idType);
	}


}
