package com.citi.euces.solicitudes.infra.dto;



public class EjecutivoSucursalResponseDTO {
	
	private String SOIED;
	private Long NOMINA;
	private Long SIRH_SUCURSAL;
	private String SUCURSAL;
	private String DIVISION;
	private String DISTRITO;
	
	/**
	 * 
	 */
	public EjecutivoSucursalResponseDTO() {
		super();
	}

	/**
	 * @param sOIED
	 * @param nOMINA
	 * @param sIRH_SUCURSAL
	 * @param sUCURSAL
	 * @param dIVISION
	 * @param dISTRITO
	 */
	public EjecutivoSucursalResponseDTO(String sOIED, Long nOMINA, Long sIRH_SUCURSAL, String sUCURSAL, String dIVISION,
			String dISTRITO) {
		super();
		SOIED = sOIED;
		NOMINA = nOMINA;
		SIRH_SUCURSAL = sIRH_SUCURSAL;
		SUCURSAL = sUCURSAL;
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
	}

	public String getSOIED() {
		return SOIED;
	}

	public void setSOIED(String sOIED) {
		SOIED = sOIED;
	}

	public Long getNOMINA() {
		return NOMINA;
	}

	public void setNOMINA(Long nOMINA) {
		NOMINA = nOMINA;
	}

	public Long getSIRH_SUCURSAL() {
		return SIRH_SUCURSAL;
	}

	public void setSIRH_SUCURSAL(Long sIRH_SUCURSAL) {
		SIRH_SUCURSAL = sIRH_SUCURSAL;
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

	public String getDISTRITO() {
		return DISTRITO;
	}

	public void setDISTRITO(String dISTRITO) {
		DISTRITO = dISTRITO;
	}
	
}
