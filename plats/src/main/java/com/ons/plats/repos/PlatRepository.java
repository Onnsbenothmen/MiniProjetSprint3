package com.ons.plats.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ons.plats.entities.Plat;
import com.ons.plats.entities.Type;

@RepositoryRestResource(path = "rest")
public interface PlatRepository extends JpaRepository<Plat, Long>   {

	List<Plat> findByNomPlat(String nom);
	List<Plat> findByNomPlatContains(String nom);
	
	
	
	@Query("select p from Plat p where p.nomPlat like %:nom and p.prixPlat > :prix")
	List<Plat> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	@Query("select p from Plat p where p.type = ?1")
	List<Plat> findByType (Type type);
	
	List<Plat> findByTypeIdType(Long id);
	
	List<Plat> findByOrderByNomPlatAsc();
	
	@Query("select p from Plat p order by p.nomPlat ASC, p.prixPlat DESC")
	List<Plat> trierPlatsNomsPrix ();


	

}