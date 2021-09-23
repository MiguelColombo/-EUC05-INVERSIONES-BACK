package com.citi.euces.solicitudes.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UEC_TB_AUTORANGOS")
public class Autorango implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="ID_RANGO" )
	private Long id_Rango;
	@Column(name ="RANGOMIN" )
	private Long RangoMin;
	@Column(name ="RANGOMAX" )
	private Long RangoMax;
	@Column(name ="MILL_DOSMILLQUIN" )
	private Long MILL_DOSMILLQUIN; //double
	@Column(name ="FECHA" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date FECHA;
	@Column(name ="FECHAFIN" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date FECHAFIN;
	/**
	 * @param id_Rsngo
	 * @param rangoMin
	 * @param rangoMax
	 * @param mILL_DOSMILLQUIN
	 * @param fECHA
	 * @param fECHAFIN
	 */
	public Autorango() {
		
	}
	/**
	 * @param id_Rango
	 * @param rangoMin
	 * @param rangoMax
	 * @param mILL_DOSMILLQUIN
	 * @param fECHA
	 * @param fECHAFIN
	 */
	public Autorango(Long id_Rango, Long rangoMin, Long rangoMax, Long mILL_DOSMILLQUIN, Date fECHA,
			Date fECHAFIN) {
		super();
		this.id_Rango = id_Rango;
		RangoMin = rangoMin;
		RangoMax = rangoMax;
		MILL_DOSMILLQUIN = mILL_DOSMILLQUIN;
		FECHA = fECHA;
		FECHAFIN = fECHAFIN;
	}
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
	public Long getMILL_DOSMILLQUIN() {
		return MILL_DOSMILLQUIN;
	}
	public void setMILL_DOSMILLQUIN(Long mILL_DOSMILLQUIN) {
		MILL_DOSMILLQUIN = mILL_DOSMILLQUIN;
	}
	public Date getFECHA() {
		return FECHA;
	}
	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}
	public Date getFECHAFIN() {
		return FECHAFIN;
	}
	public void setFECHAFIN(Date fECHAFIN) {
		FECHAFIN = fECHAFIN;
	}
	

}
