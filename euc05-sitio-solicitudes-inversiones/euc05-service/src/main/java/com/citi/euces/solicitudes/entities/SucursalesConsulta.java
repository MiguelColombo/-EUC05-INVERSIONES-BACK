package com.citi.euces.solicitudes.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_CAT_SUC2021") //PER_CAT_SUCURSALES || UEC_CAT_SUC2021
public class SucursalesConsulta {
	@Id
	@Column(name ="SIRH" , nullable=false)
	private BigInteger SIRH;
	@Column(name ="SUCURSAL", nullable=false )
	private String SUCURSAL;
	@Column(name ="CODDIV", nullable=false )
	private BigInteger CODDIV;
	@Column(name ="DIVISION" , nullable=false)
	private String DIVISION;
	@Column(name ="CODDIST" , nullable=false)
	private BigInteger CODDIST;
	@Column(name ="DISTRITO", nullable=false )
	private String DISTRITO;
	@Column(name ="EJECUTIVOS" , nullable=false)
	private Long EJECUTIVOS;
	@Column(name ="EJECUTIVOS_PRIORITY" , nullable=false)
	private Long EJECUTIVOS_PRIORITY;
	@Column(name ="IS_CLOSED" , nullable=false)
	private Long IS_CLOSED;
	/**
	 * @param sIRH
	 * @param sUCURSAL
	 * @param cODDIV
	 * @param dIVISION
	 * @param cODDIST
	 * @param dISTRITO
	 * @param eJECUTIVOS
	 * @param eJECUTIVOS_PRIORITY
	 * @param iS_CLOSED
	 */
	public SucursalesConsulta(BigInteger sIRH, String sUCURSAL, BigInteger cODDIV, String dIVISION, BigInteger cODDIST,
			String dISTRITO, Long eJECUTIVOS, Long eJECUTIVOS_PRIORITY, Long iS_CLOSED) {
		super();
		SIRH = sIRH;
		SUCURSAL = sUCURSAL;
		CODDIV = cODDIV;
		DIVISION = dIVISION;
		CODDIST = cODDIST;
		DISTRITO = dISTRITO;
		EJECUTIVOS = eJECUTIVOS;
		EJECUTIVOS_PRIORITY = eJECUTIVOS_PRIORITY;
		IS_CLOSED = iS_CLOSED;
	}
	/**
	 * 
	 */
	public SucursalesConsulta() {
		super();
	}
	public BigInteger getSIRH() {
		return SIRH;
	}
	public void setSIRH(BigInteger sIRH) {
		SIRH = sIRH;
	}
	public String getSUCURSAL() {
		return SUCURSAL;
	}
	public void setSUCURSAL(String sUCURSAL) {
		SUCURSAL = sUCURSAL;
	}
	public BigInteger getCODDIV() {
		return CODDIV;
	}
	public void setCODDIV(BigInteger cODDIV) {
		CODDIV = cODDIV;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public BigInteger getCODDIST() {
		return CODDIST;
	}
	public void setCODDIST(BigInteger cODDIST) {
		CODDIST = cODDIST;
	}
	public String getDISTRITO() {
		return DISTRITO;
	}
	public void setDISTRITO(String dISTRITO) {
		DISTRITO = dISTRITO;
	}
	public Long getEJECUTIVOS() {
		return EJECUTIVOS;
	}
	public void setEJECUTIVOS(Long eJECUTIVOS) {
		EJECUTIVOS = eJECUTIVOS;
	}
	public Long getEJECUTIVOS_PRIORITY() {
		return EJECUTIVOS_PRIORITY;
	}
	public void setEJECUTIVOS_PRIORITY(Long eJECUTIVOS_PRIORITY) {
		EJECUTIVOS_PRIORITY = eJECUTIVOS_PRIORITY;
	}
	public Long getIS_CLOSED() {
		return IS_CLOSED;
	}
	public void setIS_CLOSED(Long iS_CLOSED) {
		IS_CLOSED = iS_CLOSED;
	}
	
	
	
}
