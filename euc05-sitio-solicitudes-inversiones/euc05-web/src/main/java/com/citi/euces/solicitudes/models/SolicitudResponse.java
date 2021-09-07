package com.citi.euces.solicitudes.models;

import java.io.Serializable;
import java.util.List;

import com.citi.euces.solicitudes.infra.dto.TipoSolicitudRespoceDTO;

public class SolicitudResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	private List<TipoSolicitudRespoceDTO> tipoSolicitud;
    private String code;
    
    
    
	/**
	 * @param tipoSolicitud
	 * @param code
	 */
	public SolicitudResponse(List<TipoSolicitudRespoceDTO> tipoSolicitud, String code) {
		super();
		this.tipoSolicitud = tipoSolicitud;
		this.code = code;
	}
	public List<TipoSolicitudRespoceDTO> getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(List<TipoSolicitudRespoceDTO> tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    
	/**
	 * @param tipoSolicitudRespoceDTO
	 * @param code
	 */
	
	

}
