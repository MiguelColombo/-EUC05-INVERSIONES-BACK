package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.ObtenerRegAutoTasaResposeDTO;

public class ObtenerRegAutoTasaRespose {
	private List<ObtenerRegAutoTasaResposeDTO> ObtenerRegAutoTasa;
    private String code;
	/**
	 * @param obtenerRegAutoTasa
	 * @param code
	 */
	public ObtenerRegAutoTasaRespose(List<ObtenerRegAutoTasaResposeDTO> obtenerRegAutoTasa, String code) {
		super();
		ObtenerRegAutoTasa = obtenerRegAutoTasa;
		this.code = code;
	}
	public List<ObtenerRegAutoTasaResposeDTO> getObtenerRegAutoTasa() {
		return ObtenerRegAutoTasa;
	}
	public void setObtenerRegAutoTasa(List<ObtenerRegAutoTasaResposeDTO> obtenerRegAutoTasa) {
		ObtenerRegAutoTasa = obtenerRegAutoTasa;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

    
}
