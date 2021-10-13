package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;
import java.sql.Date;

public class InfoPdfEstandar implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreOferta;
	private Double gatNominalOfer;
	private Double gatRealOfer;
	private String montoOfer;
	private Double tasaOfer;
	private int plazoOfer;
	private Double rendimientoBruto;
	private Date fechaActual;
	private Date fechaVigencia;
	
	/**
	 * @param nombreOferta
	 * @param gatNominalOfer
	 * @param gatRealOfer
	 * @param montoOfer
	 * @param tasaOfer
	 * @param plazoOfer
	 * @param rendimientoBruto
	 * @param fechaActual
	 * @param fechaVigencia
	 */
	public InfoPdfEstandar(String nombreOferta, Double gatNominalOfer, Double gatRealOfer, String montoOfer,
			Double tasaOfer, int plazoOfer, Double rendimientoBruto, Date fechaActual, Date fechaVigencia) {
		super();
		this.nombreOferta = nombreOferta;
		this.gatNominalOfer = gatNominalOfer;
		this.gatRealOfer = gatRealOfer;
		this.montoOfer = montoOfer;
		this.tasaOfer = tasaOfer;
		this.plazoOfer = plazoOfer;
		this.rendimientoBruto = rendimientoBruto;
		this.fechaActual = fechaActual;
		this.fechaVigencia = fechaVigencia;
	}
	/**
	 * 
	 */
	public InfoPdfEstandar() {
		super();
	}
	/**
	 * @return the nombreOferta
	 */
	public String getNombreOferta() {
		return nombreOferta;
	}
	/**
	 * @param nombreOferta the nombreOferta to set
	 */
	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}
	/**
	 * @return the gatNominalOfer
	 */
	public Double getGatNominalOfer() {
		return gatNominalOfer;
	}
	/**
	 * @param gatNominalOfer the gatNominalOfer to set
	 */
	public void setGatNominalOfer(Double gatNominalOfer) {
		this.gatNominalOfer = gatNominalOfer;
	}
	/**
	 * @return the gatRealOfer
	 */
	public Double getGatRealOfer() {
		return gatRealOfer;
	}
	/**
	 * @param gatRealOfer the gatRealOfer to set
	 */
	public void setGatRealOfer(Double gatRealOfer) {
		this.gatRealOfer = gatRealOfer;
	}
	/**
	 * @return the montoOfer
	 */
	public String getMontoOfer() {
		return montoOfer;
	}
	/**
	 * @param montoOfer the montoOfer to set
	 */
	public void setMontoOfer(String montoOfer) {
		this.montoOfer = montoOfer;
	}
	/**
	 * @return the tasaOfer
	 */
	public Double getTasaOfer() {
		return tasaOfer;
	}
	/**
	 * @param tasaOfer the tasaOfer to set
	 */
	public void setTasaOfer(Double tasaOfer) {
		this.tasaOfer = tasaOfer;
	}
	/**
	 * @return the plazoOfer
	 */
	public int getPlazoOfer() {
		return plazoOfer;
	}
	/**
	 * @param plazoOfer the plazoOfer to set
	 */
	public void setPlazoOfer(int plazoOfer) {
		this.plazoOfer = plazoOfer;
	}
	/**
	 * @return the rendimientoBruto
	 */
	public Double getRendimientoBruto() {
		return rendimientoBruto;
	}
	/**
	 * @param rendimientoBruto the rendimientoBruto to set
	 */
	public void setRendimientoBruto(Double rendimientoBruto) {
		this.rendimientoBruto = rendimientoBruto;
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
	 * @return the fechaVigencia
	 */
	public Date getFechaVigencia() {
		return fechaVigencia;
	}
	/**
	 * @param fechaVigencia the fechaVigencia to set
	 */
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InfoPdfEstandar [nombreOferta=");
		builder.append(nombreOferta);
		builder.append(", gatNominalOfer=");
		builder.append(gatNominalOfer);
		builder.append(", gatRealOfer=");
		builder.append(gatRealOfer);
		builder.append(", montoOfer=");
		builder.append(montoOfer);
		builder.append(", tasaOfer=");
		builder.append(tasaOfer);
		builder.append(", plazoOfer=");
		builder.append(plazoOfer);
		builder.append(", rendimientoBruto=");
		builder.append(rendimientoBruto);
		builder.append(", fechaActual=");
		builder.append(fechaActual);
		builder.append(", fechaVigencia=");
		builder.append(fechaVigencia);
		builder.append("]");
		return builder.toString();
	}
	
}

