package com.citi.euces.solicitudes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_ASIGNACIONES")
public class Tb_Asignaciones {
	
	@Id
	@Column(name ="ID" )
	private String ID;
	@Column(name ="SOEID" )
	private String SOEID;
	@Column(name ="ONLINE_" )
	private Long ONLINE_;
	@Column(name ="NOMBRE" )
	private String NOMBRE;
	
	public Tb_Asignaciones() {
		
	}

	/**
	 * @param iD
	 * @param sOEID
	 * @param oNLINE_
	 * @param nOMBRE
	 */
	public Tb_Asignaciones(String iD, String sOEID, Long oNLINE_, String nOMBRE) {
		super();
		ID = iD;
		SOEID = sOEID;
		ONLINE_ = oNLINE_;
		NOMBRE = nOMBRE;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSOEID() {
		return SOEID;
	}

	public void setSOEID(String sOEID) {
		SOEID = sOEID;
	}

	public Long getONLINE_() {
		return ONLINE_;
	}

	public void setONLINE_(Long oNLINE_) {
		ONLINE_ = oNLINE_;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

}
