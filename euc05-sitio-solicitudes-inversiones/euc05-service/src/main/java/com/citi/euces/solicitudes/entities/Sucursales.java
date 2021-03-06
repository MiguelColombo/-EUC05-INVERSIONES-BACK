package com.citi.euces.solicitudes.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_SUCURSALES") //PER_CAT_SUCURSALES || UEC_CAT_SUC2021
public class Sucursales {
	@Id
	@Column(name ="SIRH_SUCURSAL_ID" )
	private BigInteger SIRH;
	@Column(name ="DISTRITO_NOMBRE" )
	private String DITRITO;
	@Column(name ="NOMBRE_SUCURSAL" )
	private String SUCURSAL;
	@Column(name ="DIVISION_NOMBRE" )
	private String DIVISION;
	@Column(name ="IS_CLOSE" )
	private Long IS_CLOSED;
	
	/**
	 * @param sIRH
	 * @param dITRITO
	 * @param sUCURSAL
	 * @param dIVISION
	 * @param iS_CLOSED
	 */
	public Sucursales(BigInteger sIRH, String dITRITO, String sUCURSAL, String dIVISION, Long iS_CLOSED) {
		super();
		SIRH = sIRH;
		DITRITO = dITRITO;
		SUCURSAL = sUCURSAL;
		DIVISION = dIVISION;
		IS_CLOSED = iS_CLOSED;
	}
	public Sucursales() {
		
	}
	public BigInteger getSIRH() {
		return SIRH;
	}
	public void setSIRH(BigInteger sIRH) {
		SIRH = sIRH;
	}
	public String getDITRITO() {
		return DITRITO;
	}
	public void setDITRITO(String dITRITO) {
		DITRITO = dITRITO;
	}
	public String getSUCURSAL() {
		return SUCURSAL;
	}
	public void setSUCURSAL(String sUCURSAL) {
		SUCURSAL = sUCURSAL;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public Long getIS_CLOSED() {
		return IS_CLOSED;
	}
	public void setIS_CLOSED(Long iS_CLOSED) {
		IS_CLOSED = iS_CLOSED;
	}
	
	
	
}
