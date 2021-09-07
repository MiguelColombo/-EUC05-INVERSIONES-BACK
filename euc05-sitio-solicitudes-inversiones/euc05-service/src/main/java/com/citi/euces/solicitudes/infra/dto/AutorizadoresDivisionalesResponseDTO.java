package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;
import java.util.Date;;

public class AutorizadoresDivisionalesResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	
	private String Soeid;
	private String Division;
	private String nombre;
	private String Inic;
	private String Fecha_Inicio;
	private String Fecha_Termino;
	private Long Alta;
	private Long id_nivel_auto;
	private String Correo;
	/**
	 * @param soeid
	 * @param division
	 * @param nombre
	 * @param inic
	 * @param fecha_Inicio
	 * @param fecha_Termino
	 * @param alta
	 * @param id_nivel_auto
	 * @param correo
	 */
	public AutorizadoresDivisionalesResponseDTO(String soeid, String division, String nombre, String inic,
			String fecha_Inicio, String fecha_Termino, Long alta, Long id_nivel_auto, String correo) {
		super();
		Soeid = soeid;
		Division = division;
		this.nombre = nombre;
		Inic = inic;
		Fecha_Inicio = fecha_Inicio;
		Fecha_Termino = fecha_Termino;
		Alta = alta;
		this.id_nivel_auto = id_nivel_auto;
		Correo = correo;
	}
	public String getSoeid() {
		return Soeid;
	}
	public void setSoeid(String soeid) {
		Soeid = soeid;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getInic() {
		return Inic;
	}
	public void setInic(String inic) {
		Inic = inic;
	}
	public String getFecha_Inicio() {
		return Fecha_Inicio;
	}
	public void setFecha_Inicio(String fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}
	public String getFecha_Termino() {
		return Fecha_Termino;
	}
	public void setFecha_Termino(String fecha_Termino) {
		Fecha_Termino = fecha_Termino;
	}
	public Long getAlta() {
		return Alta;
	}
	public void setAlta(Long alta) {
		Alta = alta;
	}
	public Long getId_nivel_auto() {
		return id_nivel_auto;
	}
	public void setId_nivel_auto(Long id_nivel_auto) {
		this.id_nivel_auto = id_nivel_auto;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	

}
