package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;
import java.util.Date;



public class AutorangoResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	
	private Long id_Rango;
	private Long RangoMin;
	private Long RangoMax;
	private double MILL_DOSMILLQUIN; //double
	private String FECHA;
	private String FECHAFIN;
	/**
	 * @param id_Rango
	 * @param rangoMin
	 * @param rangoMax
	 * @param mILL_DOSMILLQUIN
	 * @param fECHA
	 * @param fECHAFIN
	 */

	public Long getId_Rango() {
		return id_Rango;
	}
	public void setId_Rango(Long id_Rango) {
		this.id_Rango = id_Rango;
	}
	public Long getRangoMin() {
		return RangoMin;
	}
	public void setRangoMin(Long rangoMin) {
		RangoMin = rangoMin;
	}
	public Long getRangoMax() {
		return RangoMax;
	}
	public void setRangoMax(Long rangoMax) {
		RangoMax = rangoMax;
	}
	public double getMILL_DOSMILLQUIN() {
		return MILL_DOSMILLQUIN;
	}
	public void setMILL_DOSMILLQUIN(double mILL_DOSMILLQUIN) {
		MILL_DOSMILLQUIN = mILL_DOSMILLQUIN;
	}
	public String getFECHA() {
		return FECHA;
	}
	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}
	public String getFECHAFIN() {
		return FECHAFIN;
	}
	public void setFECHAFIN(String fECHAFIN) {
		FECHAFIN = fECHAFIN;
	}
	
	
}
