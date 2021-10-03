package com.citi.euces.solicitudes.models;

public class EnviarPHPResponse {
	
	private String body;
	private String code;
	/**
	 * @param body
	 * @param code
	 */
	public EnviarPHPResponse(String body, String code) {
		super();
		this.body = body;
		this.code = code;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
