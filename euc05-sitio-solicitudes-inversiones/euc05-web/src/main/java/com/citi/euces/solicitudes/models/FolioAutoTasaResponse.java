package com.citi.euces.solicitudes.models;

import java.math.BigInteger;

public class FolioAutoTasaResponse {
	
	 private BigInteger Folio;
	 private String code;
	/**
	 * @param folio
	 * @param code
	 */
	public FolioAutoTasaResponse(BigInteger folio, String code) {
		super();
		Folio = folio;
		this.code = code;
	}
	public BigInteger getFolio() {
		return Folio;
	}
	public void setFolio(BigInteger folio) {
		Folio = folio;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	 
	 


}
