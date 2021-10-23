package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;
import java.util.Date;;

public class AutorizadoresDivisionalesResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	
	private String soeid;
	private String division;
	private String nombre;
	private String inic;
	private String fecha_Inicio;
	private String fecha_Termino;
	private Long alta;
	private Long id_nivel_auto;
	private String correo;
	
	public AutorizadoresDivisionalesResponseDTO() {
		
	}
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
		this.soeid = soeid;
		this.division = division;
		this.nombre = nombre;
		this.inic = inic;
		this.fecha_Inicio = fecha_Inicio;
		this.fecha_Termino = fecha_Termino;
		this.alta = alta;
		this.id_nivel_auto = id_nivel_auto;
		this.correo = correo;
	}
	public String getSoeid() {
		return soeid;
	}
	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getInic() {
		return inic;
	}
	public void setInic(String inic) {
		this.inic = inic;
	}
	public String getFecha_Inicio() {
		return fecha_Inicio;
	}
	public void setFecha_Inicio(String fecha_Inicio) {
		this.fecha_Inicio = fecha_Inicio;
	}
	public String getFecha_Termino() {
		return fecha_Termino;
	}
	public void setFecha_Termino(String fecha_Termino) {
		this.fecha_Termino = fecha_Termino;
	}
	public Long getAlta() {
		return alta;
	}
	public void setAlta(Long alta) {
		this.alta = alta;
	}
	public Long getId_nivel_auto() {
		return id_nivel_auto;
	}
	public void setId_nivel_auto(Long id_nivel_auto) {
		this.id_nivel_auto = id_nivel_auto;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
