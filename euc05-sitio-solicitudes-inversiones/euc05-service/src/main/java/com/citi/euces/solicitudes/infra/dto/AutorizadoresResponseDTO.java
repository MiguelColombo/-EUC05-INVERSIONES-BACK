package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;

public class AutorizadoresResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	private String Soeid;
	private String nombre;
	
	/**
	 * @param soeid
	 * @param division
	 * @param nombre
	 * @param distrito
	 */
	public AutorizadoresResponseDTO(String soeid, String nombre) {
		super();
		Soeid = soeid;
		this.nombre = nombre;
	}
	
	public String getSoeid() {
		return Soeid;
	}
	public void setSoeid(String soeid) {
		Soeid = soeid;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
