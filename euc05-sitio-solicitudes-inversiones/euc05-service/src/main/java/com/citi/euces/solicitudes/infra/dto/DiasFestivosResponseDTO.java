package com.citi.euces.solicitudes.infra.dto;

import java.io.Serializable;
import java.util.Date;


public class DiasFestivosResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	private Long PlazoReal; 
	private String Vigencia;
	
	public DiasFestivosResponseDTO(Long plazoReal, String vigencia) {
		super();
		PlazoReal = plazoReal;
		Vigencia = vigencia;
	}
	public Long getPlazoReal() {
		return PlazoReal;
	}
	public void setPlazoReal(Long plazoReal) {
		PlazoReal = plazoReal;
	}
	public String getVigencia() {
		return Vigencia;
	}
	public void setVigencia(String vigencia) {
		Vigencia = vigencia;
	}


	/*private Integer id_feriados;
	private String Descripcion;
	private Date fecha;

	public DiasFestivosResponseDTO(Integer id_feriados, String descripcion, Date fecha) {
		super();
		this.id_feriados = id_feriados;
		Descripcion = descripcion;
		this.fecha = fecha;
	}
	public Integer getId_feriados() {
		return id_feriados;
	}
	public void setId_feriados(Integer id_feriados) {
		this.id_feriados = id_feriados;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	*/
	
}
