package com.citi.euces.solicitudes.models;

import java.io.Serializable;
import java.util.List;

import com.citi.euces.solicitudes.infra.dto.AutorizadoresResponseDTO;

public class AutorizadoresResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	private List<AutorizadoresResponseDTO> autorizadores;
    private String code;
    
    
    
	/**
	 * @param autorizadores
	 * @param code
	 */
	public AutorizadoresResponse(List<AutorizadoresResponseDTO> autorizadores, String code) {
		super();
		this.autorizadores = autorizadores;
		this.code = code;
	}
	public List<AutorizadoresResponseDTO> getAutorizadores() {
		return autorizadores;
	}
	public void setAutorizadores(List<AutorizadoresResponseDTO> autorizadores) {
		this.autorizadores = autorizadores;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    

}
