package com.citi.euces.solicitudes.infra.dto;

import java.sql.Timestamp;

public class AutoTasaUpdateVOBOBEDTO {

	private String soeid_Autori;
	private String inic_Autori;
	private String estatus;
	private String soeid_Asig;
	private String observa_Web;
	private String fecha_Autori;
	private String fecha_Estatus;
	private String id_Tasauto;
	public String getSoeid_Autori() {
		return soeid_Autori;
	}
	public void setSoeid_Autori(String soeid_Autori) {
		this.soeid_Autori = soeid_Autori;
	}
	public String getInic_Autori() {
		return inic_Autori;
	}
	public void setInic_Autori(String inic_Autori) {
		this.inic_Autori = inic_Autori;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getSoeid_Asig() {
		return soeid_Asig;
	}
	public void setSoeid_Asig(String soeid_Asig) {
		this.soeid_Asig = soeid_Asig;
	}
	public String getObserva_Web() {
		return observa_Web;
	}
	public void setObserva_Web(String observa_Web) {
		this.observa_Web = observa_Web;
	}
	public String getId_Tasauto() {
		return id_Tasauto;
	}
	public void setId_Tasauto(String id_Tasauto) {
		this.id_Tasauto = id_Tasauto;
	}
	public String getFecha_Autori() {
		return fecha_Autori;
	}
	public void setFecha_Autori(String fecha_Autori) {
		this.fecha_Autori = fecha_Autori;
	}
	public String getFecha_Estatus() {
		return fecha_Estatus;
	}
	public void setFecha_Estatus(String fecha_Estatus) {
		this.fecha_Estatus = fecha_Estatus;
	}
	
	
	

}
