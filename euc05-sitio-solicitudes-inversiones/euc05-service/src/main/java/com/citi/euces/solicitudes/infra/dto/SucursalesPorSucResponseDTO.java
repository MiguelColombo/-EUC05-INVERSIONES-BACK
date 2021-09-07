package com.citi.euces.solicitudes.infra.dto;

public class SucursalesPorSucResponseDTO {

	private String suc;
	private Long NUMSUC;
	private String distrito;
	private Long IS_CLOSED;
	/**
	 * @param suc
	 * @param nUMSUC
	 * @param distrito
	 * @param iS_CLOSED
	 */
	public SucursalesPorSucResponseDTO(String suc, Long nUMSUC, String distrito, Long iS_CLOSED) {
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
	public Long getNUMSUC() {
		return NUMSUC;
	}
	public void setNUMSUC(Long nUMSUC) {
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
