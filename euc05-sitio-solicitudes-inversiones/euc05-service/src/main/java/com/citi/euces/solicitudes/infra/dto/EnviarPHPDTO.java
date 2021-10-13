package com.citi.euces.solicitudes.infra.dto;

public class EnviarPHPDTO {
	
	private String Body;
	private String Param;
	/**
	 * @param body
	 * @param param
	 */
	public EnviarPHPDTO(String body, String param) {
		super();
		Body = body;
		Param = param;
	}
	/**
	 * 
	 */
	public EnviarPHPDTO() {
		super();
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public String getParam() {
		return Param;
	}
	public void setParam(String param) {
		Param = param;
	}
	
	

}
