package com.citi.euces.solicitudes.infra.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

public class ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO {

	private Long tas_ID_TASAUTO;
	private String tas_ESTATUS;
	private Long  tas_Folio;
	private String tas_FECHA_SOLIC;
	private String tas_FECHA_AUTORI;
	private String tas_FECHA_ESTATUS;
	private Long tas_SUC_SOLIC;
	private String suc;
	private String tas_NUM_CTE;
	private String tas_NOM_CTE;
	private String tas_CONTRATO;
	private String tas_NOMINA;
	private double tas_MONTO;
	private Long tas_PLAZO;
	private String tas_TASA_AUTORI;
	private String tas_TipoOferta;
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
	private String fecha_Liberacion;
	private String tas_Tipo_Campana;
	private Long OFERTA_SIGUIENTE_PASO;
	private String OFERTA_PDF_ESPECIAL_ID;
	private String NOMEJEC;
	private String GATNOMINAOFER;
	private String GATREALOFER;
	private String RENDIMIENTOBRUTO;
	private String FECHA_FIN;
	public ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO(Long tas_ID_TASAUTO, String tas_ESTATUS, Long tas_Folio,
			String tas_FECHA_SOLIC, String tas_FECHA_AUTORI, String tas_FECHA_ESTATUS, Long tas_SUC_SOLIC, String suc,
			String tas_NUM_CTE, String tas_NOM_CTE, String tas_CONTRATO, String tas_NOMINA, double tas_MONTO, Long tas_PLAZO,
			String tas_TASA_AUTORI, String tas_TipoOferta, String tas_SOEID_AUTORI, String tas_SOEID_ASIG,
			String tas_SOEID_OPE, String tas_INIC_AUTORI, Long tas_CETE, Long tas_PORCEN_CETE,
			String eleg_autorizadores, String tas_OBSERVA_WEB, String certificado_fisico, String certificado_moral,
			String fecha_Liberacion, String tas_Tipo_Campana, Long oFERTA_SIGUIENTE_PASO, String oFERTA_PDF_ESPECIAL_ID,
			String nOMEJEC, String gATNOMINAOFER, String gATREALOFER, String rENDIMIENTOBRUTO, String fECHA_FIN) {
		super();
		this.tas_ID_TASAUTO = tas_ID_TASAUTO;
		this.tas_ESTATUS = tas_ESTATUS;
		this.tas_Folio = tas_Folio;
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
		this.tas_TipoOferta = tas_TipoOferta;
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
		this.fecha_Liberacion = fecha_Liberacion;
		this.tas_Tipo_Campana = tas_Tipo_Campana;
		OFERTA_SIGUIENTE_PASO = oFERTA_SIGUIENTE_PASO;
		OFERTA_PDF_ESPECIAL_ID = oFERTA_PDF_ESPECIAL_ID;
		NOMEJEC = nOMEJEC;
		GATNOMINAOFER = gATNOMINAOFER;
		GATREALOFER = gATREALOFER;
		RENDIMIENTOBRUTO = rENDIMIENTOBRUTO;
		FECHA_FIN = fECHA_FIN;
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
	public Long getTas_Folio() {
		return tas_Folio;
	}
	public void setTas_Folio(Long tas_Folio) {
		this.tas_Folio = tas_Folio;
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
	public String getTas_NUM_CTE() {
		return tas_NUM_CTE;
	}
	public void setTas_NUM_CTE(String tas_NUM_CTE) {
		this.tas_NUM_CTE = tas_NUM_CTE;
	}
	public String getTas_NOM_CTE() {
		return tas_NOM_CTE;
	}
	public void setTas_NOM_CTE(String tas_NOM_CTE) {
		this.tas_NOM_CTE = tas_NOM_CTE;
	}
	public String getTas_CONTRATO() {
		return tas_CONTRATO;
	}
	public void setTas_CONTRATO(String tas_CONTRATO) {
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
	public String getTas_TipoOferta() {
		return tas_TipoOferta;
	}
	public void setTas_TipoOferta(String tas_TipoOferta) {
		this.tas_TipoOferta = tas_TipoOferta;
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
	public String getFecha_Liberacion() {
		return fecha_Liberacion;
	}
	public void setFecha_Liberacion(String fecha_Liberacion) {
		this.fecha_Liberacion = fecha_Liberacion;
	}
	public String getTas_Tipo_Campana() {
		return tas_Tipo_Campana;
	}
	public void setTas_Tipo_Campana(String tas_Tipo_Campana) {
		this.tas_Tipo_Campana = tas_Tipo_Campana;
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
	public String getFECHA_FIN() {
		return FECHA_FIN;
	}
	public void setFECHA_FIN(String fECHA_FIN) {
		FECHA_FIN = fECHA_FIN;
	}
	
	
}
