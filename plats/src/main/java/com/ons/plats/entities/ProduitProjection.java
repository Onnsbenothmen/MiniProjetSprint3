package com.ons.plats.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPlt", types = { Plat.class })
public interface ProduitProjection {
	public String getNomPlat();

}
