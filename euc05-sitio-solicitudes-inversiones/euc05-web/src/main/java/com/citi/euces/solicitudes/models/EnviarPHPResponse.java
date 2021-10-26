package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.EnviarPHPDTO;

public class EnviarPHPResponse {
	
	private  EnviarPHPDTO enviarPHPDTO;
	private String code;
	/**
	 * @param enviarPHPDTO
	 * @param code
	 */
	public EnviarPHPResponse(EnviarPHPDTO enviarPHPDTO, String code) {
		super();
		this.enviarPHPDTO = enviarPHPDTO;
		this.code = code;
	}
	public EnviarPHPDTO getEnviarPHPDTO() {
		return enviarPHPDTO;
	}
	public void setEnviarPHPDTO(EnviarPHPDTO enviarPHPDTO) {
		this.enviarPHPDTO = enviarPHPDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
