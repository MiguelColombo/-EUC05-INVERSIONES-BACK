package com.citi.euces.solicitudes.infra.dto;

import java.math.BigInteger;

public class OfertaResponseDTO {

	
	private String OFERTA_ID;
	private String OFERTA_BAU;
	private String OFERTA_CAMPANIA_ID;
	private String OFERTA_CLIENTE_TIPO_PERSONA;
	private BigInteger OFERTA_DIAS_CLIENTE;
	private String OFERTA_DIGITAL;
	private String OFERTA_DINERO_NUEVO_MAX;
	private String OFERTA_DINERO_NUEVO_MIN;
	private String OFERTA_ECM;
	private String OFERTA_GUIA_INFORMATIVA_ID;
	private String OFERTA_INFORMATIVA_FONDOS;
	private String OFERTA_MONTO_DESDE;
	private String OFERTA_MONTO_HASTA;
	private String OFERTA_NOMBRE_LARGO;
	private String OFERTA_NTD;
	private String OFERTA_NTM;
	private String OFERTA_NTP;
	private BigInteger OFERTA_PARTICIPACION_UNICA;
	private String OFERTA_PDF_ESPECIAL_ID;
	private String OFERTA_PLAZO_MAXIMO;
	private String OFERTA_PLAZO_MINIMO;
	private String OFERTA_PRIMERA_BUSQUEDA;
	private Long OFERTA_SECCION;
	private BigInteger OFERTA_SEGMENTO;
	private String OFERTA_SEGUNDA_BUSQUEDA;
	private Long OFERTA_SIGUIENTE_PASO;
	private String OFERTA_TASA_ID;
	private BigInteger OFERTA_TIPO_DIRIGIDA;
	/**
	 * @param oFERTA_ID
	 * @param oFERTA_BAU
	 * @param oFERTA_CAMPANIA_ID
	 * @param oFERTA_CLIENTE_TIPO_PERSONA
	 * @param oFERTA_DIAS_CLIENTE
	 * @param oFERTA_DIGITAL
	 * @param oFERTA_DINERO_NUEVO_MAX
	 * @param oFERTA_DINERO_NUEVO_MIN
	 * @param oFERTA_ECM
	 * @param oFERTA_GUIA_INFORMATIVA_ID
	 * @param oFERTA_INFORMATIVA_FONDOS
	 * @param oFERTA_MONTO_DESDE
	 * @param oFERTA_MONTO_HASTA
	 * @param oFERTA_NOMBRE_LARGO
	 * @param oFERTA_NTD
	 * @param oFERTA_NTM
	 * @param oFERTA_NTP
	 * @param oFERTA_PARTICIPACION_UNICA
	 * @param oFERTA_PDF_ESPECIAL_ID
	 * @param oFERTA_PLAZO_MAXIMO
	 * @param oFERTA_PLAZO_MINIMO
	 * @param oFERTA_PRIMERA_BUSQUEDA
	 * @param oFERTA_SECCION
	 * @param oFERTA_SEGMENTO
	 * @param oFERTA_SEGUNDA_BUSQUEDA
	 * @param oFERTA_SIGUIENTE_PASO
	 * @param oFERTA_TASA_ID
	 * @param oFERTA_TIPO_DIRIGIDA
	 */
	public OfertaResponseDTO(String oFERTA_ID, String oFERTA_BAU, String oFERTA_CAMPANIA_ID,
			String oFERTA_CLIENTE_TIPO_PERSONA, BigInteger oFERTA_DIAS_CLIENTE, String oFERTA_DIGITAL,
			String oFERTA_DINERO_NUEVO_MAX, String oFERTA_DINERO_NUEVO_MIN, String oFERTA_ECM,
			String oFERTA_GUIA_INFORMATIVA_ID, String oFERTA_INFORMATIVA_FONDOS, String oFERTA_MONTO_DESDE,
			String oFERTA_MONTO_HASTA, String oFERTA_NOMBRE_LARGO, String oFERTA_NTD, String oFERTA_NTM,
			String oFERTA_NTP, BigInteger oFERTA_PARTICIPACION_UNICA, String oFERTA_PDF_ESPECIAL_ID,
			String oFERTA_PLAZO_MAXIMO, String oFERTA_PLAZO_MINIMO, String oFERTA_PRIMERA_BUSQUEDA, Long oFERTA_SECCION,
			BigInteger oFERTA_SEGMENTO, String oFERTA_SEGUNDA_BUSQUEDA, Long oFERTA_SIGUIENTE_PASO,
			String oFERTA_TASA_ID, BigInteger oFERTA_TIPO_DIRIGIDA) {
		super();
		OFERTA_ID = oFERTA_ID;
		OFERTA_BAU = oFERTA_BAU;
		OFERTA_CAMPANIA_ID = oFERTA_CAMPANIA_ID;
		OFERTA_CLIENTE_TIPO_PERSONA = oFERTA_CLIENTE_TIPO_PERSONA;
		OFERTA_DIAS_CLIENTE = oFERTA_DIAS_CLIENTE;
		OFERTA_DIGITAL = oFERTA_DIGITAL;
		OFERTA_DINERO_NUEVO_MAX = oFERTA_DINERO_NUEVO_MAX;
		OFERTA_DINERO_NUEVO_MIN = oFERTA_DINERO_NUEVO_MIN;
		OFERTA_ECM = oFERTA_ECM;
		OFERTA_GUIA_INFORMATIVA_ID = oFERTA_GUIA_INFORMATIVA_ID;
		OFERTA_INFORMATIVA_FONDOS = oFERTA_INFORMATIVA_FONDOS;
		OFERTA_MONTO_DESDE = oFERTA_MONTO_DESDE;
		OFERTA_MONTO_HASTA = oFERTA_MONTO_HASTA;
		OFERTA_NOMBRE_LARGO = oFERTA_NOMBRE_LARGO;
		OFERTA_NTD = oFERTA_NTD;
		OFERTA_NTM = oFERTA_NTM;
		OFERTA_NTP = oFERTA_NTP;
		OFERTA_PARTICIPACION_UNICA = oFERTA_PARTICIPACION_UNICA;
		OFERTA_PDF_ESPECIAL_ID = oFERTA_PDF_ESPECIAL_ID;
		OFERTA_PLAZO_MAXIMO = oFERTA_PLAZO_MAXIMO;
		OFERTA_PLAZO_MINIMO = oFERTA_PLAZO_MINIMO;
		OFERTA_PRIMERA_BUSQUEDA = oFERTA_PRIMERA_BUSQUEDA;
		OFERTA_SECCION = oFERTA_SECCION;
		OFERTA_SEGMENTO = oFERTA_SEGMENTO;
		OFERTA_SEGUNDA_BUSQUEDA = oFERTA_SEGUNDA_BUSQUEDA;
		OFERTA_SIGUIENTE_PASO = oFERTA_SIGUIENTE_PASO;
		OFERTA_TASA_ID = oFERTA_TASA_ID;
		OFERTA_TIPO_DIRIGIDA = oFERTA_TIPO_DIRIGIDA;
	}
	/**
	 * 
	 */
	public OfertaResponseDTO() {
		super();
	}
	public String getOFERTA_ID() {
		return OFERTA_ID;
	}
	public void setOFERTA_ID(String oFERTA_ID) {
		OFERTA_ID = oFERTA_ID;
	}
	public String getOFERTA_BAU() {
		return OFERTA_BAU;
	}
	public void setOFERTA_BAU(String oFERTA_BAU) {
		OFERTA_BAU = oFERTA_BAU;
	}
	public String getOFERTA_CAMPANIA_ID() {
		return OFERTA_CAMPANIA_ID;
	}
	public void setOFERTA_CAMPANIA_ID(String oFERTA_CAMPANIA_ID) {
		OFERTA_CAMPANIA_ID = oFERTA_CAMPANIA_ID;
	}
	public String getOFERTA_CLIENTE_TIPO_PERSONA() {
		return OFERTA_CLIENTE_TIPO_PERSONA;
	}
	public void setOFERTA_CLIENTE_TIPO_PERSONA(String oFERTA_CLIENTE_TIPO_PERSONA) {
		OFERTA_CLIENTE_TIPO_PERSONA = oFERTA_CLIENTE_TIPO_PERSONA;
	}
	public BigInteger getOFERTA_DIAS_CLIENTE() {
		return OFERTA_DIAS_CLIENTE;
	}
	public void setOFERTA_DIAS_CLIENTE(BigInteger oFERTA_DIAS_CLIENTE) {
		OFERTA_DIAS_CLIENTE = oFERTA_DIAS_CLIENTE;
	}
	public String getOFERTA_DIGITAL() {
		return OFERTA_DIGITAL;
	}
	public void setOFERTA_DIGITAL(String oFERTA_DIGITAL) {
		OFERTA_DIGITAL = oFERTA_DIGITAL;
	}
	public String getOFERTA_DINERO_NUEVO_MAX() {
		return OFERTA_DINERO_NUEVO_MAX;
	}
	public void setOFERTA_DINERO_NUEVO_MAX(String oFERTA_DINERO_NUEVO_MAX) {
		OFERTA_DINERO_NUEVO_MAX = oFERTA_DINERO_NUEVO_MAX;
	}
	public String getOFERTA_DINERO_NUEVO_MIN() {
		return OFERTA_DINERO_NUEVO_MIN;
	}
	public void setOFERTA_DINERO_NUEVO_MIN(String oFERTA_DINERO_NUEVO_MIN) {
		OFERTA_DINERO_NUEVO_MIN = oFERTA_DINERO_NUEVO_MIN;
	}
	public String getOFERTA_ECM() {
		return OFERTA_ECM;
	}
	public void setOFERTA_ECM(String oFERTA_ECM) {
		OFERTA_ECM = oFERTA_ECM;
	}
	public String getOFERTA_GUIA_INFORMATIVA_ID() {
		return OFERTA_GUIA_INFORMATIVA_ID;
	}
	public void setOFERTA_GUIA_INFORMATIVA_ID(String oFERTA_GUIA_INFORMATIVA_ID) {
		OFERTA_GUIA_INFORMATIVA_ID = oFERTA_GUIA_INFORMATIVA_ID;
	}
	public String getOFERTA_INFORMATIVA_FONDOS() {
		return OFERTA_INFORMATIVA_FONDOS;
	}
	public void setOFERTA_INFORMATIVA_FONDOS(String oFERTA_INFORMATIVA_FONDOS) {
		OFERTA_INFORMATIVA_FONDOS = oFERTA_INFORMATIVA_FONDOS;
	}
	public String getOFERTA_MONTO_DESDE() {
		return OFERTA_MONTO_DESDE;
	}
	public void setOFERTA_MONTO_DESDE(String oFERTA_MONTO_DESDE) {
		OFERTA_MONTO_DESDE = oFERTA_MONTO_DESDE;
	}
	public String getOFERTA_MONTO_HASTA() {
		return OFERTA_MONTO_HASTA;
	}
	public void setOFERTA_MONTO_HASTA(String oFERTA_MONTO_HASTA) {
		OFERTA_MONTO_HASTA = oFERTA_MONTO_HASTA;
	}
	public String getOFERTA_NOMBRE_LARGO() {
		return OFERTA_NOMBRE_LARGO;
	}
	public void setOFERTA_NOMBRE_LARGO(String oFERTA_NOMBRE_LARGO) {
		OFERTA_NOMBRE_LARGO = oFERTA_NOMBRE_LARGO;
	}
	public String getOFERTA_NTD() {
		return OFERTA_NTD;
	}
	public void setOFERTA_NTD(String oFERTA_NTD) {
		OFERTA_NTD = oFERTA_NTD;
	}
	public String getOFERTA_NTM() {
		return OFERTA_NTM;
	}
	public void setOFERTA_NTM(String oFERTA_NTM) {
		OFERTA_NTM = oFERTA_NTM;
	}
	public String getOFERTA_NTP() {
		return OFERTA_NTP;
	}
	public void setOFERTA_NTP(String oFERTA_NTP) {
		OFERTA_NTP = oFERTA_NTP;
	}
	public BigInteger getOFERTA_PARTICIPACION_UNICA() {
		return OFERTA_PARTICIPACION_UNICA;
	}
	public void setOFERTA_PARTICIPACION_UNICA(BigInteger oFERTA_PARTICIPACION_UNICA) {
		OFERTA_PARTICIPACION_UNICA = oFERTA_PARTICIPACION_UNICA;
	}
	public String getOFERTA_PDF_ESPECIAL_ID() {
		return OFERTA_PDF_ESPECIAL_ID;
	}
	public void setOFERTA_PDF_ESPECIAL_ID(String oFERTA_PDF_ESPECIAL_ID) {
		OFERTA_PDF_ESPECIAL_ID = oFERTA_PDF_ESPECIAL_ID;
	}
	public String getOFERTA_PLAZO_MAXIMO() {
		return OFERTA_PLAZO_MAXIMO;
	}
	public void setOFERTA_PLAZO_MAXIMO(String oFERTA_PLAZO_MAXIMO) {
		OFERTA_PLAZO_MAXIMO = oFERTA_PLAZO_MAXIMO;
	}
	public String getOFERTA_PLAZO_MINIMO() {
		return OFERTA_PLAZO_MINIMO;
	}
	public void setOFERTA_PLAZO_MINIMO(String oFERTA_PLAZO_MINIMO) {
		OFERTA_PLAZO_MINIMO = oFERTA_PLAZO_MINIMO;
	}
	public String getOFERTA_PRIMERA_BUSQUEDA() {
		return OFERTA_PRIMERA_BUSQUEDA;
	}
	public void setOFERTA_PRIMERA_BUSQUEDA(String oFERTA_PRIMERA_BUSQUEDA) {
		OFERTA_PRIMERA_BUSQUEDA = oFERTA_PRIMERA_BUSQUEDA;
	}
	public Long getOFERTA_SECCION() {
		return OFERTA_SECCION;
	}
	public void setOFERTA_SECCION(Long oFERTA_SECCION) {
		OFERTA_SECCION = oFERTA_SECCION;
	}
	public BigInteger getOFERTA_SEGMENTO() {
		return OFERTA_SEGMENTO;
	}
	public void setOFERTA_SEGMENTO(BigInteger oFERTA_SEGMENTO) {
		OFERTA_SEGMENTO = oFERTA_SEGMENTO;
	}
	public String getOFERTA_SEGUNDA_BUSQUEDA() {
		return OFERTA_SEGUNDA_BUSQUEDA;
	}
	public void setOFERTA_SEGUNDA_BUSQUEDA(String oFERTA_SEGUNDA_BUSQUEDA) {
		OFERTA_SEGUNDA_BUSQUEDA = oFERTA_SEGUNDA_BUSQUEDA;
	}
	public Long getOFERTA_SIGUIENTE_PASO() {
		return OFERTA_SIGUIENTE_PASO;
	}
	public void setOFERTA_SIGUIENTE_PASO(Long oFERTA_SIGUIENTE_PASO) {
		OFERTA_SIGUIENTE_PASO = oFERTA_SIGUIENTE_PASO;
	}
	public String getOFERTA_TASA_ID() {
		return OFERTA_TASA_ID;
	}
	public void setOFERTA_TASA_ID(String oFERTA_TASA_ID) {
		OFERTA_TASA_ID = oFERTA_TASA_ID;
	}
	public BigInteger getOFERTA_TIPO_DIRIGIDA() {
		return OFERTA_TIPO_DIRIGIDA;
	}
	public void setOFERTA_TIPO_DIRIGIDA(BigInteger oFERTA_TIPO_DIRIGIDA) {
		OFERTA_TIPO_DIRIGIDA = oFERTA_TIPO_DIRIGIDA;
	}
	
	
}
