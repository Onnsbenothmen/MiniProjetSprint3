package com.ons.plats;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.ons.plats.entities.Plat;
import com.ons.plats.service.PlatService;


@SpringBootApplication
public class PlatsApplication implements CommandLineRunner {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	PlatService platService;

	public static void main(String[] args) {
		SpringApplication.run(PlatsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Plat.class);
	}

	

}
