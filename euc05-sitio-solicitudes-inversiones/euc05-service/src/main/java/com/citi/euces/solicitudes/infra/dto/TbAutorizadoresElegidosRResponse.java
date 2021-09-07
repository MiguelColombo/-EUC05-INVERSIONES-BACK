package com.citi.euces.solicitudes.infra.dto;

public class TbAutorizadoresElegidosRResponse {
	private Integer id_TasaAuto;
	private String Autorizadores;
	
	
	/**
	 * @param id_TasaAuto
	 * @param autorizadores
	 */
	public TbAutorizadoresElegidosRResponse(Integer id_TasaAuto, String autorizadores) {
		super();
		this.id_TasaAuto = id_TasaAuto;
		Autorizadores = autorizadores;
	}
	public Integer getId_TasaAuto() {
		return id_TasaAuto;
	}
	public void setId_TasaAuto(Integer id_TasaAuto) {
		this.id_TasaAuto = id_TasaAuto;
	}
	public String getAutorizadores() {
		return Autorizadores;
	}
	public void setAutorizadores(String autorizadores) {
		Autorizadores = autorizadores;
	}

}
