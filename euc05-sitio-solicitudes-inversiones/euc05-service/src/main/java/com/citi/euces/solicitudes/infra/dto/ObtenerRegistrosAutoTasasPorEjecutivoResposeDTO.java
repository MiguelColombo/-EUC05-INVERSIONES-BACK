package com.citi.euces.solicitudes.infra.dto;

import java.sql.Timestamp;
import java.util.Date;

public class ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO {

	private Long tas_ID_TASAUTO;
	private String tas_ESTATUS;
	private Long  tas_NUM_AUTORI_UEC;
	private String tas_FECHA_SOLIC;
	private String tas_FECHA_AUTORI;
	private String tas_FECHA_ESTATUS;
	private Long tas_SUC_SOLIC;
	private String suc;
	private Long tas_NUM_CTE;
	private String tas_NOM_CTE;
	private Long tas_CONTRATO;
	private String tas_NOMINA;
	private Long tas_MONTO;
	private Long tas_PLAZO;
	private Long tas_TASA_AUTORI;
	private String tas_TIPO_AUTORI;
	private String tas_SOEID_AUTORI; 
	private String tas_SOEID_ASIG;
	private String tas_SOEID_OPE;
	private String tas_INIC_AUTORI;
	private Long tas_CETE;
	private Long tas_PORCEN_CETE; 
	private String eleg_autorizadores; 
	private String tas_OBSERVA_WEB;
	private String certificado_fisico;
	private String certificado_moral;
	/**
	 * @param tas_ID_TASAUTO
	 * @param tas_ESTATUS
	 * @param tas_NUM_AUTORI_UEC
	 * @param tas_FECHA_SOLIC
	 * @param tas_FECHA_AUTORI
	 * @param tas_FECHA_ESTATUS
	 * @param tas_SUC_SOLIC
	 * @param suc
	 * @param tas_NUM_CTE
	 * @param tas_NOM_CTE
	 * @param tas_CONTRATO
	 * @param tas_NOMINA
	 * @param tas_MONTO
	 * @param tas_PLAZO
	 * @param tas_TASA_AUTORI
	 * @param tas_TIPO_AUTORI
	 * @param tas_SOEID_AUTORI
	 * @param tas_SOEID_ASIG
	 * @param tas_SOEID_OPE
	 * @param tas_INIC_AUTORI
	 * @param tas_CETE
	 * @param tas_PORCEN_CETE
	 * @param eleg_autorizadores
	 * @param tas_OBSERVA_WEB
	 * @param certificado_fisico
	 * @param certificado_moral
	 */
	public ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO(Long tas_ID_TASAUTO, String tas_ESTATUS, Long tas_NUM_AUTORI_UEC,
			String tas_FECHA_SOLIC, String tas_FECHA_AUTORI, String tas_FECHA_ESTATUS, Long tas_SUC_SOLIC, String suc,
			Long tas_NUM_CTE, String tas_NOM_CTE, Long tas_CONTRATO, String tas_NOMINA, Long tas_MONTO, Long tas_PLAZO,
			Long tas_TASA_AUTORI, String tas_TIPO_AUTORI, String tas_SOEID_AUTORI, String tas_SOEID_ASIG,
			String tas_SOEID_OPE, String tas_INIC_AUTORI, Long tas_CETE, Long tas_PORCEN_CETE, String eleg_autorizadores,
			String tas_OBSERVA_WEB, String certificado_fisico, String certificado_moral) {
		super();
		this.tas_ID_TASAUTO = tas_ID_TASAUTO;
		this.tas_ESTATUS = tas_ESTATUS;
		this.tas_NUM_AUTORI_UEC = tas_NUM_AUTORI_UEC;
		this.tas_FECHA_SOLIC = tas_FECHA_SOLIC;
		this.tas_FECHA_AUTORI = tas_FECHA_AUTORI;
		this.tas_FECHA_ESTATUS = tas_FECHA_ESTATUS;
		this.tas_SUC_SOLIC = tas_SUC_SOLIC;
		this.suc = suc;
		this.tas_NUM_CTE = tas_NUM_CTE;
		this.tas_NOM_CTE = tas_NOM_CTE;
		this.tas_CONTRATO = tas_CONTRATO;
		this.tas_NOMINA = tas_NOMINA;
		this.tas_MONTO = tas_MONTO;
		this.tas_PLAZO = tas_PLAZO;
		this.tas_TASA_AUTORI = tas_TASA_AUTORI;
		this.tas_TIPO_AUTORI = tas_TIPO_AUTORI;
		this.tas_SOEID_AUTORI = tas_SOEID_AUTORI;
		this.tas_SOEID_ASIG = tas_SOEID_ASIG;
		this.tas_SOEID_OPE = tas_SOEID_OPE;
		this.tas_INIC_AUTORI = tas_INIC_AUTORI;
		this.tas_CETE = tas_CETE;
		this.tas_PORCEN_CETE = tas_PORCEN_CETE;
		this.eleg_autorizadores = eleg_autorizadores;
		this.tas_OBSERVA_WEB = tas_OBSERVA_WEB;
		this.certificado_fisico = certificado_fisico;
		this.certificado_moral = certificado_moral;
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
	public String getTas_FECHA_SOLIC() {
		return tas_FECHA_SOLIC;
	}
	public void setTas_FECHA_SOLIC(String tas_FECHA_SOLIC) {
		this.tas_FECHA_SOLIC = tas_FECHA_SOLIC;
	}
	public String getTas_FECHA_AUTORI() {
		return tas_FECHA_AUTORI;
	}
	public void setTas_FECHA_AUTORI(String tas_FECHA_AUTORI) {
		this.tas_FECHA_AUTORI = tas_FECHA_AUTORI;
	}
	public String getTas_FECHA_ESTATUS() {
		return tas_FECHA_ESTATUS;
	}
	public void setTas_FECHA_ESTATUS(String tas_FECHA_ESTATUS) {
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
	public Long getTas_MONTO() {
		return tas_MONTO;
	}
	public void setTas_MONTO(Long tas_MONTO) {
		this.tas_MONTO = tas_MONTO;
	}
	public Long getTas_PLAZO() {
		return tas_PLAZO;
	}
	public void setTas_PLAZO(Long tas_PLAZO) {
		this.tas_PLAZO = tas_PLAZO;
	}
	public Long getTas_TASA_AUTORI() {
		return tas_TASA_AUTORI;
	}
	public void setTas_TASA_AUTORI(Long tas_TASA_AUTORI) {
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
	
	
}
