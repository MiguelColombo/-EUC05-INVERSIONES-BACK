package com.citi.euces.solicitudes.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_AUTOCETES")
public class AutoCetes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name ="ID_PLAZO" )
	private Long Id_Plazo;
	@Column(name ="CETE" )
	private Long cete;
	/**
	 * @param id_Plazo
	 * @param cete
	 */
	public AutoCetes() {
		
	}
	public AutoCetes(Long id_Plazo, Long cete) {
		super();
		Id_Plazo = id_Plazo;
		this.cete = cete;
	}
	public Long getId_Plazo() {
		return Id_Plazo;
	}
	public void setId_Plazo(Long id_Plazo) {
		Id_Plazo = id_Plazo;
	}
	public Long getCete() {
		return cete;
	}
	public void setCete(Long cete) {
		this.cete = cete;
	}
	
	

}
