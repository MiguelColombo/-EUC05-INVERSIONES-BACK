package com.citi.euces.solicitudes.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_EJECUTIVO_SUCURSAL")
public class EjecutivoSucursal {

	@Id
	@Column(name ="SOIED")
	private String SOIED;
	@Column(name ="NOMINA")
	private Long NOMINA;
	@Column(name ="SIRH_SUCURSAL")
	private Long SIRH_SUCURSAL;
	@Column(name ="SUCURSAL" )
	private String SUCURSAL;
	@Column(name ="DIVISION" )
	private String DIVISION;
	@Column(name ="DISTRITO")
	private String DISTRITO;
	
	/**
	 * 
	 */
	public EjecutivoSucursal() {
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
	public EjecutivoSucursal(String sOIED, Long nOMINA, Long sIRH_SUCURSAL, String sUCURSAL, String dIVISION,
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
