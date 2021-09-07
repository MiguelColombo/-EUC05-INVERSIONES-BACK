package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.ObtenerAutoDivisionalResposeDTO;

public class ObtenerAutoDivisionalRespose {
	
	private List<ObtenerAutoDivisionalResposeDTO> ObtenerAutoDivisional;
	private String code;
	/**
	 * @param obtenerAutoDivisional
	 * @param code
	 */
	public ObtenerAutoDivisionalRespose(List<ObtenerAutoDivisionalResposeDTO> obtenerAutoDivisional, String code) {
		super();
		ObtenerAutoDivisional = obtenerAutoDivisional;
		this.code = code;
	}
	public List<ObtenerAutoDivisionalResposeDTO> getObtenerAutoDivisional() {
		return ObtenerAutoDivisional;
	}
	public void setObtenerAutoDivisional(List<ObtenerAutoDivisionalResposeDTO> obtenerAutoDivisional) {
		ObtenerAutoDivisional = obtenerAutoDivisional;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
