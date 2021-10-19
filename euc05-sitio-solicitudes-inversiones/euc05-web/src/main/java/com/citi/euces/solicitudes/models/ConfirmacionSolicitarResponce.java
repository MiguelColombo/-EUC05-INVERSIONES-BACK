package com.citi.euces.solicitudes.models;

public class ConfirmacionSolicitarResponce {
	
	private String mensaje;
	private String code;
	private boolean enviarCorreo;
	/**
	 * @param mensaje
	 * @param code
	 * @param enviarCorreo
	 */
	public ConfirmacionSolicitarResponce(String mensaje, String code, boolean enviarCorreo) {
		super();
		this.mensaje = mensaje;
		this.code = code;
		this.enviarCorreo = enviarCorreo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isEnviarCorreo() {
		return enviarCorreo;
	}
	public void setEnviarCorreo(boolean enviarCorreo) {
		this.enviarCorreo = enviarCorreo;
	}
	
	

}
