package com.citi.euces.solicitudes.infra.dto;


public class ObtenerRegistrosAutoTasasPorEjecutivoRequest {

	private String nomina;
	private Long num_cte;
	private String year;
	public String getNomina() {
		return nomina;
	}
	public void setNomina(String nomina) {
		this.nomina = nomina;
	}
	public Long getNum_cte() {
		return num_cte;
	}
	public void setNum_cte(Long num_cte) {
		this.num_cte = num_cte;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
