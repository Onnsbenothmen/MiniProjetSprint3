package com.ons.plats.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idType;
	private String nomType;
	private String descriptionType;
	
	@OneToMany (mappedBy="type")
	@JsonIgnore
	private List<Plat> plats;
	
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public String getNomType() {
		return nomType;
	}
	public void setNomType(String nomType) {
		this.nomType = nomType;
	}
	public String getDescriptionType() {
		return descriptionType;
	}
	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}
	@Override
	public String toString() {
		return "Type [idType=" + idType + ", nomType=" + nomType + ", descriptionType=" + descriptionType + "]";
	}
	public Type() {
		super();
	}
	public List<Plat> getPlats() {
		return plats;
	}
	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}
	
	

}
