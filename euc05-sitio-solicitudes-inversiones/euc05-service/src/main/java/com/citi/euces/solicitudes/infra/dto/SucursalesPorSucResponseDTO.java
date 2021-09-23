package com.citi.euces.solicitudes.infra.dto;

import java.math.BigInteger;

public class SucursalesPorSucResponseDTO {

	private String suc;
	private BigInteger NUMSUC;
	private String distrito;
	private Long IS_CLOSED;
	/**
	 * @param suc
	 * @param nUMSUC
	 * @param distrito
	 * @param iS_CLOSED
	 */
	public SucursalesPorSucResponseDTO(String suc, BigInteger nUMSUC, String distrito, Long iS_CLOSED) {
		super();
		this.suc = suc;
		NUMSUC = nUMSUC;
		this.distrito = distrito;
		IS_CLOSED = iS_CLOSED;
	}
	public String getSuc() {
		return suc;
	}
	public void setSuc(String suc) {
		this.suc = suc;
	}
	public BigInteger getNUMSUC() {
		return NUMSUC;
	}
	public void setNUMSUC(BigInteger nUMSUC) {
		NUMSUC = nUMSUC;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public Long getIS_CLOSED() {
		return IS_CLOSED;
	}
	public void setIS_CLOSED(Long iS_CLOSED) {
		IS_CLOSED = iS_CLOSED;
	}

	
	
	
}
