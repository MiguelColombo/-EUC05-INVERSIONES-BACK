package com.citi.euces.solicitudes.infra.dto;

import java.math.BigInteger;


public class SucursalesConsultaResponseDTO {
	
	private BigInteger SIRH;
	private String SUCURSAL;
	private BigInteger CODDIV;
	private String DIVISION;
	private BigInteger CODDIST;
	private String DISTRITO;
	private Long EJECUTIVOS;
	private Long EJECUTIVOS_PRIORITY;
	private Long IS_CLOSED;
	/**
	 * 
	 */
	public SucursalesConsultaResponseDTO() {
		super();
	}
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
	public SucursalesConsultaResponseDTO(BigInteger sIRH, String sUCURSAL, BigInteger cODDIV, String dIVISION,
			BigInteger cODDIST, String dISTRITO, Long eJECUTIVOS, Long eJECUTIVOS_PRIORITY, Long iS_CLOSED) {
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
