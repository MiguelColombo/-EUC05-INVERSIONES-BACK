package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.TasaPorsentajeResponceDTO;

public class TasaPorsentajeResponce 
{
	private List<TasaPorsentajeResponceDTO> tasaPorsentaje;
    private String code;
	/**
	 * @param tasaPorsentaje
	 * @param code
	 */
	public TasaPorsentajeResponce(List<TasaPorsentajeResponceDTO> tasaPorsentaje, String code) {
		super();
		this.tasaPorsentaje = tasaPorsentaje;
		this.code = code;
	}
	public List<TasaPorsentajeResponceDTO> getTasaPorsentaje() {
		return tasaPorsentaje;
	}
	public void setTasaPorsentaje(List<TasaPorsentajeResponceDTO> tasaPorsentaje) {
		this.tasaPorsentaje = tasaPorsentaje;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    
}
