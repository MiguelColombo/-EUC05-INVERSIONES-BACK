package com.citi.euces.solicitudes.restcontrollers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citi.euces.solicitudes.models.ExisteFolioBancanetResponse;
import com.citi.euces.solicitudes.exceptions.ErrorGeneric;
import com.citi.euces.solicitudes.infra.dto.AutoTasaBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaInsertBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaUpdateVOBOBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutorizadoresBEDTO;
import com.citi.euces.solicitudes.infra.dto.DiasFestivosBEDTO;
import com.citi.euces.solicitudes.infra.dto.EnviarPHPBEDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerAutoDivisionalBEDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerAutoDivisionalResposeDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO;
import com.citi.euces.solicitudes.infra.dto.OfertaBEDTO;
import com.citi.euces.solicitudes.infra.dto.PlantillaPdfDTO;
import com.citi.euces.solicitudes.infra.dto.SucursalesBEDTO;
import com.citi.euces.solicitudes.infra.dto.TasaPorsentajeBEDTO;
import com.citi.euces.solicitudes.infra.dto.TasaPorsentajeResponceDTO;
import com.citi.euces.solicitudes.infra.dto.TbAutorizadoresElegidosBEDTO;
import com.citi.euces.solicitudes.infra.dto.TbAutorizadoresElegidosResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaResponses;
import com.citi.euces.solicitudes.infra.dto.AutoTasaUpdateCamTasasRequest;
import com.citi.euces.solicitudes.infra.dto.AutoTasaUpdateRequest;
import com.citi.euces.solicitudes.infra.dto.ObtenerRegistrosAutoTasasPorEjecutivoRequest;
import com.citi.euces.solicitudes.infra.dto.TbAutorizadoresElegidosRResponse;
import com.citi.euces.solicitudes.infra.dto.Tb_AsignacionesResponse;
import com.citi.euces.solicitudes.infra.exceptions.GenericException;
import com.citi.euces.solicitudes.models.AutoCetesResponse;
import com.citi.euces.solicitudes.models.AutoTasaResponse;
import com.citi.euces.solicitudes.models.AutorangoResponse;
import com.citi.euces.solicitudes.models.AutorizadoresDivisionalesResponse;
import com.citi.euces.solicitudes.models.AutorizadoresResponse;
import com.citi.euces.solicitudes.models.CalcularSoeidAsignadoResponse;
import com.citi.euces.solicitudes.models.ConfirmacionResponce;
import com.citi.euces.solicitudes.models.ConfirmacionResponce;
import com.citi.euces.solicitudes.models.DiasFestivosResponse;
import com.citi.euces.solicitudes.models.EjecutivoSucursalResponse;
import com.citi.euces.solicitudes.models.EnviarPHPResponse;
import com.citi.euces.solicitudes.models.FolioAutoTasaResponse;
import com.citi.euces.solicitudes.models.ObtenerAutoDivisionalRespose;
import com.citi.euces.solicitudes.models.ObtenerRegAutoTasaRespose;
import com.citi.euces.solicitudes.models.ObtenerRegistrosAutoTasasPorEjecutivoRespose;
import com.citi.euces.solicitudes.models.OfertaResponse;
import com.citi.euces.solicitudes.models.SoImprimeRespon;
import com.citi.euces.solicitudes.models.SolicitudResponse;
import com.citi.euces.solicitudes.models.SucursalesConsultaResponse;
import com.citi.euces.solicitudes.models.SucursalesPorSucResponse;
import com.citi.euces.solicitudes.models.TasaPorsentajeResponce;
import com.citi.euces.solicitudes.services.ServiceSolicitudInversionImp;


@RestController
//@RequestMapping(ServiceSolicitudInversionController.GR_RESOURCE)
@RequestMapping(ServiceSolicitudInversionController.GREETING_RESOURCE)
public class ServiceSolicitudInversionController  {
	private static final Logger LOGGER = LogManager.getLogger(ServiceSolicitudInversionController.class);
	
	static final String GREETING_RESOURCE = "/SolicitudDeInversion";
	

	@Autowired
	ServiceSolicitudInversionImp serviceSolicitudInversionImp;
	
	//Page_Load
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/ObtenerAutoRangos", produces = "application/json")//CargarGrid CrearFuncionJavaRangos
	public  ResponseEntity<?> ObtenerAutoRangos(){
		try {
	
			AutorangoResponse response  = new AutorangoResponse(serviceSolicitudInversionImp.ObtenerAutoRangos(), "200");
			if(response.getAutorango() == null || response.getAutorango().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<AutorangoResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerSucursalesPorSuc", produces = "application/json") //CrearFuncionesJavaScript 
	public ResponseEntity<?> ObtenerSucursalesPorSuc(@RequestBody final SucursalesBEDTO request){
	try {
		SucursalesPorSucResponse response  = new SucursalesPorSucResponse(serviceSolicitudInversionImp.ObtenerSucursalesPorSuc(request), "200");
		if(response.getSucursalesPorSuc() == null || response.getSucursalesPorSuc().size() == 0) {
			throw new GenericException("No se puede procesar la solicitud","500");
		}else {			
			return new ResponseEntity<SucursalesPorSucResponse>(response, HttpStatus.OK);
		}
	}catch (GenericException ex) {
		ErrorGeneric error = new ErrorGeneric();
		error.setCode(ex.getCodeError());
		error.setMensaje(ex.getMessage());
		error.setError("Parametros Incorrecto o Parametros no existen".toString());
		return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
	} catch (Exception e) {
		ErrorGeneric error = new ErrorGeneric();
		error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		error.setMensaje(e.getMessage());
		error.setError(e);
		return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
	}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerListaPlazos", produces = "application/json") //CrearFuncionesJavaScript faltan
	public ResponseEntity<?> ObtenerListaPlazos(@RequestBody final TasaPorsentajeBEDTO request) {
		try {
			TasaPorsentajeResponce response  = new TasaPorsentajeResponce(serviceSolicitudInversionImp.ObtenerListaPlazos(request), "200");
			if(response.getTasaPorsentaje() == null || response.getTasaPorsentaje().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<TasaPorsentajeResponce>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path ="/ObtenerAutoCetes", produces = "application/json") //CrearFuncionJavaCurvaCETES
	public  ResponseEntity<?> ObtenerAutoCetes(){
		try {
			AutoCetesResponse response  = new AutoCetesResponse(serviceSolicitudInversionImp.ObtenerAutoCetes(), "200");
			if(response.getAutoCetes() == null || response.getAutoCetes().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<AutoCetesResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerDiasFeriados", produces = "application/json")
	public  ResponseEntity<?> ObtenerDiasFeriados(@RequestBody final DiasFestivosBEDTO request){
		try {
			DiasFestivosResponse response  = new DiasFestivosResponse(serviceSolicitudInversionImp.ObtenerDiasFeriados(request), "200");
			if(response.getDiasFestivos() == null || response.getDiasFestivos().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<DiasFestivosResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	//Page_Load
	
	//btnCheckautorizadores_Click
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/autorizador", produces = "application/json") //Obtener autorizadore para el boton ver auatorizadores
	public ResponseEntity<?> checkAutorizadores(@RequestBody final SucursalesBEDTO request){
		try {
		AutorizadoresResponse response = new AutorizadoresResponse(serviceSolicitudInversionImp.checkAutorizadores(request), "200");
		if(response.getAutorizadores() == null || response.getAutorizadores().size() == 0) {
			throw new GenericException("No se puede procesar la solicitud","500");
		}else {			
			return new ResponseEntity<AutorizadoresResponse>(response, HttpStatus.OK);
		}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	//btnCheckautorizadores_Click
	

	//btnSave_Click
	
	
	/*las que se requiere enviar el correo,
	 * para enviar a personal de la UEC 
	 * 	para enviar copia a personal de la UEC  */
	
	//ObtenerAutoCetes()
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/ObtenerUltFolioAutoTasas", produces = "application/json")//u
	public ResponseEntity<?> ObtenerUltFolioAutoTasas(){
		try {
			FolioAutoTasaResponse response = new FolioAutoTasaResponse(serviceSolicitudInversionImp.ObtenerUltFolioAutoTasas(), "200");
			return new ResponseEntity<FolioAutoTasaResponse>(response,HttpStatus.OK);
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
    //ObtenerListaPlazos()
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/AutorizadoresDivisionales", produces = "application/json")                                                                                  
	public ResponseEntity<?> ObtenerAutorizadoresDivisionales(@RequestBody final AutorizadoresBEDTO request){
		try {
			AutorizadoresDivisionalesResponse response = new AutorizadoresDivisionalesResponse(serviceSolicitudInversionImp.ObtenerAutorizadoresDivisionales(request), "200");
			if(response.getAutorizadoresDivisionales() == null || response.getAutorizadoresDivisionales().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<AutorizadoresDivisionalesResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	// ExisteFolioBancanet  F PEGUNTAR
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/GuardarAutorizacion", produces = "application/json") //btnSave_Click
	public ResponseEntity<?> Guardar_Autorizacion(@RequestBody final TbAutorizadoresElegidosBEDTO request) {
		try {
			String mensaje = serviceSolicitudInversionImp.Guardar_Autorizacion(request);
			if(mensaje == null || mensaje.isEmpty()) {
				throw new GenericException("No se puede procesar la solicitud","500");	
			}else {
				ConfirmacionResponce response = new ConfirmacionResponce(mensaje, "200");
				return new ResponseEntity<ConfirmacionResponce>(response,HttpStatus.OK);
			}
		} catch (GenericException ex) {
			System.out.println("etro");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametro no encontrado".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("etro 2");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode("500");
			error.setMensaje("No se puede procesar la solicitud");
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}	
    }
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/ObtenerAutorizadorAutomatico", produces = "application/json") //Validar Folio btnSave_Click
	public ResponseEntity<?> ObtenerAutorizadorAutomatico(){
		try {
			AutorizadoresDivisionalesResponse response = new AutorizadoresDivisionalesResponse(serviceSolicitudInversionImp.ObtenerAutorizadorAutomatico(), "200");
			if(response.getAutorizadoresDivisionales() == null || response.getAutorizadoresDivisionales().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<AutorizadoresDivisionalesResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/ObtenerAutorizadoresGerencia", produces = "application/json")//Validar Folio btnSave_Click
	public ResponseEntity<?> ObtenerAutorizadoresGerencia(){
		try {
			AutorizadoresDivisionalesResponse response = new AutorizadoresDivisionalesResponse(serviceSolicitudInversionImp.ObtenerAutorizadoresGerencia(), "200");
			if(response.getAutorizadoresDivisionales() == null || response.getAutorizadoresDivisionales().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<AutorizadoresDivisionalesResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/Solicitar", produces = "application/json") //btnSave_Click
	public  ResponseEntity<?> Solicitar(@RequestBody final AutoTasaInsertBEDTO request) {
		try {
			String mensaje =serviceSolicitudInversionImp.Solicitar(request);
			if(mensaje == null || mensaje.isEmpty()) {
				throw new GenericException("No se puede procesar la solicitud","500");	
			}else {
				ConfirmacionResponce response = new ConfirmacionResponce(mensaje, "200");
				return new ResponseEntity<ConfirmacionResponce>(response,HttpStatus.OK);
			}
		} catch (GenericException ex) {
			System.out.println("etro");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametro no encontrado".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("etro 2");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode("500");
			error.setMensaje("No se puede procesar la solicitud");
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping(path ="/Actualizar_Solicitud", produces = "application/json")//btnSave_Click
	public ResponseEntity<?> UPDATE_Autorizador_Solicitud(@RequestBody final AutoTasaUpdateRequest request) {
		try {
			String mensaje = serviceSolicitudInversionImp.UPDATE_Autorizador_Solicitud(request); 
			if(mensaje == null || mensaje.isEmpty()) {
				throw new GenericException("No se puede procesar la solicitud","500");	
			}else {
				ConfirmacionResponce response = new ConfirmacionResponce(mensaje, "200");
				return new ResponseEntity<ConfirmacionResponce>(response,HttpStatus.OK);
			}
			
		} catch (GenericException ex) {
			System.out.println("etro");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametro no encontrado".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("etro 2");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode("500");
			error.setMensaje("No se puede procesar la solicitud");
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			
		}
	}
	//btnSave_Click
	
	
	//CalcularSoeidAsignado
	
	@ResponseStatus(code = HttpStatus.OK) ///u
	@GetMapping(path ="/CalcularSoeidAsignado", produces = "application/json")
	public ResponseEntity<?> CalcularSoeidAsignado(){
		try {
			CalcularSoeidAsignadoResponse response  = new CalcularSoeidAsignadoResponse(serviceSolicitudInversionImp.CalcularSoeidAsignado(), "200");
			return new ResponseEntity<CalcularSoeidAsignadoResponse>(response, HttpStatus.OK);
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	//CalcularSoeidAsignado
	
	//EnviarPHP   
	//ObtenerSucursalesPorSuc();
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerRegCampTasa", produces = "application/json") //EnviarPHP AutoTasaResponseDTO
	public ResponseEntity<?> ObtenerRegCampTasa(@RequestBody final AutoTasaBEDTO request){
		try {
			AutoTasaResponse response  = new AutoTasaResponse(serviceSolicitudInversionImp.ObtenerRegCampTasa(request), "200");
			if(response.getObtenerRegCampTasa() == null || response.getObtenerRegCampTasa().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<AutoTasaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	//EnviarPHP

	//Obtener Tipo de solicitud
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/solicitud", produces = "application/json") 
	public ResponseEntity<?> obtenerSolicitudes(){
		
		try {
			SolicitudResponse response  = new SolicitudResponse(serviceSolicitudInversionImp.obtenerSolicitudes(), "200");
			if(response.getTipoSolicitud() == null || response.getTipoSolicitud().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<SolicitudResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}

	//Obtener Tipo de solicitud

	
	//btnEnviar_Click VOBO
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/ObtenerRegAutoTasa", produces = "application/json") // F PREGUNTA
	public ResponseEntity<?> ObtenerRegAutoTasa(@RequestBody final AutoTasaBEDTO request){// ObtenerRegAutoTasaResposeDTO
		try {
			ObtenerRegAutoTasaRespose response  = new ObtenerRegAutoTasaRespose(serviceSolicitudInversionImp.ObtenerRegAutoTasa(request), "200");
			if(response.getObtenerRegAutoTasa() == null || response.getObtenerRegAutoTasa().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<ObtenerRegAutoTasaRespose>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/ObtenerAutoDivisional", produces = "application/json")//falta
	public ResponseEntity<?> ObtenerAutoDivisional(@RequestBody final ObtenerAutoDivisionalBEDTO request){ //ObtenerAutoDivisionalRespose
		try {
			ObtenerAutoDivisionalRespose response  = new ObtenerAutoDivisionalRespose(serviceSolicitudInversionImp.ObtenerAutoDivisional(request), "200");
			if(response.getObtenerAutoDivisional() == null || response.getObtenerAutoDivisional().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<ObtenerAutoDivisionalRespose>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping(path ="/Actualizar_VOBO", produces = "application/json")
	public ResponseEntity<?> UPDATE_VOBO_AUTOTASAS( @RequestBody final AutoTasaUpdateVOBOBEDTO request) {
		
		try {
			String mensaje = serviceSolicitudInversionImp.UPDATE_VOBO_AUTOTASAS(request); 
			if(mensaje == null || mensaje.isEmpty()) {
				throw new GenericException("No se puede procesar la solicitud","500");	
			}else {
				ConfirmacionResponce response = new ConfirmacionResponce(mensaje, "200");
				return new ResponseEntity<ConfirmacionResponce>(response,HttpStatus.OK);
			}
		} catch (GenericException ex) {
			System.out.println("etro");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametro no encontrado".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("etro 2");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode("500");
			error.setMensaje("No se puede procesar la solicitud");
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			
		}	
	}
	//btnEnviar_Click VOBO
	

	//UpdateEstatus --
	//ObtenerRegAutoTasa()
	//ObtenerAutoDivisional()
	//CalcularSoeidAsignado()
	//UPDATE_VOBO_AUTOTASAS()
	//ObtenerSucursalesPorSuc()
	//UpdateEstatus --
	
	//EnviarPHP
	//ObtenerSucursalesPorSuc()
	//EnviarPHP
	
    /// ----------Vista Ejecutivo ---------------
	//LoadData
	@PostMapping(path = "/ObtenerRegistrosAutoTasasPorEjecutivo", produces = "application/json")//prueba
	public ResponseEntity<?> ObtenerRegistrosAutoTasasPorEjecutivo(
			@RequestBody final ObtenerRegistrosAutoTasasPorEjecutivoRequest request){
    try{
		ObtenerRegistrosAutoTasasPorEjecutivoRespose response  = new ObtenerRegistrosAutoTasasPorEjecutivoRespose(serviceSolicitudInversionImp.ObtenerRegistrosAutoTasasPorEjecutivo(request), "200");
		if(response.getObtenerRegistrosAutoTasasPorEjecutivo() == null || response.getObtenerRegistrosAutoTasasPorEjecutivo().size() == 0) {
			throw new GenericException("No se puede procesar la solicitud","500");
		}else {			
			return new ResponseEntity<ObtenerRegistrosAutoTasasPorEjecutivoRespose>(response, HttpStatus.OK);
		}
	}catch (GenericException ex) {
		ErrorGeneric error = new ErrorGeneric();
		error.setCode(ex.getCodeError());
		error.setMensaje(ex.getMessage());
		error.setError("Parametros Incorrecto o Parametros no existen".toString());
		return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
	} catch (Exception e) {
		ErrorGeneric error = new ErrorGeneric();
		error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		error.setMensaje(e.getMessage());
		error.setError(e);
		return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
	}
	}
	
	//LoadData
	
	
	//ImageButtonClick
	//ObtenerRegCampTasa();
	//ImageButtonClick

	
	
	//btnSave_Click1
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/UPDATE_SOLIC_CANCEL_CAMPTASAS", produces = "application/json")//btnSave_Click put
	public ResponseEntity<?> UPDATE_SOLIC_CANCEL_CAMPTASAS(@RequestBody final AutoTasaUpdateCamTasasRequest request) {
		try {		
			String mensaje = serviceSolicitudInversionImp.UPDATE_SOLIC_CANCEL_CAMPTASAS(request); 
			if(mensaje == null || mensaje.isEmpty()) {
				throw new GenericException("No se puede procesar la solicitud","500");	
			}else {
				ConfirmacionResponce response = new ConfirmacionResponce(mensaje, "200");
				return new ResponseEntity<ConfirmacionResponce>(response,HttpStatus.OK);
			}
		} catch (GenericException ex) {
			System.out.println("etro");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametro no encontrado".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("etro 2");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode("500");
			error.setMensaje("No se puede procesar la solicitud");
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			
		}	
		
	}
	//CalcularSoeidAsignado()
	//ObtenerRegCampTasa();
	//btnSave_Click1
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/ExisteFolioBancanet", produces = "application/json")//u
	public ResponseEntity<?>  ExisteFolioBancanet(){
		try {
			ExisteFolioBancanetResponse response = new ExisteFolioBancanetResponse(serviceSolicitudInversionImp.ExisteFolioBancanet(), "200");
			return new ResponseEntity<ExisteFolioBancanetResponse>(response,HttpStatus.OK);
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/GetEjecutivo", produces = "application/json")//btnSave_Click put
	public ResponseEntity<?> getEjecutivo(@RequestBody final SucursalesBEDTO request) {
		 try{
			 EjecutivoSucursalResponse response  = new EjecutivoSucursalResponse(serviceSolicitudInversionImp.getEjecutivo(request), "200");
			if(response.getEjecutivoSucursalResponseDTO() == null || response.getEjecutivoSucursalResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<EjecutivoSucursalResponse>(response, HttpStatus.OK);
			}
			}catch (GenericException ex) {
				ErrorGeneric error = new ErrorGeneric();
				error.setCode(ex.getCodeError());
				error.setMensaje(ex.getMessage());
				error.setError("Parametros Incorrecto o Parametros no existen".toString());
				return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			} catch (Exception e) {
				ErrorGeneric error = new ErrorGeneric();
				error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
				error.setMensaje(e.getMessage());
				error.setError(e);
				return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			}
	    }
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/GetItem", produces = "application/json")//btnSave_Click put
	public ResponseEntity<?> GetItem(@RequestBody final SucursalesBEDTO request) {
		 try{
			 SucursalesConsultaResponse response  = new SucursalesConsultaResponse(serviceSolicitudInversionImp.GetItem(request), "200");
			if(response.getSucursalesConsultaResponse() == null || response.getSucursalesConsultaResponse().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<SucursalesConsultaResponse>(response, HttpStatus.OK);
			}
			}catch (GenericException ex) {
				ErrorGeneric error = new ErrorGeneric();
				error.setCode(ex.getCodeError());
				error.setMensaje(ex.getMessage());
				error.setError("Parametros Incorrecto o Parametros no existen".toString());
				return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			} catch (Exception e) {
				ErrorGeneric error = new ErrorGeneric();
				error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
				error.setMensaje(e.getMessage());
				error.setError(e);
				return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			}
	    }
	
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/EnviarPHP", produces = "application/json")//btnSave_Click put
	public ResponseEntity<?> EnviarPHP(@RequestBody final EnviarPHPBEDTO request) {
		 try{
			 EnviarPHPResponse response  = new EnviarPHPResponse(serviceSolicitudInversionImp.EnviarPHP(request), "200");
			 if(response.getEnviarPHPDTO() == null || response.getEnviarPHPDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<EnviarPHPResponse>(response, HttpStatus.OK);
			}
			}catch (GenericException ex) {
				ErrorGeneric error = new ErrorGeneric();
				error.setCode(ex.getCodeError());
				error.setMensaje(ex.getMessage());
				error.setError("Parametros Incorrecto o Parametros no existen".toString());
				return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			} catch (Exception e) {
				ErrorGeneric error = new ErrorGeneric();
				error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
				error.setMensaje(e.getMessage());
				error.setError(e);
				return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			}
	    }	
	
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/ObtenerOferta", produces = "application/json")//btnSave_Click put
	public ResponseEntity<?> ObtenerOferta(@RequestBody final OfertaBEDTO request) {
		 try{
			 OfertaResponse response  = new OfertaResponse(serviceSolicitudInversionImp.ObtenerOferta(request), "200");
			 if(response.getOfertaResponseDTO() == null || response.getOfertaResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<OfertaResponse>(response, HttpStatus.OK);
			}
			}catch (GenericException ex) {
				ErrorGeneric error = new ErrorGeneric();
				error.setCode(ex.getCodeError());
				error.setMensaje(ex.getMessage());
				error.setError("Parametros Incorrecto o Parametros no existen".toString());
				return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			} catch (Exception e) {
				ErrorGeneric error = new ErrorGeneric();
				error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
				error.setMensaje(e.getMessage());
				error.setError(e);
				return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			}
	    }	
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/pdfEspecial")
	public ResponseEntity<?> pdfEspecial(@RequestBody final PlantillaPdfDTO request) {
		try {
			System.out.println("35 linea codigo request->" + request);
			SoImprimeRespon response = new SoImprimeRespon(serviceSolicitudInversionImp.pdfEspecial(request), "200");
			return new ResponseEntity<SoImprimeRespon>(response, HttpStatus.OK);
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
}
