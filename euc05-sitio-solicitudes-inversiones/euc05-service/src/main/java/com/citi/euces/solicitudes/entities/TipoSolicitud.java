package com.citi.euces.solicitudes.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACE_CAT_EUC")
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
	
	public TipoSolicitud() {
		
	}
    public TipoSolicitud(int id,int euc, String nombre) {
    	this.id = id;
    	this.euc = euc;
    	this.nombre = nombre;
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

}
