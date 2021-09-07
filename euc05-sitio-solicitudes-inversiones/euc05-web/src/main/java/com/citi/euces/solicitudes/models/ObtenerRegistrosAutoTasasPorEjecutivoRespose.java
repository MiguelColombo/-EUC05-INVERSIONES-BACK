package com.citi.euces.solicitudes.models;
import java.util.List;

import  com.citi.euces.solicitudes.infra.dto.ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO;

public class ObtenerRegistrosAutoTasasPorEjecutivoRespose {
	
	private List<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO> ObtenerRegistrosAutoTasasPorEjecutivo;
	private String code;
	/**
	 * @param obtenerRegistrosAutoTasasPorEjecutivo
	 * @param code
	 */
	public ObtenerRegistrosAutoTasasPorEjecutivoRespose(
			List<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO> obtenerRegistrosAutoTasasPorEjecutivo, String code) {
		super();
		ObtenerRegistrosAutoTasasPorEjecutivo = obtenerRegistrosAutoTasasPorEjecutivo;
		this.code = code;
	}
	public List<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO> getObtenerRegistrosAutoTasasPorEjecutivo() {
		return ObtenerRegistrosAutoTasasPorEjecutivo;
	}
	public void setObtenerRegistrosAutoTasasPorEjecutivo(
			List<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO> obtenerRegistrosAutoTasasPorEjecutivo) {
		ObtenerRegistrosAutoTasasPorEjecutivo = obtenerRegistrosAutoTasasPorEjecutivo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
