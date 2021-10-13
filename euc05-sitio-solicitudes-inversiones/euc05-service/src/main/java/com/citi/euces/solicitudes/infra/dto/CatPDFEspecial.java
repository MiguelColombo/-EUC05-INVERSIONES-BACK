package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;
import java.nio.file.Path;

public class CatPDFEspecial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idPdfEspecial;
	private Path archivo;
	private String nombrePdfEspecial;
	/**
	 * 
	 */
	public CatPDFEspecial() {
		super();
	}
	/**
	 * @param idPdfEspecial
	 * @param archivo
	 * @param nombrePdfEspecial
	 */
	public CatPDFEspecial(String idPdfEspecial, Path archivo, String nombrePdfEspecial) {
		super();
		this.idPdfEspecial = idPdfEspecial;
		this.archivo = archivo;
		this.nombrePdfEspecial = nombrePdfEspecial;
	}
	/**
	 * @return the idPdfEspecial
	 */
	public String getIdPdfEspecial() {
		return idPdfEspecial;
	}
	/**
	 * @param idPdfEspecial the idPdfEspecial to set
	 */
	public void setIdPdfEspecial(String idPdfEspecial) {
		this.idPdfEspecial = idPdfEspecial;
	}
	/**
	 * @return the archivo
	 */
	public Path getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(Path archivo) {
		this.archivo = archivo;
	}
	/**
	 * @return the nombrePdfEspecial
	 */
	public String getNombrePdfEspecial() {
		return nombrePdfEspecial;
	}
	/**
	 * @param nombrePdfEspecial the nombrePdfEspecial to set
	 */
	public void setNombrePdfEspecial(String nombrePdfEspecial) {
		this.nombrePdfEspecial = nombrePdfEspecial;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CatPDFEspecial [idPdfEspecial=");
		builder.append(idPdfEspecial);
		builder.append(", archivo=");
		builder.append(archivo);
		builder.append(", nombrePdfEspecial=");
		builder.append(nombrePdfEspecial);
		builder.append("]");
		return builder.toString();
	}
	
	
}
