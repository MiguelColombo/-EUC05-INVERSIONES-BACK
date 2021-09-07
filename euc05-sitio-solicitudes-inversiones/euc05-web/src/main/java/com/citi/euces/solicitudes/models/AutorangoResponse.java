package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.AutorangoResponseDTO;

public class AutorangoResponse {
	
	private List<AutorangoResponseDTO> autorango;
	private String code;
	
	
	
	/**
	 * @param autorango
	 * @param code
	 */
	public AutorangoResponse(List<AutorangoResponseDTO> autorango, String code) {
		super();
		this.autorango = autorango;
		this.code = code;
	}
	public List<AutorangoResponseDTO> getAutorango() {
		return autorango;
	}
	public void setAutorango(List<AutorangoResponseDTO> autorango) {
		this.autorango = autorango;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
