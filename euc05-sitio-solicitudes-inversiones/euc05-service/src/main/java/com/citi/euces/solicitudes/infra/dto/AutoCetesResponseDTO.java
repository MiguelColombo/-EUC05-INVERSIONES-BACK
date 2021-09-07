package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;

public class AutoCetesResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	

	private Long Id_Plazo;
	private Long cete;
	/**
	 * @param id_Plazo
	 * @param cete
	 */
	public AutoCetesResponseDTO(Long id_Plazo, Long cete) {
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
