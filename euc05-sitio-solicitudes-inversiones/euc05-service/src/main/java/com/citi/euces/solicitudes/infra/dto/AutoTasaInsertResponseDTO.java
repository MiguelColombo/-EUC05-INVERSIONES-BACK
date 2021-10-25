package com.citi.euces.solicitudes.infra.dto;

import java.math.BigInteger;

public class AutoTasaInsertResponseDTO {
	
	private String mensaje;
	private BigInteger id_TasaAuto;
	boolean enviarCorreo;
	
	
	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public BigInteger getId_TasaAuto() {
		return id_TasaAuto;
	}


	public void setId_TasaAuto(BigInteger id_TasaAuto) {
		this.id_TasaAuto = id_TasaAuto;
	}


	public boolean isEnviarCorreo() {
		return enviarCorreo;
	}


	public void setEnviarCorreo(boolean enviarCorreo) {
		this.enviarCorreo = enviarCorreo;
	}


	public AutoTasaInsertResponseDTO() {

	}
	
	

}
