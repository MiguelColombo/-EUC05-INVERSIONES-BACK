package com.citi.euces.solicitudes.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UEC_TB_CAT_FECHAS_FESTIVAS")
public class DiasFestivos implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="ID_FECHA" )
	private Long ID_FECHA;
	@Column(name ="DESCRIPCION" )
	private String DESCRIPCION;
	@Column(name ="FECHA" )
	private Date FECHA;

	/**
	 * 
	 */
	public DiasFestivos() {
		super();
	}

	/**
	 * @param iD_FECHA
	 * @param dESCRIPCION
	 * @param fECHA
	 */
	public DiasFestivos(Long iD_FECHA, String dESCRIPCION, Date fECHA) {
		super();
		ID_FECHA = iD_FECHA;
		DESCRIPCION = dESCRIPCION;
		FECHA = fECHA;
	}

	public Long getID_FECHA() {
		return ID_FECHA;
	}

	public void setID_FECHA(Long iD_FECHA) {
		ID_FECHA = iD_FECHA;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public Date getFECHA() {
		return FECHA;
	}

	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}
	
	

}
