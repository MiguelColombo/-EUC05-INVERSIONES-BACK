package com.citi.euces.solicitudes.infra.dto;

public class AutoTasaUpdateRequest {
	private Long id_TasAuto;
	private String inic_Autori;
	private String soeid_Autori;
	public Long getId_TasAuto() {
		return id_TasAuto;
	}
	public void setId_TasAuto(Long id_TasAuto) {
		this.id_TasAuto = id_TasAuto;
	}
	public String getInic_Autori() {
		return inic_Autori;
	}
	public void setInic_Autori(String inic_Autori) {
		this.inic_Autori = inic_Autori;
	}
	public String getSoeid_Autori() {
		return soeid_Autori;
	}
	public void setSoeid_Autori(String soeid_Autori) {
		this.soeid_Autori = soeid_Autori;
	}
	
	

}
