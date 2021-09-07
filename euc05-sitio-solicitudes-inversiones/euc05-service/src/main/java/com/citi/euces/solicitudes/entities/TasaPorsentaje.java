package com.citi.euces.solicitudes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_TASA_PORCENTAJE")
public class TasaPorsentaje {
	
	@Id
	@Column(name ="ID_TASA_PORC")
	private Long id_tasa_porc;
	@Column(name ="PLAZO")
	private Long plazo;
	@Column(name ="PORCENTAJE")
	private String porcentaje;
	@Column(name ="CAMPANA")
	private String campana;
	/**
	 * @param id_tasa_porc
	 * @param plazo
	 * @param porcentaje
	 * @param campana
	 */
	
	public TasaPorsentaje() {
		
	}
	
	public TasaPorsentaje(Long id_tasa_porc, Long plazo, String porcentaje, String campana) {
		super();
		this.id_tasa_porc = id_tasa_porc;
		this.plazo = plazo;
		this.porcentaje = porcentaje;
		this.campana = campana;
	}
	public Long getId_tasa_porc() {
		return id_tasa_porc;
	}
	public void setId_tasa_porc(Long id_tasa_porc) {
		this.id_tasa_porc = id_tasa_porc;
	}
	public Long getPlazo() {
		return plazo;
	}
	public void setPlazo(Long plazo) {
		this.plazo = plazo;
	}
	public String getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
	public String getCampana() {
		return campana;
	}
	public void setCampana(String campana) {
		this.campana = campana;
	}
	

}
