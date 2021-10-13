package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class PlantillaPdfDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String montoCliente;
	private List<InfoPdfEstandar> listaPdfEstan;
	private String nombreEjec;
	private String sucursal;
	private Long num_cli;
	private String nombreCliente;
	private Integer sirh;
	private Date fechaActual;
	private String parametroAviso;
	private String pdfEspecial;
	
	/**
	 * 
	 */
	public PlantillaPdfDTO() {
	}


	/**
	 * @param montoCliente
	 * @param listaPdfEstan
	 * @param nombreEjec
	 * @param sucursal
	 * @param num_cli
	 * @param nombreCliente
	 * @param sirh
	 * @param fechaActual
	 * @param parametroAviso
	 * @param pdfEspecial
	 */
	public PlantillaPdfDTO(String montoCliente, List<InfoPdfEstandar> listaPdfEstan, String nombreEjec,
			String sucursal, Long num_cli, String nombreCliente, Integer sirh, Date fechaActual,
			String parametroAviso, String pdfEspecial) {
		super();
		this.montoCliente = montoCliente;
		this.listaPdfEstan = listaPdfEstan;
		this.nombreEjec = nombreEjec;
		this.sucursal = sucursal;
		this.num_cli = num_cli;
		this.nombreCliente = nombreCliente;
		this.sirh = sirh;
		this.fechaActual = fechaActual;
		this.parametroAviso = parametroAviso;
		this.pdfEspecial = pdfEspecial;
	}


	/**
	 * @param parametroAviso
	 */
	public PlantillaPdfDTO(String parametroAviso) {
		super();
		this.parametroAviso = parametroAviso;
	}

	/**
	 * @return the montoCliente
	 */
	public String getMontoCliente() {
		return montoCliente;
	}

	/**
	 * @param montoCliente the montoCliente to set
	 */
	public void setMontoCliente(String montoCliente) {
		this.montoCliente = montoCliente;
	}

	/**
	 * @return the listaPdfEstan
	 */
	public List<InfoPdfEstandar> getListaPdfEstan() {
		return listaPdfEstan;
	}

	/**
	 * @param listaPdfEstan the listaPdfEstan to set
	 */
	public void setListaPdfEstan(List<InfoPdfEstandar> listaPdfEstan) {
		this.listaPdfEstan = listaPdfEstan;
	}

	/**
	 * @return the nombreEjec
	 */
	public String getNombreEjec() {
		return nombreEjec;
	}

	/**
	 * @param nombreEjec the nombreEjec to set
	 */
	public void setNombreEjec(String nombreEjec) {
		this.nombreEjec = nombreEjec;
	}

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the sirh
	 */
	public Integer getSirh() {
		return sirh;
	}

	/**
	 * @param sirh the sirh to set
	 */
	public void setSirh(Integer sirh) {
		this.sirh = sirh;
	}

	/**
	 * @return the fechaActual
	 */
	public Date getFechaActual() {
		return fechaActual;
	}

	/**
	 * @param fechaActual the fechaActual to set
	 */
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	/**
	 * @return the parametroAviso
	 */
	public String getParametroAviso() {
		return parametroAviso;
	}

	/**
	 * @param parametroAviso the parametroAviso to set
	 */
	public void setParametroAviso(String parametroAviso) {
		this.parametroAviso = parametroAviso;
	}

	
	/**
	 * @return the num_cli
	 */
	public Long getNum_cli() {
		return num_cli;
	}

	/**
	 * @param num_cli the num_cli to set
	 */
	public void setNum_cli(Long num_cli) {
		this.num_cli = num_cli;
	}


	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}


	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	/**
	 * @return the pdfEspecial
	 */
	public String getPdfEspecial() {
		return pdfEspecial;
	}


	/**
	 * @param pdfEspecial the pdfEspecial to set
	 */
	public void setPdfEspecial(String pdfEspecial) {
		this.pdfEspecial = pdfEspecial;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlantillaPdfDTO [montoCliente=");
		builder.append(montoCliente);
		builder.append(", listaPdfEstan=");
		builder.append(listaPdfEstan);
		builder.append(", nombreEjec=");
		builder.append(nombreEjec);
		builder.append(", sucursal=");
		builder.append(sucursal);
		builder.append(", num_cli=");
		builder.append(num_cli);
		builder.append(", nombreCliente=");
		builder.append(nombreCliente);
		builder.append(", sirh=");
		builder.append(sirh);
		builder.append(", fechaActual=");
		builder.append(fechaActual);
		builder.append(", parametroAviso=");
		builder.append(parametroAviso);
		builder.append(", pdfEspecial=");
		builder.append(pdfEspecial);
		builder.append("]");
		return builder.toString();
	}

}


