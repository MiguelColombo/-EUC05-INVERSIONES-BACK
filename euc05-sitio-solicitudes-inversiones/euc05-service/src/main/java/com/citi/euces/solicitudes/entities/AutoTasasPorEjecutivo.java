package com.citi.euces.solicitudes.entities;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "UEC_TB_AUTOTASAS")
public class AutoTasasPorEjecutivo {

	@Id
	@Column(name ="ID_TASAUTO")
	private Long tas_ID_TASAUTO;
	@Column(name ="ESTATUS")
	private String tas_ESTATUS;
	@Column(name ="NUM_AUTORI_UEC")
	private Long  tas_NUM_AUTORI_UEC;
	@Column(name ="FECHA_SOLIC")
	private Timestamp tas_FECHA_SOLIC;
	@Column(name ="FECHA_AUTORI")
	private Timestamp tas_FECHA_AUTORI;
	@Column(name ="FECHA_ESTATUS")
	private Timestamp tas_FECHA_ESTATUS;
	@Column(name ="SUC_SOLIC")
	private Long tas_SUC_SOLIC;
	@Column(name ="suc")
	private String suc;
	@Column(name ="NUM_CTE")
	private Long tas_NUM_CTE;
	@Column(name ="NOM_CTE")
	private String tas_NOM_CTE;
	@Column(name ="CONTRATO")
	private Long tas_CONTRATO;
	@Column(name ="NOMINA")
	private String tas_NOMINA;
	@Column(name ="MONTO")
	private double tas_MONTO;
	@Column(name ="PLAZO")
	private Long tas_PLAZO;
	@Column(name ="TASA_AUTORI")
	private String tas_TASA_AUTORI;
	@Column(name ="TIPO_AUTORI")
	private String tas_TIPO_AUTORI;
	@Column(name ="SOEID_AUTORI")
	private String tas_SOEID_AUTORI; 
	@Column(name ="SOEID_ASIG")
	private String tas_SOEID_ASIG;
	@Column(name ="SOEID_OPE")
	private String tas_SOEID_OPE;
	@Column(name ="INIC_AUTORI")
	private String tas_INIC_AUTORI;
	@Column(name ="CETE")
	private Long tas_CETE;
	@Column(name ="PORCEN_CETE")
	private Long tas_PORCEN_CETE; 
	@Column(name ="AUTORIZADORES")
	private String eleg_autorizadores; 
	@Column(name ="OBSERVA_WEB") 
	private String tas_OBSERVA_WEB;
	@Column(name ="certificado_fisico") 
	private String certificado_fisico;
	@Column(name ="certificado_moral") 
	private String certificado_moral;
	@Column(name ="ID_CAMPANA") 
	private String ID_CAMPANA;
	@Column(name ="OFERTA_SIGUIENTE_PASO")
	private Long OFERTA_SIGUIENTE_PASO;
	@Column(name ="OFERTA_PDF_ESPECIAL_ID")
	private String OFERTA_PDF_ESPECIAL_ID;
	@Column(name ="NOMEJEC")
	private String NOMEJEC;
	@Column(name ="GATNOMINAOFER")
	private String GATNOMINAOFER;
	@Column(name ="GATREALOFER")
	private String GATREALOFER;
	@Column(name ="RENDIMIENTOBRUTO")
	private String RENDIMIENTOBRUTO;
	@Column(name ="CAMPANIAS_FIN")
	private Timestamp CAMPANIAS_FIN;
	
	public Timestamp getCAMPANIAS_FIN() {
		return CAMPANIAS_FIN;
	}

	public void setCAMPANIAS_FIN(Timestamp cAMPANIAS_FIN) {
		CAMPANIAS_FIN = cAMPANIAS_FIN;
	}

	public AutoTasasPorEjecutivo() {
		
	}

	public Long getTas_ID_TASAUTO() {
		return tas_ID_TASAUTO;
	}

	public void setTas_ID_TASAUTO(Long tas_ID_TASAUTO) {
		this.tas_ID_TASAUTO = tas_ID_TASAUTO;
	}

	public String getTas_ESTATUS() {
		return tas_ESTATUS;
	}

	public void setTas_ESTATUS(String tas_ESTATUS) {
		this.tas_ESTATUS = tas_ESTATUS;
	}

	public Long getTas_NUM_AUTORI_UEC() {
		return tas_NUM_AUTORI_UEC;
	}

	public void setTas_NUM_AUTORI_UEC(Long tas_NUM_AUTORI_UEC) {
		this.tas_NUM_AUTORI_UEC = tas_NUM_AUTORI_UEC;
	}

	public Timestamp getTas_FECHA_SOLIC() {
		return tas_FECHA_SOLIC;
	}

	public void setTas_FECHA_SOLIC(Timestamp tas_FECHA_SOLIC) {
		this.tas_FECHA_SOLIC = tas_FECHA_SOLIC;
	}

	public Timestamp getTas_FECHA_AUTORI() {
		return tas_FECHA_AUTORI;
	}

	public void setTas_FECHA_AUTORI(Timestamp tas_FECHA_AUTORI) {
		this.tas_FECHA_AUTORI = tas_FECHA_AUTORI;
	}

	public Timestamp getTas_FECHA_ESTATUS() {
		return tas_FECHA_ESTATUS;
	}

	public void setTas_FECHA_ESTATUS(Timestamp tas_FECHA_ESTATUS) {
		this.tas_FECHA_ESTATUS = tas_FECHA_ESTATUS;
	}

	public Long getTas_SUC_SOLIC() {
		return tas_SUC_SOLIC;
	}

	public void setTas_SUC_SOLIC(Long tas_SUC_SOLIC) {
		this.tas_SUC_SOLIC = tas_SUC_SOLIC;
	}

	public String getSuc() {
		return suc;
	}

	public void setSuc(String suc) {
		this.suc = suc;
	}

	public Long getTas_NUM_CTE() {
		return tas_NUM_CTE;
	}

	public void setTas_NUM_CTE(Long tas_NUM_CTE) {
		this.tas_NUM_CTE = tas_NUM_CTE;
	}

	public String getTas_NOM_CTE() {
		return tas_NOM_CTE;
	}

	public void setTas_NOM_CTE(String tas_NOM_CTE) {
		this.tas_NOM_CTE = tas_NOM_CTE;
	}

	public Long getTas_CONTRATO() {
		return tas_CONTRATO;
	}

	public void setTas_CONTRATO(Long tas_CONTRATO) {
		this.tas_CONTRATO = tas_CONTRATO;
	}

	public String getTas_NOMINA() {
		return tas_NOMINA;
	}

	public void setTas_NOMINA(String tas_NOMINA) {
		this.tas_NOMINA = tas_NOMINA;
	}

	public double getTas_MONTO() {
		return tas_MONTO;
	}

	public void setTas_MONTO(double tas_MONTO) {
		this.tas_MONTO = tas_MONTO;
	}

	public Long getTas_PLAZO() {
		return tas_PLAZO;
	}

	public void setTas_PLAZO(Long tas_PLAZO) {
		this.tas_PLAZO = tas_PLAZO;
	}

	public String getTas_TASA_AUTORI() {
		return tas_TASA_AUTORI;
	}

	public void setTas_TASA_AUTORI(String tas_TASA_AUTORI) {
		this.tas_TASA_AUTORI = tas_TASA_AUTORI;
	}

	public String getTas_TIPO_AUTORI() {
		return tas_TIPO_AUTORI;
	}

	public void setTas_TIPO_AUTORI(String tas_TIPO_AUTORI) {
		this.tas_TIPO_AUTORI = tas_TIPO_AUTORI;
	}

	public String getTas_SOEID_AUTORI() {
		return tas_SOEID_AUTORI;
	}

	public void setTas_SOEID_AUTORI(String tas_SOEID_AUTORI) {
		this.tas_SOEID_AUTORI = tas_SOEID_AUTORI;
	}

	public String getTas_SOEID_ASIG() {
		return tas_SOEID_ASIG;
	}

	public void setTas_SOEID_ASIG(String tas_SOEID_ASIG) {
		this.tas_SOEID_ASIG = tas_SOEID_ASIG;
	}

	public String getTas_SOEID_OPE() {
		return tas_SOEID_OPE;
	}

	public void setTas_SOEID_OPE(String tas_SOEID_OPE) {
		this.tas_SOEID_OPE = tas_SOEID_OPE;
	}

	public String getTas_INIC_AUTORI() {
		return tas_INIC_AUTORI;
	}

	public void setTas_INIC_AUTORI(String tas_INIC_AUTORI) {
		this.tas_INIC_AUTORI = tas_INIC_AUTORI;
	}

	public Long getTas_CETE() {
		return tas_CETE;
	}

	public void setTas_CETE(Long tas_CETE) {
		this.tas_CETE = tas_CETE;
	}

	public Long getTas_PORCEN_CETE() {
		return tas_PORCEN_CETE;
	}

	public void setTas_PORCEN_CETE(Long tas_PORCEN_CETE) {
		this.tas_PORCEN_CETE = tas_PORCEN_CETE;
	}

	public String getEleg_autorizadores() {
		return eleg_autorizadores;
	}

	public void setEleg_autorizadores(String eleg_autorizadores) {
		this.eleg_autorizadores = eleg_autorizadores;
	}

	public String getTas_OBSERVA_WEB() {
		return tas_OBSERVA_WEB;
	}

	public void setTas_OBSERVA_WEB(String tas_OBSERVA_WEB) {
		this.tas_OBSERVA_WEB = tas_OBSERVA_WEB;
	}

	public String getCertificado_fisico() {
		return certificado_fisico;
	}

	public void setCertificado_fisico(String certificado_fisico) {
		this.certificado_fisico = certificado_fisico;
	}

	public String getCertificado_moral() {
		return certificado_moral;
	}

	public void setCertificado_moral(String certificado_moral) {
		this.certificado_moral = certificado_moral;
	}

	public String getID_CAMPANA() {
		return ID_CAMPANA;
	}

	public void setID_CAMPANA(String iD_CAMPANA) {
		ID_CAMPANA = iD_CAMPANA;
	}

	public Long getOFERTA_SIGUIENTE_PASO() {
		return OFERTA_SIGUIENTE_PASO;
	}

	public void setOFERTA_SIGUIENTE_PASO(Long oFERTA_SIGUIENTE_PASO) {
		OFERTA_SIGUIENTE_PASO = oFERTA_SIGUIENTE_PASO;
	}

	public String getOFERTA_PDF_ESPECIAL_ID() {
		return OFERTA_PDF_ESPECIAL_ID;
	}

	public void setOFERTA_PDF_ESPECIAL_ID(String oFERTA_PDF_ESPECIAL_ID) {
		OFERTA_PDF_ESPECIAL_ID = oFERTA_PDF_ESPECIAL_ID;
	}

	public String getNOMEJEC() {
		return NOMEJEC;
	}

	public void setNOMEJEC(String nOMEJEC) {
		NOMEJEC = nOMEJEC;
	}

	public String getGATNOMINAOFER() {
		return GATNOMINAOFER;
	}

	public void setGATNOMINAOFER(String gATNOMINAOFER) {
		GATNOMINAOFER = gATNOMINAOFER;
	}

	public String getGATREALOFER() {
		return GATREALOFER;
	}

	public void setGATREALOFER(String gATREALOFER) {
		GATREALOFER = gATREALOFER;
	}

	public String getRENDIMIENTOBRUTO() {
		return RENDIMIENTOBRUTO;
	}

	public void setRENDIMIENTOBRUTO(String rENDIMIENTOBRUTO) {
		RENDIMIENTOBRUTO = rENDIMIENTOBRUTO;
	}
	

}
