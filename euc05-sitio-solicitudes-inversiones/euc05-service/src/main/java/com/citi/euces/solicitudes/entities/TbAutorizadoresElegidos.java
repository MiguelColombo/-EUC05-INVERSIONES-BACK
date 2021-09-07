package com.citi.euces.solicitudes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_AUTORIZADORES_ELEGIDOS")
public class TbAutorizadoresElegidos {

	@Id
	@Column(name ="ID_TASAAUTO" )
	private Long id_TasaAuto;
	@Column(name ="AUTORIZADORES" )
	private String Autorizadores;
	
	/**
	 * @param id_TasaAuto
	 * @param autorizadores
	 */
	public TbAutorizadoresElegidos() {
		
	}
	
	public TbAutorizadoresElegidos(Long id_TasaAuto, String autorizadores) {
		super();
		this.id_TasaAuto = id_TasaAuto;
		Autorizadores = autorizadores;
	}
	public Long getId_TasaAuto() {
		return id_TasaAuto;
	}
	public void setId_TasaAuto(Long id_TasaAuto) {
		this.id_TasaAuto = id_TasaAuto;
	}
	public String getAutorizadores() {
		return Autorizadores;
	}
	public void setAutorizadores(String autorizadores) {
		Autorizadores = autorizadores;
	}
	
}
