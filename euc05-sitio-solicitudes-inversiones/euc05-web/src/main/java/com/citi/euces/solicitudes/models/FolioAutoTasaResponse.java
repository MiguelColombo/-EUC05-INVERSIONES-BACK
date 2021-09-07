package com.citi.euces.solicitudes.models;

public class FolioAutoTasaResponse {
	
	 private Long Folio;
	 private String code;
	/**
	 * @param folio
	 * @param code
	 */
	public FolioAutoTasaResponse(Long folio, String code) {
		super();
		Folio = folio;
		this.code = code;
	}
	public Long getFolio() {
		return Folio;
	}
	public void setFolio(Long folio) {
		Folio = folio;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	 
	 


}
