package com.citi.euces.solicitudes.infra.dto;

import java.util.List;

public class EnviarPHPBEDTO {
	
	private String listAurotizadores;
	private String folio;
	private String linkAutoriza;
	private String linkRechaza;
	private String urlRedirect;
    private List<AutorizadoresDivisionalesResponseDTO> listadoAutorizadores;
	private String idAutorizadores;

	public String getListAurotizadores() {
		return listAurotizadores;
	}

	public void setListAurotizadores(String listAurotizadores) {
		this.listAurotizadores = listAurotizadores;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getLinkAutoriza() {
		return linkAutoriza;
	}

	public void setLinkAutoriza(String linkAutoriza) {
		this.linkAutoriza = linkAutoriza;
	}

	public String getLinkRechaza() {
		return linkRechaza;
	}

	public void setLinkRechaza(String linkRechaza) {
		this.linkRechaza = linkRechaza;
	}

	public String getUrlRedirect() { return urlRedirect; }

	public void setUrlRedirect(String urlRedirect) { this.urlRedirect = urlRedirect; }

	public String getIdAutorizadores() { return idAutorizadores; }

	public void setIdAutorizadores(String idAutorizadores) { this.idAutorizadores = idAutorizadores; }

	public List<AutorizadoresDivisionalesResponseDTO> getListadoAutorizadores() {
		return listadoAutorizadores;
	}

	public void setListadoAutorizadores(List<AutorizadoresDivisionalesResponseDTO> listadoAutorizadores) {
		this.listadoAutorizadores = listadoAutorizadores;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailTemplateSolTarifasRequest [listAurotizadores=");
		builder.append(listAurotizadores);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", linkAutoriza=");
		builder.append(linkAutoriza);
		builder.append(", linkRechaza=");
		builder.append(linkRechaza);
		builder.append(", urlRedirect=");
		builder.append(urlRedirect);
		builder.append(", listadoAutorizadores=");
		builder.append(listadoAutorizadores);
		builder.append(", idAutorizadores=");
		builder.append(idAutorizadores);
		builder.append("]");
		return builder.toString();
	}
	
	
}
