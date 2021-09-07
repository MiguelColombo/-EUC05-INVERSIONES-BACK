package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.AutoCetesResponseDTO;

public class AutoCetesResponse {
	
	private List<AutoCetesResponseDTO> AutoCetes;
	private String code;
	/**
	 * @param autoCetes
	 * @param code
	 */
	public AutoCetesResponse(List<AutoCetesResponseDTO> autoCetes, String code) {
		super();
		AutoCetes = autoCetes;
		this.code = code;
	}
	public List<AutoCetesResponseDTO> getAutoCetes() {
		return AutoCetes;
	}
	public void setAutoCetes(List<AutoCetesResponseDTO> autoCetes) {
		AutoCetes = autoCetes;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
