package com.citi.euces.solicitudes.models;

public class ExisteFolioBancanetResponse {
	
	private Long folioBancanet;
	private String code;
	/**
	 * @param folioBancanet
	 * @param code
	 */
	public ExisteFolioBancanetResponse(Long folioBancanet, String code) {
		super();
		this.folioBancanet = folioBancanet;
		this.code = code;
	}
	public Long getFolioBancanet() {
		return folioBancanet;
	}
	public void setFolioBancanet(Long folioBancanet) {
		this.folioBancanet = folioBancanet;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

}
