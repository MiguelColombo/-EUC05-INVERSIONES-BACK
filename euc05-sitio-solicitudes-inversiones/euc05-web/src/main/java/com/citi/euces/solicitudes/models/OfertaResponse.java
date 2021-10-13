package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.OfertaResponseDTO;

public class OfertaResponse {
	
	private  List<OfertaResponseDTO> ofertaResponseDTO;
	private String code;
	/**
	 * @param ofertaResponseDTO
	 * @param code
	 */
	public OfertaResponse(List<OfertaResponseDTO> ofertaResponseDTO, String code) {
		super();
		this.ofertaResponseDTO = ofertaResponseDTO;
		this.code = code;
	}
	public List<OfertaResponseDTO> getOfertaResponseDTO() {
		return ofertaResponseDTO;
	}
	public void setOfertaResponseDTO(List<OfertaResponseDTO> ofertaResponseDTO) {
		this.ofertaResponseDTO = ofertaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
