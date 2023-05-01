package com.ons.plats.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ons.plats.entities.Type;
import com.ons.plats.service.TypeService;

public class TypeRESTController {
	
	@Autowired
    TypeService typeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Type> getAllTypes() {
	return typeService.getAllTypes();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Type getTypeById(@PathVariable("id") Long id) {
	return typeService.getType(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Type createType(@RequestBody Type type) {
	return typeService.saveType(type);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Type updateType(@RequestBody Type type) {
		return typeService.updateType(type);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteType(@PathVariable("id") Long id)
	{
		typeService.deleteTypeById(id);
	}

}


