package com.citi.euces.solicitudes.models;

import java.io.Serializable;

import com.citi.euces.solicitudes.infra.dto.ImpresionResponse;

public class SoImprimeRespon implements Serializable {
    private static final long serialVersionUID = 1L;

	private ImpresionResponse pdf;
    private String code;
	/**
	 * @param pdf
	 * @param code
	 */
	public SoImprimeRespon(ImpresionResponse pdf, String code) {
		super();
		this.pdf = pdf;
		this.code = code;
	}
	/**
	 * 
	 */
	public SoImprimeRespon() {
		super();
	}
	/**
	 * @return the pdf
	 */
	public ImpresionResponse getPdf() {
		return pdf;
	}
	/**
	 * @param pdf the pdf to set
	 */
	public void setPdf(ImpresionResponse pdf) {
		this.pdf = pdf;
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
	
    
    
}
