package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.EjecutivoSucursalResponseDTO;

public class EjecutivoSucursalResponse {
	
	private List<EjecutivoSucursalResponseDTO> ejecutivoSucursalResponseDTO;
    private String code;
	/**
	 * @param ejecutivoSucursalResponseDTO
	 * @param code
	 */
	public EjecutivoSucursalResponse(List<EjecutivoSucursalResponseDTO> ejecutivoSucursalResponseDTO, String code) {
		super();
		this.ejecutivoSucursalResponseDTO = ejecutivoSucursalResponseDTO;
		this.code = code;
	}
	public List<EjecutivoSucursalResponseDTO> getEjecutivoSucursalResponseDTO() {
		return ejecutivoSucursalResponseDTO;
	}
	public void setEjecutivoSucursalResponseDTO(List<EjecutivoSucursalResponseDTO> ejecutivoSucursalResponseDTO) {
		this.ejecutivoSucursalResponseDTO = ejecutivoSucursalResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    
}
