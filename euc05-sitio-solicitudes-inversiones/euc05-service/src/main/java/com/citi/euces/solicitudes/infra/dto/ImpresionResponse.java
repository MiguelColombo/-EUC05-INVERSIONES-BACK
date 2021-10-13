package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;

public class ImpresionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String archivo;
	private String tipo_pdf_especial;
	private String code;
	/**
	 * 
	 */
	public ImpresionResponse() {
		super();
	}
	/**
	 * @return the archivo
	 */
	public String getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the tipo_pdf_especial
	 */
	public String getTipo_pdf_especial() {
		return tipo_pdf_especial;
	}
	/**
	 * @param tipo_pdf_especial the tipo_pdf_especial to set
	 */
	public void setTipo_pdf_especial(String tipo_pdf_especial) {
		this.tipo_pdf_especial = tipo_pdf_especial;
	}
	
	
}