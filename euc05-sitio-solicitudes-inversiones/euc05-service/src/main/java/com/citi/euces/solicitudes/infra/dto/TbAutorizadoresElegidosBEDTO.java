package com.citi.euces.solicitudes.infra.dto;

public class TbAutorizadoresElegidosBEDTO {
	
	private Long id_TasaAuto;
	private String autorizadores;
	public Long getId_TasaAuto() {
		return id_TasaAuto;
	}
	public void setId_TasaAuto(Long id_TasaAuto) {
		this.id_TasaAuto = id_TasaAuto;
	}
	public String getAutorizadores() {
		return autorizadores;
	}
	public void setAutorizadores(String autorizadores) {
		this.autorizadores = autorizadores;
	}

}
