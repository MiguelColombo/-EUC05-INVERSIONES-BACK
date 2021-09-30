package com.citi.euces.solicitudes.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UEC_TB_AUTOTASAS")
public class AutoTasa implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name ="ID_TASAUTO")
	private BigInteger ID_TASAUTO;
	@Column(name ="FECHA_SOLIC")
	private Timestamp  FECHA_SOLIC;
    @Column(name ="FECHA_AUTORI")
	private Timestamp  FECHA_AUTORI;
    @Column(name ="FECHA_PROCESS")
	private Timestamp  FECHA_PROCESS;
    @Column(name ="FECHA_ESTATUS")
	private Timestamp  FECHA_ESTATUS;
    @Column(name ="IS_PROCESS")
	private Long IS_PROCESS;
    @Column(name ="ESTATUS")
	private String ESTATUS;
    @Column(name ="SUC_SOLIC")
	private Long SUC_SOLIC;
    @Column(name ="DIVISION")
	private String DIVISION;
    @Column(name ="NUM_CTE")
	private BigInteger NUM_CTE;
    @Column(name ="NOM_CTE")
	private String NOM_CTE;
    @Column(name ="CONTRATO")
	private BigInteger CONTRATO;
    @Column(name ="NOMINA")
	private String NOMINA;
    @Column(name ="NOMEJEC")
	private String NOMEJEC;
    @Column(name ="MONTO")
	private Long MONTO;
    @Column(name ="PLAZO")
	private Long PLAZO;
    @Column(name ="TASA_AUTORI")
	private Long TASA_AUTORI;
    @Column(name ="TIPO_AUTORI")
	private String TIPO_AUTORI;
    @Column(name ="SOEID_AUTORI")
	private String SOEID_AUTORI;
    @Column(name ="INIC_AUTORI")
	private String INIC_AUTORI;
    @Column(name ="NUM_AUTORI_UEC")
	private Long NUM_AUTORI_UEC;
    @Column(name ="SOEID_ASIG")
	private String SOEID_ASIG;
    @Column(name ="SOEID_PROC")
	private String SOEID_PROC;
    @Column(name ="SOEID_OPE")
	private String SOEID_OPE;
    @Column(name ="CETE")
	private Long CETE;
    @Column(name ="PORCEN_CETE")
	private String PORCEN_CETE;
    @Column(name ="OBSERVA_WEB")
	private String OBSERVA_WEB;
    @Column(name ="JUSTIFICACION")
	private String JUSTIFICACION;
    @Column(name ="CEL")
	private String CEL;
    @Column(name ="T_PER")
	private Long T_PER;
    @Column(name ="FECHA_SOLIC_CANCEL")
	private Timestamp FECHA_SOLIC_CANCEL;
    @Column(name ="NOMINA_CANCEL")
	private String NOMINA_CANCEL;
    @Column(name ="NOMEJEC_CANCEL")
	private String NOMEJEC_CANCEL;
    @Column(name ="JUSTIFICACION_CANCEL")
	private String JUSTIFICACION_CANCEL;
    @Column(name ="REINVERSION")
	private String REINVERSION;
    @Column(name ="IS_CUENTA_MAESTRA")
	private Long IS_CUENTA_MAESTRA;
    @Column(name ="IS_PORTABILIDAD")
	private String IS_PORTABILIDAD;
    @Column(name ="EMAIL")
	private String EMAIL;
	@Column(name ="AUTORIZADORES" )
	private String AUTORIZADORES;


	public AutoTasa() {
		
	}


	/**
	 * @param iD_TASAUTO
	 * @param fECHA_SOLIC
	 * @param fECHA_AUTORI
	 * @param fECHA_PROCESS
	 * @param fECHA_ESTATUS
	 * @param iS_PROCESS
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
	 * @param tIPO_AUTORI
	 * @param sOEID_AUTORI
	 * @param iNIC_AUTORI
	 * @param nUM_AUTORI_UEC
	 * @param sOEID_ASIG
	 * @param sOEID_PROC
	 * @param sOEID_OPE
	 * @param cETE
	 * @param pORCEN_CETE
	 * @param oBSERVA_WEB
	 * @param jUSTIFICACION
	 * @param cEL
	 * @param t_PER
	 * @param fECHA_SOLIC_CANCEL
	 * @param nOMINA_CANCEL
	 * @param nOMEJEC_CANCEL
	 * @param jUSTIFICACION_CANCEL
	 * @param rEINVERSION
	 * @param iS_CUENTA_MAESTRA
	 * @param iS_PORTABILIDAD
	 * @param eMAIL
	 * @param aUTORIZADORES
	 */
	public AutoTasa(BigInteger iD_TASAUTO, Timestamp fECHA_SOLIC, Timestamp fECHA_AUTORI, Timestamp fECHA_PROCESS,
			Timestamp fECHA_ESTATUS, Long iS_PROCESS, String eSTATUS, Long sUC_SOLIC, String dIVISION,
			BigInteger nUM_CTE, String nOM_CTE, BigInteger cONTRATO, String nOMINA, String nOMEJEC, Long mONTO,
			Long pLAZO, Long tASA_AUTORI, String tIPO_AUTORI, String sOEID_AUTORI, String iNIC_AUTORI,
			Long nUM_AUTORI_UEC, String sOEID_ASIG, String sOEID_PROC, String sOEID_OPE, Long cETE, String pORCEN_CETE,
			String oBSERVA_WEB, String jUSTIFICACION, String cEL, Long t_PER, Timestamp fECHA_SOLIC_CANCEL,
			String nOMINA_CANCEL, String nOMEJEC_CANCEL, String jUSTIFICACION_CANCEL, String rEINVERSION,
			Long iS_CUENTA_MAESTRA, String iS_PORTABILIDAD, String eMAIL, String aUTORIZADORES) {
		super();
		ID_TASAUTO = iD_TASAUTO;
		FECHA_SOLIC = fECHA_SOLIC;
		FECHA_AUTORI = fECHA_AUTORI;
		FECHA_PROCESS = fECHA_PROCESS;
		FECHA_ESTATUS = fECHA_ESTATUS;
		IS_PROCESS = iS_PROCESS;
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
		TIPO_AUTORI = tIPO_AUTORI;
		SOEID_AUTORI = sOEID_AUTORI;
		INIC_AUTORI = iNIC_AUTORI;
		NUM_AUTORI_UEC = nUM_AUTORI_UEC;
		SOEID_ASIG = sOEID_ASIG;
		SOEID_PROC = sOEID_PROC;
		SOEID_OPE = sOEID_OPE;
		CETE = cETE;
		PORCEN_CETE = pORCEN_CETE;
		OBSERVA_WEB = oBSERVA_WEB;
		JUSTIFICACION = jUSTIFICACION;
		CEL = cEL;
		T_PER = t_PER;
		FECHA_SOLIC_CANCEL = fECHA_SOLIC_CANCEL;
		NOMINA_CANCEL = nOMINA_CANCEL;
		NOMEJEC_CANCEL = nOMEJEC_CANCEL;
		JUSTIFICACION_CANCEL = jUSTIFICACION_CANCEL;
		REINVERSION = rEINVERSION;
		IS_CUENTA_MAESTRA = iS_CUENTA_MAESTRA;
		IS_PORTABILIDAD = iS_PORTABILIDAD;
		EMAIL = eMAIL;
		AUTORIZADORES = aUTORIZADORES;
	}


	public BigInteger getID_TASAUTO() {
		return ID_TASAUTO;
	}


	public void setID_TASAUTO(BigInteger iD_TASAUTO) {
		ID_TASAUTO = iD_TASAUTO;
	}


	public Timestamp getFECHA_SOLIC() {
		return FECHA_SOLIC;
	}


	public void setFECHA_SOLIC(Timestamp fECHA_SOLIC) {
		FECHA_SOLIC = fECHA_SOLIC;
	}


	public Timestamp getFECHA_AUTORI() {
		return FECHA_AUTORI;
	}


	public void setFECHA_AUTORI(Timestamp fECHA_AUTORI) {
		FECHA_AUTORI = fECHA_AUTORI;
	}


	public Timestamp getFECHA_PROCESS() {
		return FECHA_PROCESS;
	}


	public void setFECHA_PROCESS(Timestamp fECHA_PROCESS) {
		FECHA_PROCESS = fECHA_PROCESS;
	}


	public Timestamp getFECHA_ESTATUS() {
		return FECHA_ESTATUS;
	}


	public void setFECHA_ESTATUS(Timestamp fECHA_ESTATUS) {
		FECHA_ESTATUS = fECHA_ESTATUS;
	}


	public Long getIS_PROCESS() {
		return IS_PROCESS;
	}


	public void setIS_PROCESS(Long iS_PROCESS) {
		IS_PROCESS = iS_PROCESS;
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


	public Long getMONTO() {
		return MONTO;
	}


	public void setMONTO(Long mONTO) {
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


	public String getTIPO_AUTORI() {
		return TIPO_AUTORI;
	}


	public void setTIPO_AUTORI(String tIPO_AUTORI) {
		TIPO_AUTORI = tIPO_AUTORI;
	}


	public String getSOEID_AUTORI() {
		return SOEID_AUTORI;
	}


	public void setSOEID_AUTORI(String sOEID_AUTORI) {
		SOEID_AUTORI = sOEID_AUTORI;
	}


	public String getINIC_AUTORI() {
		return INIC_AUTORI;
	}


	public void setINIC_AUTORI(String iNIC_AUTORI) {
		INIC_AUTORI = iNIC_AUTORI;
	}


	public Long getNUM_AUTORI_UEC() {
		return NUM_AUTORI_UEC;
	}


	public void setNUM_AUTORI_UEC(Long nUM_AUTORI_UEC) {
		NUM_AUTORI_UEC = nUM_AUTORI_UEC;
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


	public Long getCETE() {
		return CETE;
	}


	public void setCETE(Long cETE) {
		CETE = cETE;
	}


	public String getPORCEN_CETE() {
		return PORCEN_CETE;
	}


	public void setPORCEN_CETE(String pORCEN_CETE) {
		PORCEN_CETE = pORCEN_CETE;
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


	public String getCEL() {
		return CEL;
	}


	public void setCEL(String cEL) {
		CEL = cEL;
	}


	public Long getT_PER() {
		return T_PER;
	}


	public void setT_PER(Long t_PER) {
		T_PER = t_PER;
	}


	public Timestamp getFECHA_SOLIC_CANCEL() {
		return FECHA_SOLIC_CANCEL;
	}


	public void setFECHA_SOLIC_CANCEL(Timestamp fECHA_SOLIC_CANCEL) {
		FECHA_SOLIC_CANCEL = fECHA_SOLIC_CANCEL;
	}


	public String getNOMINA_CANCEL() {
		return NOMINA_CANCEL;
	}


	public void setNOMINA_CANCEL(String nOMINA_CANCEL) {
		NOMINA_CANCEL = nOMINA_CANCEL;
	}


	public String getNOMEJEC_CANCEL() {
		return NOMEJEC_CANCEL;
	}


	public void setNOMEJEC_CANCEL(String nOMEJEC_CANCEL) {
		NOMEJEC_CANCEL = nOMEJEC_CANCEL;
	}


	public String getJUSTIFICACION_CANCEL() {
		return JUSTIFICACION_CANCEL;
	}


	public void setJUSTIFICACION_CANCEL(String jUSTIFICACION_CANCEL) {
		JUSTIFICACION_CANCEL = jUSTIFICACION_CANCEL;
	}


	public String getREINVERSION() {
		return REINVERSION;
	}


	public void setREINVERSION(String rEINVERSION) {
		REINVERSION = rEINVERSION;
	}


	public Long getIS_CUENTA_MAESTRA() {
		return IS_CUENTA_MAESTRA;
	}


	public void setIS_CUENTA_MAESTRA(Long iS_CUENTA_MAESTRA) {
		IS_CUENTA_MAESTRA = iS_CUENTA_MAESTRA;
	}


	public String getIS_PORTABILIDAD() {
		return IS_PORTABILIDAD;
	}


	public void setIS_PORTABILIDAD(String iS_PORTABILIDAD) {
		IS_PORTABILIDAD = iS_PORTABILIDAD;
	}


	public String getEMAIL() {
		return EMAIL;
	}


	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}


	public String getAUTORIZADORES() {
		return AUTORIZADORES;
	}


	public void setAUTORIZADORES(String aUTORIZADORES) {
		AUTORIZADORES = aUTORIZADORES;
	}
    
	
	
	
}
