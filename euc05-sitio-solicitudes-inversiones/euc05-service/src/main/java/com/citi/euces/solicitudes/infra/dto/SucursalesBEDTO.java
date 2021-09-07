package com.citi.euces.solicitudes.infra.dto;

public class SucursalesBEDTO {
	
	private Long id_Solicitud; 
	private String soeid;
	private String division;
	private String distrito;
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getSoeid() {
		return soeid;
	}
	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}
	public Long getId_Solicitud() {
		return id_Solicitud;
	}
	public void setId_Solicitud(Long id_Solicitud) {
		this.id_Solicitud = id_Solicitud;
	}
	

}
