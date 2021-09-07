package com.citi.euces.solicitudes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "UEC_CATALOGO_AUTORIZADORES2021")
public class Autorizadores implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name ="SOEID" )
	private String Soeid;
	@Column(name ="SOEID_DIVISIONAL" ,nullable = true )
	private String Soeid_Divisional;
	@Column(name ="SOEID_DISTRITAL" ,nullable = true)
	private String Soeid_Distrital;
	@Column(name ="DIVISION" ,nullable = true )
	private String Division;
	@Column(name ="DISTRISTO",nullable = true )
	private String Distrito;
	@Column(name ="NOMBRE" )
	private String nombre;
	@Column(name ="INIC" )
	private String Inic;
	@Column(name ="FECHA_INICIO" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date Fecha_Inicio;
	@Column(name ="FECHA_TERMINO" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date Fecha_Termino;
	@Column(name ="ALTA" )
	private Long Alta;
	@Column(name ="CORREO" )
	private String Correo;
	@Column(name ="IS_CETE100", nullable = true )
	private Long is_cetes100;
	@Column(name ="IS_CAMPESP",nullable = true )
	private Long is_campesp;
	@Column(name ="ID_NIVEL_AUTO" )
	private Long id_nivel_auto;
	/**
	 * @param soeid
	 * @param soeid_Divisional
	 * @param soeid_Distrital
	 * @param division
	 * @param distrito
	 * @param nombre
	 * @param inic
	 * @param fecha_Inicio
	 * @param fecha_Termino
	 * @param alta
	 * @param correo
	 * @param is_cetes100
	 * @param is_campesp
	 * @param id_nivel_auto
	 */
	public Autorizadores() {
		
	}
	public Autorizadores(String soeid, String soeid_Divisional, String soeid_Distrital, String division,
			String distrito, String nombre, String inic, Date fecha_Inicio, Date fecha_Termino, Long alta,
			String correo, Long is_cetes100, Long is_campesp, Long id_nivel_auto) {
		super();
		Soeid = soeid;
		Soeid_Divisional = soeid_Divisional;
		Soeid_Distrital = soeid_Distrital;
		Division = division;
		Distrito = distrito;
		this.nombre = nombre;
		Inic = inic;
		Fecha_Inicio = fecha_Inicio;
		Fecha_Termino = fecha_Termino;
		Alta = alta;
		Correo = correo;
		this.is_cetes100 = is_cetes100;
		this.is_campesp = is_campesp;
		this.id_nivel_auto = id_nivel_auto;
	}
	public String getSoeid() {
		return Soeid;
	}
	public void setSoeid(String soeid) {
		Soeid = soeid;
	}
	public String getSoeid_Divisional() {
		return Soeid_Divisional;
	}
	public void setSoeid_Divisional(String soeid_Divisional) {
		Soeid_Divisional = soeid_Divisional;
	}
	public String getSoeid_Distrital() {
		return Soeid_Distrital;
	}
	public void setSoeid_Distrital(String soeid_Distrital) {
		Soeid_Distrital = soeid_Distrital;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	public String getDistrito() {
		return Distrito;
	}
	public void setDistrito(String distrito) {
		Distrito = distrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getInic() {
		return Inic;
	}
	public void setInic(String inic) {
		Inic = inic;
	}
	public Date getFecha_Inicio() {
		return Fecha_Inicio;
	}
	public void setFecha_Inicio(Date fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}
	public Date getFecha_Termino() {
		return Fecha_Termino;
	}
	public void setFecha_Termino(Date fecha_Termino) {
		Fecha_Termino = fecha_Termino;
	}
	public Long getAlta() {
		return Alta;
	}
	public void setAlta(Long alta) {
		Alta = alta;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public Long getIs_cetes100() {
		return is_cetes100;
	}
	public void setIs_cetes100(Long is_cetes100) {
		this.is_cetes100 = is_cetes100;
	}
	public Long getIs_campesp() {
		return is_campesp;
	}
	public void setIs_campesp(Long is_campesp) {
		this.is_campesp = is_campesp;
	}
	public Long getId_nivel_auto() {
		return id_nivel_auto;
	}
	public void setId_nivel_auto(Long id_nivel_auto) {
		this.id_nivel_auto = id_nivel_auto;
	}
	
	

	
}
