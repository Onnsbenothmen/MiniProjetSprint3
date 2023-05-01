package com.ons.plats.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ons.plats.entities.Type;
import com.ons.plats.service.TypeService;

@Controller
public class TypeController {
	@Autowired
	TypeService typeService;


	@RequestMapping("/showCreateType")
	public String showCreate(ModelMap modelMap)
	{
		
		
	return "createType";
	}
	@RequestMapping("/saveType")
	public String saveType(@ModelAttribute("type") Type type,
	 ModelMap modelMap) throws
	ParseException
	{ 
		Type save = typeService.saveType(type);
return "redirect:/ListeTypes";
	}

	@RequestMapping("/ListeTypes")
	public String ListeTypes(ModelMap modelMap)
	{
	List<Type> tps = typeService.getAllTypes();
	modelMap.addAttribute("types", tps);
	return "listeTypes";
	}



	@RequestMapping("/supprimerType")
	public String supprimerType(@RequestParam("id") Long id,
	ModelMap modelMap)
	{
	typeService.deleteTypeById(id);
	List<Type> tps = typeService.getAllTypes();
	modelMap.addAttribute("types", tps);

	return "listeTypes";
	}


	@RequestMapping("/modifierType")
	public String modifierType(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Type tp = typeService.getType(id);
	modelMap.addAttribute("type", tp);
	return "editerType";
	}
	@RequestMapping("/updateType")
	public String updateType(@ModelAttribute("type") Type type,
			ModelMap modelMap) throws ParseException
	{
	

	 typeService.updateType(type);
	 List<Type> types = typeService.getAllTypes();
	 modelMap.addAttribute("types", types);
	 return "redirect:/ListeTypes";
	}
	
}

