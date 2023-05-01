package com.ons.plats.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Plat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlat;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomPlat;
	@Min(value = 10)
	 @Max(value = 10000)

	private Double prixPlat;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date datePreparation;
	
	@ManyToOne
	private Type type;
	
	public Plat() {
	super();
	}
	public Plat(String nomPlat, Double prixPlat, Date datePreparation) {
	super();
	this.nomPlat = nomPlat;
	this.prixPlat = prixPlat;
	this.datePreparation = datePreparation;
	}
	public Long getIdPlat() {
		return idPlat;
	}
	public void setIdPlat(Long idPlat) {
		this.idPlat = idPlat;
	}
	public String getNomPlat() {
		return nomPlat;
	}
	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}
	public Double getPrixPlat() {
		return prixPlat;
	}
	public void setPrixPlat(Double prixPlat) {
		this.prixPlat = prixPlat;
	}
	public Date getDatePreparation() {
		return datePreparation;
	}
	public void setDatePreparation(Date datePreparation) {
		this.datePreparation = datePreparation;
	}
	@Override
	public String toString() {
		return "Plat [idPlat=" + idPlat + ", nomPlat=" + nomPlat + ", prixPlat=" + prixPlat + ", datePreparation="
				+ datePreparation + "]";
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	

}
