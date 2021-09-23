package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;

public class AutoCetesResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	

	private Long Id_Plazo;
	private double cete;
	/**
	 * @param id_Plazo
	 * @param cete
	 */
	public AutoCetesResponseDTO(Long id_Plazo, double cete) {
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
	public double getCete() {
		return cete;
	}
	public void setCete(double cete) {
		this.cete = cete;
	}
	

}
