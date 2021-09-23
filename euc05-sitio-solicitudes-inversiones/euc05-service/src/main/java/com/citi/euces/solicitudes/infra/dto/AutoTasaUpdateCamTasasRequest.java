package com.citi.euces.solicitudes.infra.dto;

import java.sql.Timestamp;

public class AutoTasaUpdateCamTasasRequest {
	private String soeid_Asig;
	private String soeid_Ope;
	private String nomina_Cancel;
	private String nomejec_Cancel;
	private String justificacion_Cancel;
	private String fecha_Solic_Cancel;
	private String id_Tasauto;
	public String getSoeid_Asig() {
		return soeid_Asig;
	}
	public void setSoeid_Asig(String soeid_Asig) {
		this.soeid_Asig = soeid_Asig;
	}
	public String getSoeid_Ope() {
		return soeid_Ope;
	}
	public void setSoeid_Ope(String soeid_Ope) {
		this.soeid_Ope = soeid_Ope;
	}
	public String getNomina_Cancel() {
		return nomina_Cancel;
	}
	public void setNomina_Cancel(String nomina_Cancel) {
		this.nomina_Cancel = nomina_Cancel;
	}
	public String getNomejec_Cancel() {
		return nomejec_Cancel;
	}
	public void setNomejec_Cancel(String nomejec_Cancel) {
		this.nomejec_Cancel = nomejec_Cancel;
	}
	public String getJustificacion_Cancel() {
		return justificacion_Cancel;
	}
	public void setJustificacion_Cancel(String justificacion_Cancel) {
		this.justificacion_Cancel = justificacion_Cancel;
	}
	public String getFecha_Solic_Cancel() {
		return fecha_Solic_Cancel;
	}
	public void setFecha_Solic_Cancel(String fecha_Solic_Cancel) {
		this.fecha_Solic_Cancel = fecha_Solic_Cancel;
	}
	public String getId_Tasauto() {
		return id_Tasauto;
	}
	public void setId_Tasauto(String id_Tasauto) {
		this.id_Tasauto = id_Tasauto;
	}
	
	

}
