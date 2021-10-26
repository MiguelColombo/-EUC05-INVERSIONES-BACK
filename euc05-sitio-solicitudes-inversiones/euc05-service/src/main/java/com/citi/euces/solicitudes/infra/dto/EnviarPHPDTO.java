package com.citi.euces.solicitudes.infra.dto;

public class EnviarPHPDTO {
	
	private String soeidEnc;
	private String informeEnc;
	private String titleEnc;
	private String acountEnc;
	/**
	 * @param soeidEnc
	 * @param informeEnc
	 * @param titleEnc
	 * @param acountEnc
	 */
	

	public EnviarPHPDTO() {
		super();
	}
	public String getSoeidEnc() {
		return soeidEnc;
	}
	public void setSoeidEnc(String soeidEnc) {
		this.soeidEnc = soeidEnc;
	}
	public String getInformeEnc() {
		return informeEnc;
	}
	public void setInformeEnc(String informeEnc) {
		this.informeEnc = informeEnc;
	}
	public String getTitleEnc() {
		return titleEnc;
	}
	public void setTitleEnc(String titleEnc) {
		this.titleEnc = titleEnc;
	}
	public String getAcountEnc() {
		return acountEnc;
	}
	public void setAcountEnc(String acountEnc) {
		this.acountEnc = acountEnc;
	}
	
	
	

}
