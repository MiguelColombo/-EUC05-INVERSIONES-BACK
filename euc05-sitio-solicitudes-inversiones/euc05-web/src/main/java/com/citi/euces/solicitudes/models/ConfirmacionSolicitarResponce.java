package com.citi.euces.solicitudes.models;

import com.citi.euces.solicitudes.infra.dto.AutoTasaInsertResponseDTO;

public class ConfirmacionSolicitarResponce {
	
	private AutoTasaInsertResponseDTO autoTasaInsertResponseDTO;
	private String code;
	public ConfirmacionSolicitarResponce(AutoTasaInsertResponseDTO autoTasaInsertResponseDTO, String code) {
		super();
		this.autoTasaInsertResponseDTO = autoTasaInsertResponseDTO;
		this.code = code;
	}
	public AutoTasaInsertResponseDTO getAutoTasaInsertResponseDTO() {
		return autoTasaInsertResponseDTO;
	}
	public void setAutoTasaInsertResponseDTO(AutoTasaInsertResponseDTO autoTasaInsertResponseDTO) {
		this.autoTasaInsertResponseDTO = autoTasaInsertResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
