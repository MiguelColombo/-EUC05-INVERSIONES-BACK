package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;

public class ConfigPdfDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pdfId;
	private String pdfNombre;
	private Integer pdfTipo;
	private String folioId;
	/**
	 * 
	 */
	public ConfigPdfDTO() {
		super();
	}
	/**
	 * @param pdfId
	 * @param pdfNombre
	 * @param pdfTipo
	 * @param folioId
	 */
	public ConfigPdfDTO(String pdfId, String pdfNombre, Integer pdfTipo, String folioId) {
		super();
		this.pdfId = pdfId;
		this.pdfNombre = pdfNombre;
		this.pdfTipo = pdfTipo;
		this.folioId = folioId;
	}
	/**
	 * @return the pdfId
	 */
	public String getPdfId() {
		return pdfId;
	}
	/**
	 * @param pdfId the pdfId to set
	 */
	public void setPdfId(String pdfId) {
		this.pdfId = pdfId;
	}
	/**
	 * @return the pdfNombre
	 */
	public String getPdfNombre() {
		return pdfNombre;
	}
	/**
	 * @param pdfNombre the pdfNombre to set
	 */
	public void setPdfNombre(String pdfNombre) {
		this.pdfNombre = pdfNombre;
	}
	/**
	 * @return the pdfTipo
	 */
	public Integer getPdfTipo() {
		return pdfTipo;
	}
	/**
	 * @param pdfTipo the pdfTipo to set
	 */
	public void setPdfTipo(Integer pdfTipo) {
		this.pdfTipo = pdfTipo;
	}
	/**
	 * @return the folioId
	 */
	public String getFolioId() {
		return folioId;
	}
	/**
	 * @param folioId the folioId to set
	 */
	public void setFolioId(String folioId) {
		this.folioId = folioId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfigPdfDTO [pdfId=");
		builder.append(pdfId);
		builder.append(", pdfNombre=");
		builder.append(pdfNombre);
		builder.append(", pdfTipo=");
		builder.append(pdfTipo);
		builder.append(", folioId=");
		builder.append(folioId);
		builder.append("]");
		return builder.toString();
	}


}