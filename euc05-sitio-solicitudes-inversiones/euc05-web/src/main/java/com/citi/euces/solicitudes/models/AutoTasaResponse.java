package com.citi.euces.solicitudes.models;

import java.io.Serializable;
import java.util.List;

import com.citi.euces.solicitudes.infra.dto.AutoTasaResponseDTO;
public class AutoTasaResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	private List<AutoTasaResponseDTO> obtenerRegCampTasa;
	private String code;
	/**
	 * @param obtenerRegCampTasa
	 * @param code
	 */
	public AutoTasaResponse(List<AutoTasaResponseDTO> obtenerRegCampTasa, String code) {
		super();
		this.obtenerRegCampTasa = obtenerRegCampTasa;
		this.code = code;
	}
	public List<AutoTasaResponseDTO> getObtenerRegCampTasa() {
		return obtenerRegCampTasa;
	}
	public void setObtenerRegCampTasa(List<AutoTasaResponseDTO> obtenerRegCampTasa) {
		this.obtenerRegCampTasa = obtenerRegCampTasa;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}