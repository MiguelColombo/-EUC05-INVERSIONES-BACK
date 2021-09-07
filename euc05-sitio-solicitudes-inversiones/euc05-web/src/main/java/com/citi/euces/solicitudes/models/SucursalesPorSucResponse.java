package com.citi.euces.solicitudes.models;

import java.util.List;

import com.citi.euces.solicitudes.infra.dto.SucursalesPorSucResponseDTO;

public class SucursalesPorSucResponse {
	
	private List<SucursalesPorSucResponseDTO> sucursalesPorSuc;
    private String code;
	/**
	 * @param sucursalesPorSuc
	 * @param code
	 */
	public SucursalesPorSucResponse(List<SucursalesPorSucResponseDTO> sucursalesPorSuc, String code) {
		super();
		this.sucursalesPorSuc = sucursalesPorSuc;
		this.code = code;
	}
	public List<SucursalesPorSucResponseDTO> getSucursalesPorSuc() {
		return sucursalesPorSuc;
	}
	public void setSucursalesPorSuc(List<SucursalesPorSucResponseDTO> sucursalesPorSuc) {
		this.sucursalesPorSuc = sucursalesPorSuc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    

}
