package com.citi.euces.solicitudes.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_PARAMETROS")
public class TipoSolicitud implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="ID" )
	private int id;
	@Column(name ="EUC" )
	private int euc;
	@Column(name ="DESCRIPTION")
	private String nombre;
	@Column(name ="VALOR")
	private String VALOR;
	
	public TipoSolicitud() {

	}

	/**
	 * @param id
	 * @param euc
	 * @param nombre
	 * @param vALOR
	 */
	public TipoSolicitud(int id, int euc, String nombre, String vALOR) {
		super();
		this.id = id;
		this.euc = euc;
		this.nombre = nombre;
		VALOR = vALOR;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEuc() {
		return euc;
	}

	public void setEuc(int euc) {
		this.euc = euc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVALOR() {
		return VALOR;
	}

	public void setVALOR(String vALOR) {
		VALOR = vALOR;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
