package com.ons.plats;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ons.plats.entities.Plat;
import com.ons.plats.entities.Type;
import com.ons.plats.repos.PlatRepository;
import com.ons.plats.service.PlatService;

@SpringBootTest
class PlatsApplicationTests {

	@Autowired
	private PlatRepository platRepository;
	@Autowired

	private PlatService platService;
	@Test
	public void testCreatePlat() {
	Plat pl = new Plat("lazagne",34.900,new Date());
	platRepository.save(pl);
	System.out.println(pl);

	}
	
	@Test
	public void testFindPlat()
	{
	Plat p = platRepository.findById(1L).get(); 
	System.out.println(p);
	}
	
	@Test
	public void testUpdatePlat()
	{
	Plat p = platRepository.findById(2L).get();
	p.setPrixPlat(10.800);
	platRepository.save(p);
	System.out.println(p);

	}
	
	@Test
	public void testDeletePlat()
	{
	platRepository.deleteById(3L);;
	}
	 
	@Test
	public void testListerTousPlats()
	{
	List<Plat> pls = platRepository.findAll();
	for (Plat p : pls)
	{
	System.out.println(p);
	}
	}

	@Test
	public void testFindByNomPlatContains()
	{
	Page<Plat> pls = platService.getAllPlatsParPage(0,2);
	System.out.println(pls.getSize());
	System.out.println(pls.getTotalElements());
	System.out.println(pls.getTotalPages());
	pls.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Plat p : pls)
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testFindPlatByNom()
	{
	List <Plat> plt = platRepository.findByNomPlat("pizza");
	for (Plat p : plt)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindPlatByNomContains()
	{
	List <Plat> plt = platRepository.findByNomPlatContains("p");
	for (Plat p : plt)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByNomPrix()
	{
	List<Plat> pls = platRepository.findByNomPrix("pizza", 11.0);
	for (Plat p : pls)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByType()
	{
	Type tp = new Type();
	tp.setIdType(1L);
	List<Plat> pls = platRepository.findByType(tp);
	for (Plat p : pls)
	{
	System.out.println(p);
	}
	}
	@Test
	public void findByTypeIdType()
	{
	List<Plat> pls = platRepository.findByTypeIdType(3L);
	for (Plat p : pls)
	{
	System.out.println(p);
	}
	 
	}
	@Test
	public void testfindByOrderByNomPlatAsc()
	{
	List<Plat> pls = 
	platRepository.findByOrderByNomPlatAsc();
	for (Plat p : pls)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierPlatsNomsPrix()
	{
	List<Plat> pls = platRepository.trierPlatsNomsPrix();
	for (Plat p : pls)
	{
	System.out.println(p);
	}
	}
	

}
