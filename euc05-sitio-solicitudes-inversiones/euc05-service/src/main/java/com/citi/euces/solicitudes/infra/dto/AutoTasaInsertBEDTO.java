package com.citi.euces.solicitudes.infra.dto;

import java.sql.Timestamp;

public class AutoTasaInsertBEDTO {
	
	private Long id_TasAuto;
	private String  fecha_Solic;
	private String estatus;
	private Long suc_Solic;
	private String divicion;
	private Long num_Cte;
	private String  nom_Cte;
	private String soeid_Asig; 
	private Long contrato;
	private String nomina;
	private String nomejec;
	private Long  monto;
	private Long plazo;
	private Long tasa_Autori;
	private String tipo_Autori;
	private Long cete;
	private Long porcen_Cete;
	private String justificacion;
	private String cel;
	private String porta; //folio bancario is_portabilidad
	
	public Long getId_TasAuto() {
		return id_TasAuto;
	}
	public void setId_TasAuto(Long id_TasAuto) {
		this.id_TasAuto = id_TasAuto;
	}
	public String getFecha_Solic() {
		return fecha_Solic;
	}
	public void setFecha_Solic(String fecha_Solic) {
		this.fecha_Solic = fecha_Solic;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Long getSuc_Solic() {
		return suc_Solic;
	}
	public void setSuc_Solic(Long suc_Solic) {
		this.suc_Solic = suc_Solic;
	}
	public String getDivicion() {
		return divicion;
	}
	public void setDivicion(String divicion) {
		this.divicion = divicion;
	}
	public Long getNum_Cte() {
		return num_Cte;
	}
	public void setNum_Cte(Long num_Cte) {
		this.num_Cte = num_Cte;
	}
	public String getNom_Cte() {
		return nom_Cte;
	}
	public void setNom_Cte(String nom_Cte) {
		this.nom_Cte = nom_Cte;
	}
	public String getSoeid_Asig() {
		return soeid_Asig;
	}
	public void setSoeid_Asig(String soeid_Asig) {
		this.soeid_Asig = soeid_Asig;
	}
	public Long getContrato() {
		return contrato;
	}
	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}
	public String getNomina() {
		return nomina;
	}
	public void setNomina(String nomina) {
		this.nomina = nomina;
	}
	public String getNomejec() {
		return nomejec;
	}
	public void setNomejec(String nomejec) {
		this.nomejec = nomejec;
	}
	public Long getMonto() {
		return monto;
	}
	public void setMonto(Long monto) {
		this.monto = monto;
	}
	public Long getPlazo() {
		return plazo;
	}
	public void setPlazo(Long plazo) {
		this.plazo = plazo;
	}
	public Long getTasa_Autori() {
		return tasa_Autori;
	}
	public void setTasa_Autori(Long tasa_Autori) {
		this.tasa_Autori = tasa_Autori;
	}
	public String getTipo_Autori() {
		return tipo_Autori;
	}
	public void setTipo_Autori(String tipo_Autori) {
		this.tipo_Autori = tipo_Autori;
	}
	public Long getCete() {
		return cete;
	}
	public void setCete(Long cete) {
		this.cete = cete;
	}
	public Long getPorcen_Cete() {
		return porcen_Cete;
	}
	public void setPorcen_Cete(Long porcen_Cete) {
		this.porcen_Cete = porcen_Cete;
	}
	public String getJustificacion() {
		return justificacion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	
	


}
