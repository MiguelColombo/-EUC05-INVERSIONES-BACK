package com.citi.euces.solicitudes.models;

public class CalcularSoeidAsignadoResponse {

	private String soeidAsignado;
	private String code;
	/**
	 * @param soeidAsignado
	 * @param code
	 */
	public CalcularSoeidAsignadoResponse(String soeidAsignado, String code) {
		super();
		this.soeidAsignado = soeidAsignado;
		this.code = code;
	}
	public String getSoeidAsignado() {
		return soeidAsignado;
	}
	public void setSoeidAsignado(String soeidAsignado) {
		this.soeidAsignado = soeidAsignado;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
