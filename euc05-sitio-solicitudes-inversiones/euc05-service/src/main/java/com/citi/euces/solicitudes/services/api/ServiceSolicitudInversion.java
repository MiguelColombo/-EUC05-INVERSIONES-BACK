package com.citi.euces.solicitudes.services.api;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import com.citi.euces.solicitudes.infra.dto.AutoCetesResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaInsertBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaUpdateVOBOBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutorangoResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutorizadoresBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutorizadoresDivisionalesResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutorizadoresResponseDTO;
import com.citi.euces.solicitudes.infra.dto.DiasFestivosBEDTO;
import com.citi.euces.solicitudes.infra.dto.DiasFestivosResponseDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerAutoDivisionalBEDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerAutoDivisionalResposeDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerRegAutoTasaResposeDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO;
import com.citi.euces.solicitudes.infra.dto.SucursalesBEDTO;
import com.citi.euces.solicitudes.infra.dto.SucursalesPorSucResponseDTO;
import com.citi.euces.solicitudes.infra.dto.TasaPorsentajeBEDTO;
import com.citi.euces.solicitudes.infra.dto.TasaPorsentajeResponceDTO;
import com.citi.euces.solicitudes.infra.dto.TbAutorizadoresElegidosBEDTO;
import com.citi.euces.solicitudes.infra.dto.TbAutorizadoresElegidosResponseDTO;
import com.citi.euces.solicitudes.infra.dto.TipoSolicitudRespoceDTO;
import com.citi.euces.solicitudes.infra.dto.*;
import com.citi.euces.solicitudes.infra.exceptions.GenericException;

public interface ServiceSolicitudInversion {
 
	List<TipoSolicitudRespoceDTO> obtenerSolicitudes() throws GenericException, IOException;
	List <AutorizadoresResponseDTO> checkAutorizadores(SucursalesBEDTO request)throws GenericException, IOException;
	List<DiasFestivosResponseDTO> ObtenerDiasFeriados(DiasFestivosBEDTO request) throws GenericException, IOException;
	List<AutorangoResponseDTO> ObtenerAutoRangos() throws GenericException, IOException;
	List<AutoCetesResponseDTO> ObtenerAutoCetes() throws GenericException, IOException;
	List<SucursalesPorSucResponseDTO> ObtenerSucursalesPorSuc(SucursalesBEDTO request) throws GenericException, IOException;
	List<TasaPorsentajeResponceDTO> ObtenerListaPlazos(TasaPorsentajeBEDTO request) throws GenericException, IOException;
	List<AutoTasaResponseDTO> ObtenerRegCampTasa(AutoTasaBEDTO request) throws GenericException, IOException;
	BigInteger ObtenerUltFolioAutoTasas() throws GenericException, IOException;
	List<AutorizadoresDivisionalesResponseDTO> ObtenerAutorizadoresDivisionales(AutorizadoresBEDTO request)throws GenericException, IOException;
	//String Guardar_Autorizacion(TbAutorizadoresElegidosBEDTO request)throws GenericException, IOException,SQLException;
	List<AutorizadoresDivisionalesResponseDTO> ObtenerAutorizadorAutomatico()throws GenericException, IOException;
	List<AutorizadoresDivisionalesResponseDTO> ObtenerAutorizadoresGerencia()throws GenericException, IOException;  
	AutoTasaInsertResponseDTO Solicitar(AutoTasaInsertBEDTO respoce) throws GenericException, IOException, SQLException;
	String UPDATE_Autorizador_Solicitud(AutoTasaUpdateRequest request)throws GenericException, IOException;
	List<ObtenerRegAutoTasaResposeDTO> ObtenerRegAutoTasa(AutoTasaBEDTO request)throws GenericException, IOException;
	List<ObtenerAutoDivisionalResposeDTO> ObtenerAutoDivisional(ObtenerAutoDivisionalBEDTO request)throws GenericException, IOException;
	String UPDATE_VOBO_AUTOTASAS (AutoTasaUpdateVOBOBEDTO request) throws GenericException, IOException;
	String CalcularSoeidAsignado() throws GenericException, IOException;
	List<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO> ObtenerRegistrosAutoTasasPorEjecutivo(ObtenerRegistrosAutoTasasPorEjecutivoRequest request)throws GenericException, IOException;
	String UPDATE_SOLIC_CANCEL_CAMPTASAS(AutoTasaUpdateCamTasasRequest request)throws GenericException, IOException;
	Long ExisteFolioBancanet()throws GenericException, IOException;
	List<EjecutivoSucursalResponseDTO>getEjecutivo(SucursalesBEDTO request)throws GenericException, IOException;
	List<SucursalesConsultaResponseDTO>GetItem(SucursalesBEDTO request)throws GenericException, IOException;
	EnviarPHPDTO EnviarPHP(EnviarPHPBEDTO request)throws GenericException, IOException;
	List<OfertaResponseDTO> ObtenerOferta(OfertaBEDTO request)throws GenericException, IOException;
	ImpresionResponse pdfEspecial(PlantillaPdfDTO request)throws GenericException, IOException;
//	BigInteger CrearIdAutotsa()throws GenericException, IOException;
	
	
}
