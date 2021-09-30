package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.SucursalesConsultaResponseDTO;

public class SucursalesConsultaResponse {
	
	private List<SucursalesConsultaResponseDTO> SucursalesConsultaResponse;
	private String code;
	/**
	 * @param sucursalesConsultaResponse
	 * @param code
	 */
	public SucursalesConsultaResponse(List<SucursalesConsultaResponseDTO> sucursalesConsultaResponse, String code) {
		super();
		SucursalesConsultaResponse = sucursalesConsultaResponse;
		this.code = code;
	}
	public List<SucursalesConsultaResponseDTO> getSucursalesConsultaResponse() {
		return SucursalesConsultaResponse;
	}
	public void setSucursalesConsultaResponse(List<SucursalesConsultaResponseDTO> sucursalesConsultaResponse) {
		SucursalesConsultaResponse = sucursalesConsultaResponse;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
