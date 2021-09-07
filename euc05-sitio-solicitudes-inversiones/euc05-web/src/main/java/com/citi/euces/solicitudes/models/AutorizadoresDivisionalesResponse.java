package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.AutorizadoresDivisionalesResponseDTO;

public class AutorizadoresDivisionalesResponse {
	
	private List<AutorizadoresDivisionalesResponseDTO> autorizadoresDivisionales;
	private String code;
	/**
	 * @param autorizadoresDivisionales
	 * @param code
	 */
	public AutorizadoresDivisionalesResponse(List<AutorizadoresDivisionalesResponseDTO> autorizadoresDivisionales,
			String code) {
		super();
		this.autorizadoresDivisionales = autorizadoresDivisionales;
		this.code = code;
	}
	public List<AutorizadoresDivisionalesResponseDTO> getAutorizadoresDivisionales() {
		return autorizadoresDivisionales;
	}
	public void setAutorizadoresDivisionales(List<AutorizadoresDivisionalesResponseDTO> autorizadoresDivisionales) {
		this.autorizadoresDivisionales = autorizadoresDivisionales;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
	

}
