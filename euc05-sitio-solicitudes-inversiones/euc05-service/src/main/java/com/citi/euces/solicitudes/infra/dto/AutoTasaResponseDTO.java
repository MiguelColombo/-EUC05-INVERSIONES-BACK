package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class AutoTasaResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

	private BigInteger ID_TASAUTO;
	private String FECHA_SOLIC;
	private String FECHA_ESTATUS;
	private String FECHA_PROCESS;
	private String ESTATUS;
	private Long SUC_SOLIC;
	private String DIVISION;
	private BigInteger NUM_CTE;
	private String  NOM_CTE; 
	private BigInteger CONTRATO;
	private String NOMINA;
	private String NOMEJEC;
	private BigInteger  MONTO;
	private Long PLAZO;
	private Long TASA_AUTORI;
	private Long NUM_AUTORI_UEC;
	private String OBSERVA_WEB;
	private String JUSTIFICACION;
	private String TIPO_AUTORI;
	private String SOEID_ASIG;
	private String SOEID_PROC;
	private String SOEID_OPE;
	private Long IS_PROCESS;
	/**
	 * @param iD_TASAUTO
	 * @param fECHA_SOLIC
	 * @param fECHA_ESTATUS
	 * @param fECHA_PROCESS
	 * @param eSTATUS
	 * @param sUC_SOLIC
	 * @param dIVISION
	 * @param nUM_CTE
	 * @param nOM_CTE
	 * @param cONTRATO
	 * @param nOMINA
	 * @param nOMEJEC
	 * @param mONTO
	 * @param pLAZO
	 * @param tASA_AUTORI
	 * @param nUM_AUTORI_UEC
	 * @param oBSERVA_WEB
	 * @param jUSTIFICACION
	 * @param tIPO_AUTORI
	 * @param sOEID_ASIG
	 * @param sOEID_PROC
	 * @param sOEID_OPE
	 * @param iS_PROCESS
	 */
	public AutoTasaResponseDTO(BigInteger iD_TASAUTO, String fECHA_SOLIC, String fECHA_ESTATUS,
			String fECHA_PROCESS, String eSTATUS, Long sUC_SOLIC, String dIVISION, BigInteger nUM_CTE, String nOM_CTE,
			BigInteger cONTRATO, String nOMINA, String nOMEJEC, BigInteger mONTO, Long pLAZO, Long tASA_AUTORI,
			Long nUM_AUTORI_UEC, String oBSERVA_WEB, String jUSTIFICACION, String tIPO_AUTORI, String sOEID_ASIG,
			String sOEID_PROC, String sOEID_OPE, Long iS_PROCESS) {
		super();
		ID_TASAUTO = iD_TASAUTO;
		FECHA_SOLIC = fECHA_SOLIC;
		FECHA_ESTATUS = fECHA_ESTATUS;
		FECHA_PROCESS = fECHA_PROCESS;
		ESTATUS = eSTATUS;
		SUC_SOLIC = sUC_SOLIC;
		DIVISION = dIVISION;
		NUM_CTE = nUM_CTE;
		NOM_CTE = nOM_CTE;
		CONTRATO = cONTRATO;
		NOMINA = nOMINA;
		NOMEJEC = nOMEJEC;
		MONTO = mONTO;
		PLAZO = pLAZO;
		TASA_AUTORI = tASA_AUTORI;
		NUM_AUTORI_UEC = nUM_AUTORI_UEC;
		OBSERVA_WEB = oBSERVA_WEB;
		JUSTIFICACION = jUSTIFICACION;
		TIPO_AUTORI = tIPO_AUTORI;
		SOEID_ASIG = sOEID_ASIG;
		SOEID_PROC = sOEID_PROC;
		SOEID_OPE = sOEID_OPE;
		IS_PROCESS = iS_PROCESS;
	}
	public BigInteger getID_TASAUTO() {
		return ID_TASAUTO;
	}
	public void setID_TASAUTO(BigInteger iD_TASAUTO) {
		ID_TASAUTO = iD_TASAUTO;
	}
	public String getFECHA_SOLIC() {
		return FECHA_SOLIC;
	}
	public void setFECHA_SOLIC(String fECHA_SOLIC) {
		FECHA_SOLIC = fECHA_SOLIC;
	}
	public String getFECHA_ESTATUS() {
		return FECHA_ESTATUS;
	}
	public void setFECHA_ESTATUS(String fECHA_ESTATUS) {
		FECHA_ESTATUS = fECHA_ESTATUS;
	}
	public String getFECHA_PROCESS() {
		return FECHA_PROCESS;
	}
	public void setFECHA_PROCESS(String fECHA_PROCESS) {
		FECHA_PROCESS = fECHA_PROCESS;
	}
	public String getESTATUS() {
		return ESTATUS;
	}
	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}
	public Long getSUC_SOLIC() {
		return SUC_SOLIC;
	}
	public void setSUC_SOLIC(Long sUC_SOLIC) {
		SUC_SOLIC = sUC_SOLIC;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public BigInteger getNUM_CTE() {
		return NUM_CTE;
	}
	public void setNUM_CTE(BigInteger nUM_CTE) {
		NUM_CTE = nUM_CTE;
	}
	public String getNOM_CTE() {
		return NOM_CTE;
	}
	public void setNOM_CTE(String nOM_CTE) {
		NOM_CTE = nOM_CTE;
	}
	public BigInteger getCONTRATO() {
		return CONTRATO;
	}
	public void setCONTRATO(BigInteger cONTRATO) {
		CONTRATO = cONTRATO;
	}
	public String getNOMINA() {
		return NOMINA;
	}
	public void setNOMINA(String nOMINA) {
		NOMINA = nOMINA;
	}
	public String getNOMEJEC() {
		return NOMEJEC;
	}
	public void setNOMEJEC(String nOMEJEC) {
		NOMEJEC = nOMEJEC;
	}
	public BigInteger getMONTO() {
		return MONTO;
	}
	public void setMONTO(BigInteger mONTO) {
		MONTO = mONTO;
	}
	public Long getPLAZO() {
		return PLAZO;
	}
	public void setPLAZO(Long pLAZO) {
		PLAZO = pLAZO;
	}
	public Long getTASA_AUTORI() {
		return TASA_AUTORI;
	}
	public void setTASA_AUTORI(Long tASA_AUTORI) {
		TASA_AUTORI = tASA_AUTORI;
	}
	public Long getNUM_AUTORI_UEC() {
		return NUM_AUTORI_UEC;
	}
	public void setNUM_AUTORI_UEC(Long nUM_AUTORI_UEC) {
		NUM_AUTORI_UEC = nUM_AUTORI_UEC;
	}
	public String getOBSERVA_WEB() {
		return OBSERVA_WEB;
	}
	public void setOBSERVA_WEB(String oBSERVA_WEB) {
		OBSERVA_WEB = oBSERVA_WEB;
	}
	public String getJUSTIFICACION() {
		return JUSTIFICACION;
	}
	public void setJUSTIFICACION(String jUSTIFICACION) {
		JUSTIFICACION = jUSTIFICACION;
	}
	public String getTIPO_AUTORI() {
		return TIPO_AUTORI;
	}
	public void setTIPO_AUTORI(String tIPO_AUTORI) {
		TIPO_AUTORI = tIPO_AUTORI;
	}
	public String getSOEID_ASIG() {
		return SOEID_ASIG;
	}
	public void setSOEID_ASIG(String sOEID_ASIG) {
		SOEID_ASIG = sOEID_ASIG;
	}
	public String getSOEID_PROC() {
		return SOEID_PROC;
	}
	public void setSOEID_PROC(String sOEID_PROC) {
		SOEID_PROC = sOEID_PROC;
	}
	public String getSOEID_OPE() {
		return SOEID_OPE;
	}
	public void setSOEID_OPE(String sOEID_OPE) {
		SOEID_OPE = sOEID_OPE;
	}
	public Long getIS_PROCESS() {
		return IS_PROCESS;
	}
	public void setIS_PROCESS(Long iS_PROCESS) {
		IS_PROCESS = iS_PROCESS;
	}
	
	
}
