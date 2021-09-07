package com.citi.euces.solicitudes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_AUTO_AUTODIVISIONALES")
public class Tb_Auto_AutoDivisionales {
	
	@Id
	@Column(name ="SOEID" )
	private String Soeid;
	@Column(name ="DIVISION" )
	private String Division;
	@Column(name ="NOMBRE" )
	private String nombre;
	@Column(name ="INIC" )
	private String Inic;
	@Column(name ="FECHA_INICIO" )
	private String Fecha_Inicio;
	@Column(name ="FECHA_TERMINO" )
	private String Fecha_Termino;
	@Column(name ="ALTA" )
	private Long Alta;
	@Column(name ="CORREO" )
	private String Correo;
	@Column(name ="IS_CETE100" )
	private Long is_cetes100;
	@Column(name ="IS_CAMPESP" )
	private Long is_campesp;
	@Column(name ="TIPO" )
	private String TIPO;

	public Tb_Auto_AutoDivisionales() {
		
	}

	/**
	 * @param soeid
	 * @param division
	 * @param nombre
	 * @param inic
	 * @param fecha_Inicio
	 * @param fecha_Termino
	 * @param alta
	 * @param correo
	 * @param tipo
	 * @param is_cetes100
	 * @param is_campesp
	 */
	public Tb_Auto_AutoDivisionales(String soeid, String division, String nombre, String inic, String fecha_Inicio,
			String fecha_Termino, Long alta, String correo, Long is_cetes100, Long is_campesp, String TIPO) {
		super();
		Soeid = soeid;
		Division = division;
		this.nombre = nombre;
		Inic = inic;
		Fecha_Inicio = fecha_Inicio;
		Fecha_Termino = fecha_Termino;
		Alta = alta;
		Correo = correo;
		this.TIPO = TIPO;
		this.is_cetes100 = is_cetes100;
		this.is_campesp = is_campesp;
	}

	public String getSoeid() {
		return Soeid;
	}

	public void setSoeid(String soeid) {
		Soeid = soeid;
	}

	public String getDivision() {
		return Division;
	}

	public void setDivision(String division) {
		Division = division;
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

	public String getFecha_Inicio() {
		return Fecha_Inicio;
	}

	public void setFecha_Inicio(String fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}

	public String getFecha_Termino() {
		return Fecha_Termino;
	}

	public void setFecha_Termino(String fecha_Termino) {
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

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}
	
	
}
