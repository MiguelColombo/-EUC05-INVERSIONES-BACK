package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;

public class TipoSolicitudRespoceDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	private Integer id; 
	private String nombre;
	private String valor;
	private String id_Campana;
	private String id_Oferta;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getId_Campana() {
		return id_Campana;
	}
	public void setId_Campana(String id_Campana) {
		this.id_Campana = id_Campana;
	}
	public String getId_Oferta() {
		return id_Oferta;
	}
	public void setId_Oferta(String id_Oferta) {
		this.id_Oferta = id_Oferta;
	}
	
	
  

}


	

