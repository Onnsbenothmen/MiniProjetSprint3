package com.ons.plats.controllers;

import java.text.ParseException;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ons.plats.entities.Plat;
import com.ons.plats.entities.Type;
import com.ons.plats.service.PlatService;
import com.ons.plats.service.TypeService;

import jakarta.validation.Valid;

@Controller
public class PlatController {

	@Autowired
	PlatService platService;
	
	@Autowired
	TypeService typeService;
	
	
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Type> tps = platService.getAllTypes();
		Plat pl = new Plat();
		Type tp = new Type();
		tp = tps.get(0);
		pl.setType(tp);
	modelMap.addAttribute("plat", new Plat());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("types",tps);
	
	return "formPlat";
	}
	
	
	@RequestMapping("/savePlat")
	public String savePlat(@Valid Plat plat,
	 BindingResult bindingResult,ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size",defaultValue = "4") int size
			)
	{
		System.out.println(plat.toString() + "page = "+page + "size = "+size);

	if (bindingResult.hasErrors()) {
		List<Type> types=typeService.getAllTypes();
		modelMap.addAttribute("types",types);
		if(plat.getIdPlat()==null) {
			 modelMap.addAttribute("mode", "new");
		}else {
			modelMap.addAttribute("mode", "edit");
		}
		
		System.out.println(modelMap.getAttribute("page"));
		
		 return "formPlat";
	}
	int currentPage =page; 
	if(plat.getIdPlat()==null) {
		currentPage = platService.getAllPlats().size()/4;}
	platService.savePlat(plat);


	Page<Plat> pls =platService.getAllPlatsParPage(currentPage, 4);
	modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
	modelMap.addAttribute("currentPage", currentPage);
	modelMap.addAttribute("size", 4);
	modelMap.addAttribute("plats", plat);
	
	return ("redirect:/ListePlats?page="+currentPage+"&size="+size);
	}
	

	
	@RequestMapping("/modifierPlat")
	public String editerPlat(@RequestParam("id") Long id,ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size)
	{
	Plat p= platService.getPlat(id);
	modelMap.addAttribute("plat", p);
	modelMap.addAttribute("mode", "edit");
	List<Type> tps = platService.getAllTypes();
	modelMap.addAttribute("types",tps);
	System.out.println("the page "+page);
	modelMap.addAttribute("currentPage",page);
	modelMap.addAttribute("size", size);
		return "editerPLat";
	}
	
	@RequestMapping("/updatePlat")
	public String updatePlat(@ModelAttribute("plat") Plat plat,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size,
	@RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date datePreparation = dateformat.parse(String.valueOf(date));
	 plat.setDatePreparation(datePreparation);
	 
	 platService.updatePlat(plat);
	 Page<Plat> pls = platService.getAllPlatsParPage(page,size);
	 modelMap.addAttribute("plats", pls);
	 modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
	 modelMap.addAttribute("currentPage",page);
	 modelMap.addAttribute("size", size);
	 
	return "ListePlats";
	}
	
	@RequestMapping("/ListePlats")
	public String listePlats(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "4") int size)
	{
	Page<Plat> pls = platService.getAllPlatsParPage(page, size);
	modelMap.addAttribute("plats", pls);
	 modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listePlats";
	}
	
	@RequestMapping("/supprimerPlat")
	public String supprimerPlat(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "4") int size)
	{
	platService.deletePlatById(id);
	int totalPages = platService.getAllPlatsParPage(page, size).getTotalPages();
	if (totalPages <= page) {
	    page = totalPages - 1;
	}
	Page<Plat> pls = platService.getAllPlatsParPage(page, size);
	modelMap.addAttribute("plats", pls);
	modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listePlats";
	}
	
	
	
	


	
	
}
