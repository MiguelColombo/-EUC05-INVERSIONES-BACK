package com.citi.euces.solicitudes.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.citi.euces.solicitudes.entities.AutoCetes;
import com.citi.euces.solicitudes.entities.AutoTasa;
import com.citi.euces.solicitudes.entities.AutoTasasPorEjecutivo;
import com.citi.euces.solicitudes.entities.Autorizadores;
import com.citi.euces.solicitudes.entities.DiasFestivos;
import com.citi.euces.solicitudes.entities.TasaPorsentaje;
import com.citi.euces.solicitudes.entities.Autorango;
import com.citi.euces.solicitudes.entities.TbAutorizadoresElegidos;
import com.citi.euces.solicitudes.entities.Tb_Asignaciones;
import com.citi.euces.solicitudes.entities.Tb_Auto_AutoDivisionales;
import com.citi.euces.solicitudes.entities.Tb_Auto_AutoFacultados;
import com.citi.euces.solicitudes.entities.Tb_Auto_AutoRegionales;
import com.citi.euces.solicitudes.entities.TipoSolicitud;
import com.citi.euces.solicitudes.entities.Sucursales;
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
import com.citi.euces.solicitudes.infra.dto.AutoTasaResponses;
import com.citi.euces.solicitudes.infra.dto.AutoTasaUpdateCamTasasRequest;
import com.citi.euces.solicitudes.infra.dto.AutoTasaUpdateRequest;
import com.citi.euces.solicitudes.infra.dto.ObtenerRegistrosAutoTasasPorEjecutivoRequest;
import com.citi.euces.solicitudes.infra.dto.TbAutorizadoresElegidosRResponse;
import com.citi.euces.solicitudes.infra.dto.Tb_AsignacionesResponse;
import com.citi.euces.solicitudes.infra.exceptions.GenericException;
import com.citi.euces.solicitudes.repositories.AutoCetesRepo;
import com.citi.euces.solicitudes.repositories.AutoTasaRepo;
import com.citi.euces.solicitudes.repositories.AutorizadoresRepo;
import com.citi.euces.solicitudes.repositories.DiasFestivosRepo;
import com.citi.euces.solicitudes.repositories.ObtenerRegistrosAutoTasasPorEjecutivoRepo;
import com.citi.euces.solicitudes.repositories.SucursalesRepo;
import com.citi.euces.solicitudes.repositories.TasaPorsentajeRespo;
import com.citi.euces.solicitudes.repositories.AutorangoRepo;
import com.citi.euces.solicitudes.repositories.TbAutorizadoresElegidosRepo;
import com.citi.euces.solicitudes.repositories.Tb_AsignacionesRepo;
import com.citi.euces.solicitudes.repositories.Tb_Auto_AutoDivisionalesRepo;
import com.citi.euces.solicitudes.repositories.Tb_Auto_AutoFacultadosRepo;
import com.citi.euces.solicitudes.repositories.Tb_Auto_AutoRegionalesRepo;
import com.citi.euces.solicitudes.repositories.TipoSolicitudRepo;
import com.citi.euces.solicitudes.services.api.ServiceSolicitudInversion;





@Service 
public class ServiceSolicitudInversionImp implements ServiceSolicitudInversion {
	private static final Logger LOGGER = LogManager.getLogger(ServiceSolicitudInversionImp.class);

	List<Autorizadores> lstAut = null;
	List<DiasFestivos> lstdias = null;
	List<Autorango>   lstRango = null;
	List<TasaPorsentaje> listPorsentaje = null;
	List<Sucursales> listSucursal = null;
	List<AutoTasa> listAutoTasa = null;
	List<AutoCetes> listCetes = null;
	List<TbAutorizadoresElegidos> tbAutorizadoresElegidosResponse = null;
	List<Tb_Auto_AutoDivisionales> listAutoDivisionales = null;
	List<Tb_Auto_AutoFacultados> listAutoFacultados = null;
	List<Tb_Auto_AutoRegionales> listAutoRegionales = null;
	List<Tb_Asignaciones> listAsignacion = null;
	List<AutoTasasPorEjecutivo> listAutoTasaPor = null;
	Long id_Tasa;
	BigInteger id_Tasa_long;
	BigInteger valida ;
	double porsentaje  ;
	double tasa100Porc;
	
	
	@Autowired
	TipoSolicitudRepo tipoSolicitudRepo;
	@Autowired
	AutorizadoresRepo autorizadoresRepo;
	@Autowired
	SucursalesRepo sucursalesRepo;
	@Autowired
	AutorangoRepo tbAutorangoRepo;
	@Autowired
	AutoTasaRepo autoTasaRepo;
	@Autowired
	TbAutorizadoresElegidosRepo tbAutorizadoresElegidosRepo;
	@Autowired
	Tb_Auto_AutoDivisionalesRepo tb_Auto_AutoDivisionalesRepo;
	@Autowired
	Tb_Auto_AutoRegionalesRepo tb_Auto_AutoRegionalesRepo;
	@Autowired
	Tb_Auto_AutoFacultadosRepo tb_Auto_AutoFacultadosRepo;
	@Autowired
	Tb_AsignacionesRepo tb_AsignacionesRepo;
	@Autowired
	AutoCetesRepo autoCetesRepo;
	@Autowired
	TasaPorsentajeRespo tasaPorsentajeRespo;
	@Autowired
	ObtenerRegistrosAutoTasasPorEjecutivoRepo obtenerRegistrosAutoTasasPorEjecutivoRepo;
	@Autowired
	DiasFestivosRepo diasFestivosRepo;

	@Override
	public List<TipoSolicitudRespoceDTO> obtenerSolicitudes() throws GenericException, IOException {
		try{
			
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return tipoSolicitudRepo.solicitud().stream()
				.map(this::TipoSolicitudToDto)
				.collect(Collectors.toList()); 
	}
	public TipoSolicitudRespoceDTO TipoSolicitudToDto (TipoSolicitud t) {
		TipoSolicitudRespoceDTO responce = new TipoSolicitudRespoceDTO();
		responce.setId(t.getEuc());
		responce.setNombre(t.getNombre());
		responce.setValor(t.getVALOR());
		
		return responce;
	}
	
	@Override
	public List<AutorizadoresResponseDTO> checkAutorizadores(SucursalesBEDTO request) throws GenericException, IOException  { //si
		List<AutorizadoresResponseDTO> lstAut2 = new  ArrayList<AutorizadoresResponseDTO>();
		String puesto;
		BigInteger id = new BigInteger(request.getId());
		String distrito = sucursalesRepo.ObtenerRegionDeNumSuc(id);
		try {
		LOGGER.debug( distrito );
			switch (request.getId_Solicitud().intValue()) {
				case 1:		
					lstAut = autorizadoresRepo.ObtenerAutorizadoresDivisionalesXDivision(request.getDivision(),request.getSoeid());
					for(Autorizadores au : lstAut) {
						puesto = (au.getDivision().equals("Gerencia")) ? "Gerencia:":"Divisional:";
						lstAut2.add(new AutorizadoresResponseDTO (au.getSoeid(),puesto+au.getNombre()));
					}
				break;
				default:
					lstAut = autorizadoresRepo.ObtenerAutorizadoresDistritoFacultados(distrito);
					for(Autorizadores au : lstAut) {
						LOGGER.debug( au.getId_nivel_auto());
						if(Integer.parseInt(au.getId_nivel_auto().toString()) == 2 ) {
							LOGGER.debug( "entro");
								puesto = "Distrital:";
								LOGGER.debug( au.getSoeid()+ " "+puesto+au.getNombre() );
								lstAut2.add(new AutorizadoresResponseDTO (au.getSoeid(),puesto+au.getNombre()));			
						}
						if (Integer.parseInt(au.getId_nivel_auto().toString()) == 3) {
							LOGGER.debug( "entro");
								puesto = "Facultado:";
								LOGGER.debug( au.getSoeid()+ " "+puesto+au.getNombre() );
								lstAut2.add(new AutorizadoresResponseDTO (au.getSoeid(),puesto+au.getNombre()));
						}
					}
							
				break; 			
			}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}						
		return lstAut2;
	}
	
	public ServiceSolicitudInversionImp() {				   
	}




	@Override
	public List<AutorangoResponseDTO> ObtenerAutoRangos() throws GenericException, IOException{ //si
        try{
			
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return tbAutorangoRepo.autoRango().stream()
				.map(this::obtenerAutoRangosToDto)
				.collect(Collectors.toList()); 
	}
	public AutorangoResponseDTO obtenerAutoRangosToDto (Autorango t) {
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
		AutorangoResponseDTO responce = new AutorangoResponseDTO();
		responce.setId_Rango(t.getId_Rango());
		responce.setRangoMin(t.getRangoMin());
		responce.setRangoMax(t.getRangoMax());
		responce.setMILL_DOSMILLQUIN(t.getMILL_DOSMILLQUIN());
		responce.setFECHA(objSDF2.format(t.getFECHA()));
		responce.setFECHAFIN(objSDF2.format(t.getFECHAFIN()));
		
		return responce;
	}


	@Override
	public String Solicitar(AutoTasaInsertBEDTO request) throws GenericException, IOException, SQLException{ 
         String mensaje = null ;
         SimpleDateFormat objSDF2 = new SimpleDateFormat("ddMMyy");
         Date  fecha=  new Date();
         BigInteger id_Tasa_long_n =new BigInteger("1"); 
		try {
		int salida = 0;
		Timestamp timestamp = Timestamp.valueOf(request.getFecha_Solic());
		id_Tasa_long = autoTasaRepo.ObtenerUltFolioAutoTasas();
		LOGGER.debug( id_Tasa_long.toString());
		//String id = id_Tasa.toString();
		
		//id_Tasa =   (id_Tasa == 0) ? 1: (long) (Integer.parseInt(id.substring(6))+1);
		//id_Tasa_long =   (id_Tasa_long.toString().equals("0")) ? id_Tasa_long_n: id_tasa_op;
		if(id_Tasa_long.toString().equals("0")) {
			id_Tasa_long = id_Tasa_long_n;
		}else {
			String id = id_Tasa_long.toString();
			BigInteger id_Tasa =new BigInteger(id.substring(6).toString());
			BigInteger id_tasa_op = new BigInteger(id_Tasa.add(id_Tasa_long_n).toString());
			id_Tasa_long= id_tasa_op;
			LOGGER.debug( id_Tasa_long.toString());
		}
		
		
		
		Long fecha_act = (long) Integer.parseInt(objSDF2.format(fecha));
		BigInteger f_div =new BigInteger(fecha_act.toString()); 
		BigInteger f_div2 =new BigInteger("100000");  
		BigInteger res =new BigInteger(f_div.multiply(f_div2).add(id_Tasa_long).toString());
		//id_Tasa_long =  (Integer.parseInt(objSDF2.format(fecha))*(10000))+id_Tasa_long;
		LOGGER.debug( id_Tasa_long.toString());
		LOGGER.debug(res.toString() );
		 valida = autoTasaRepo.ValidarID_TASAUTO(f_div);
		if(valida.toString().equals("0")) {
			res = res;
		}else {
			BigInteger res_po = new BigInteger(valida.add(id_Tasa_long_n).toString()); 
			res = res_po;
		}
		
		salida = autoTasaRepo.SAVE_AUTOTASAS(res, 
				//request.getFecha_Solic(), 
				timestamp,
				request.getEstatus(), 
				request.getSuc_Solic(), 
				request.getDivicion(), 
				request.getNum_Cte(), 
				request.getNom_Cte(), 
				request.getSoeid_Asig(), 
				request.getContrato(), 
				request.getNomina(), 
				request.getNomejec(), 
				request.getMonto(), 
				request.getPlazo(), 
				request.getTasa_Autori(), 
				request.getTipo_Autori(), 
				request.getCete(), 
				request.getPorcen_Cete(), 
				request.getJustificacion(), 
				request.getCel(), 
				request.getPorta());
		if(salida > 0) {
			mensaje ="Guardado | id : "+ res;	
			
		}else {
			mensaje = "Error";	
			throw new GenericException("Error");
		}
		}catch (GenericException ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return mensaje;
		
/*			for(AutoTasa autasa : listAutoTasa) {
*					if(objSDF2.format(fecha).toString().equals(autasa.getFECHA_SOLIC())) { //falta sacr el maximo		
*						if(autasa.getID_TASAUTO().intValue() > 0) {
*						//	id_Tasa = 0;
*						}else {
*						//	id_Tasa = autasa.getID_TASAUTO().intValue();
*						}		
*					}
*			}*/
		
	//	for(TasaPorsentaje por : listPorsentaje) {
		//	if(por.getCampana().equals("PORTAESPNOM")) {
			//	porsentaje = Double.parseDouble(por.getPorcentaje());
		//	}
	//}
    //    id_Tasa = (id_Tasa == 0) ? 1: (id_Tasa +1);//ver el substring
     //   request.setID_TASAUTO((Integer.parseInt(objSDF2.format(fecha))*10000)+id_Tasa); //solicitud.ID_TASAUTO
      //  request.setFECHA_SOLIC(objSDF.format(fecha));
     //   request.setESTATUS("SOLICITADA");//preguntar si es varchar po int  SOLICITADA
	//	respoce.setSUC_SOLIC(2); // solicitud.SUC_SOLIC = int.Parse(inputNumSuc.Text.Split('-')[0].Trim()); usuario
	//	respoce.setDIVISION("algo");//usuario
	//	respoce.setNUM_CTE(34);//usuario
	//	respoce.setNOM_CTE("Miguel");//usuario
	//	respoce.setSOEID_ASIG("");//calcular usuario de ObtenerAutorizadoresDivisionales
	//	respoce.setCONTRATO(234);//usuario
	//	respoce.setNOMINA("Nomina");//usuario
	//	respoce.setNOMEJEC("Oscar");//usuario
	//	respoce.setMONTO(12.45);//usuario
	//	respoce.setPLAZO(10);//ingresa el usuario
		//request.setCampana("PORTAESPNOM");
     //   request.setTASA_AUTORI(porsentaje);//calcular a tabla tb_tasa_porcentaje
	//	respoce.setTIPO_AUTORI("Tasas Autorizaciones Divisionale");//usuario
    //    for(AutoCetes ce :listCetes) {
     //   	if(request.getPLAZO().intValue() == ce.getId_Plazo().intValue()) {  		
      //  		tasa100Porc = ce.getCete();      		
       // 	}	
	//	}
   //     request.setCETE(tasa100Porc);//tasa
    //    request.setPORCEN_CETE((porsentaje*100)/tasa100Porc);
	//	respoce.setJUSTIFICACION("");//usuario
    //    request.setCEL("");//preguntar
     //   request.setPORTA("");
	/*    AutoTasa  autotasa  = new AutoTasa(((Integer.parseInt(objSDF2.format(fecha))*10000)+id_Tasa),objSDF.format(fecha), "SOLICITADA", request.getSUC_SOLIC(), 
	    		                             request.getDIVISION(), request.getNUM_CTE(), request.getNOM_CTE(),request.getSOEID_ASIG(),  request.getCONTRATO(),
	    		                             request.getNOMINA(), request.getNOMEJEC(), Double.parseDouble(request.getMONTO()), request.getPLAZO(), porsentaje, 
	    		                             request.getTIPO_AUTORI(), tasa100Porc, (porsentaje*100)/tasa100Porc, request.getJUSTIFICACION(),request.getCEL(),
	    		                             request.getPORTA(),"","");

	    listAutoTasa = new ArrayList<AutoTasa>();
		listAutoTasa.add(autotasa);*/
	
	
	}



	@Override
	public List<DiasFestivosResponseDTO> ObtenerDiasFeriados(DiasFestivosBEDTO request) throws GenericException, IOException {
		Date  actual=  new Date();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy"); 
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy"); 
		int aumento = 0;
		int plazo = 0;
		int validacion = 0;
		lstdias = diasFestivosRepo.obtenerListaFechas();
		List<DiasFestivosResponseDTO> diasFestivosResponse = new ArrayList<DiasFestivosResponseDTO>();
		try{
			
			c.setTime(actual);
	        c.add(Calendar.DATE, request.getPlazo().intValue());
	        actual = c.getTime();
	        objSDF.applyLocalizedPattern("E");
	        LOGGER.debug( objSDF2.format(actual).toString());
	        
			for(DiasFestivos dia : lstdias) {
				objSDF.applyLocalizedPattern("E");
		        LOGGER.debug( objSDF2.format(actual).toString()+ " - "+ dia.getFECHA()+ " --- "+objSDF2.format(dia.getFECHA()));
		      //  diasFestivosResponse.add(new DiasFestivosResponseDTO(plazo,"1"+objSDF2.format(actual)));
				if(objSDF2.format(actual).toString().equals(objSDF2.format(dia.getFECHA()))) {
					if(dia.getDESCRIPCION().equals("Semana Santa")) {
						c.setTime(actual);
						aumento = (objSDF.format(actual).toString().equals("jue")) ? aumento+2:aumento+1;
			        	//aumento = aumento+1;
			            c.add(Calendar.DATE, aumento);
			            actual = c.getTime();
			            validacion =1;
			            if(objSDF.format(actual).toString().equals("sáb")) {
			            	c.setTime(actual);
			            	aumento = aumento+ 2;
			                c.add(Calendar.DATE, 2);
			                actual = c.getTime();
			                plazo = request.getPlazo().intValue() +aumento; 
			                diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo) , objSDF2.format(actual)));
			            }else {
			            	plazo = request.getPlazo().intValue() +aumento;
			            	diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
			            }
					}else {
						c.setTime(actual);
			        	aumento = aumento+1;
			            c.add(Calendar.DATE, aumento);
			            actual = c.getTime();
			            validacion =1;
			            if(objSDF.format(actual).toString().equals("sáb")) {
			            	c.setTime(actual);
			            	aumento = aumento+ 2;
			                c.add(Calendar.DATE, 2);
			                actual = c.getTime();
			                plazo = request.getPlazo().intValue() +aumento;
			                diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
			            }else {
			            	plazo = request.getPlazo().intValue() +aumento;
			            	diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
			            }
					}
					
				}
			}
			if(validacion == 0) {
				if(objSDF.format(actual).toString().equals("sáb")) {
					c.setTime(actual);
					aumento = 2;
					c.add(Calendar.DATE, aumento);
					actual = c.getTime();
					plazo = request.getPlazo().intValue() +aumento;
					diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
				}else if (objSDF.format(actual).toString().equals("dom")) {
					c.setTime(actual);
					aumento = 1;
					c.add(Calendar.DATE, aumento);
					actual = c.getTime();
					plazo = request.getPlazo().intValue() +aumento;
					diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
				}else {
					diasFestivosResponse.add(new DiasFestivosResponseDTO(request.getPlazo(),objSDF2.format(actual)));

				}
			}
			
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		
		

		
     		
		
		return diasFestivosResponse;
	}



	@Override
	public List<AutorizadoresDivisionalesResponseDTO> ObtenerAutorizadoresDivisionales(AutorizadoresBEDTO request) throws GenericException, IOException{ //si
		lstAut = autorizadoresRepo.ObtenerAutorizadoresDivisionales(request.getSoeid());
		List<AutorizadoresDivisionalesResponseDTO> listAutoTasaRespose = new  ArrayList<AutorizadoresDivisionalesResponseDTO>();
		try {
			SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
			for(Autorizadores aut : lstAut) {
					listAutoTasaRespose.add(new AutorizadoresDivisionalesResponseDTO (aut.getSoeid(),
							aut.getDivision(),
							aut.getNombre(),
							aut.getInic(),
							objSDF2.format(aut.getFecha_Inicio()),
							objSDF2.format(aut.getFecha_Termino()),
							aut.getAlta(),
							aut.getId_nivel_auto(),
							aut.getCorreo()));
			}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return listAutoTasaRespose;
	}


	@Override
	public BigInteger ObtenerUltFolioAutoTasas() throws GenericException, IOException{//si
		try {
			id_Tasa_long = autoTasaRepo.ObtenerUltFolioAutoTasas();
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return id_Tasa_long;
		
	}
	



	@Override
	public List<AutorizadoresDivisionalesResponseDTO> ObtenerAutorizadorAutomatico() throws GenericException, IOException{ //si
		lstAut = autorizadoresRepo.ObtenerAutorizadorAutomatico();
		List<AutorizadoresDivisionalesResponseDTO> listAutoTasaRespose = new  ArrayList<AutorizadoresDivisionalesResponseDTO>();
		try {
			
			SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
			for(Autorizadores aut : lstAut) {
					listAutoTasaRespose.add(new AutorizadoresDivisionalesResponseDTO (aut.getSoeid(),
						aut.getDivision(),
						aut.getNombre(),
						aut.getInic(),
						objSDF2.format(aut.getFecha_Inicio()),
						objSDF2.format(aut.getFecha_Termino()),
						aut.getAlta(),
						aut.getId_nivel_auto(),
						aut.getCorreo()));
			}
	    }catch (Exception ex) {
	    	System.out.println("ex ->" + ex.getMessage());
	    	System.out.println("ex ->" + ex.getCause());
	    }
		return listAutoTasaRespose;
	}
	

	@Override
	public List<AutorizadoresDivisionalesResponseDTO> ObtenerAutorizadoresGerencia() throws GenericException, IOException{ //si
		lstAut = autorizadoresRepo.ObtenerAutorizadoresGerencia();
		List<AutorizadoresDivisionalesResponseDTO> listAutoTasaRespose = new  ArrayList<AutorizadoresDivisionalesResponseDTO>();
		try {
			SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
			for(Autorizadores aut : lstAut) {
				listAutoTasaRespose.add(new AutorizadoresDivisionalesResponseDTO (aut.getSoeid(),
					aut.getDivision(),
					aut.getNombre(),
					aut.getInic(),
					objSDF2.format(aut.getFecha_Inicio()),
					objSDF2.format(aut.getFecha_Termino()),
					aut.getAlta(),
					aut.getId_nivel_auto(),
					aut.getCorreo()));
			}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return listAutoTasaRespose;
	}



	@Override
	public List<SucursalesPorSucResponseDTO> ObtenerSucursalesPorSuc() throws GenericException, IOException { //si
		List<SucursalesPorSucResponseDTO> listSucursalesPorSucResponse = new  ArrayList<SucursalesPorSucResponseDTO>();
        try{
        	listSucursal = sucursalesRepo.ObtenerSucursalesPorSuc();
    		
    		for(Sucursales suc : listSucursal) {
    				listSucursalesPorSucResponse.add(new SucursalesPorSucResponseDTO(suc.getSIRH()+" - "+ suc.getSUCURSAL()+" - "+ suc.getDIVISION(),suc.getSIRH(),suc.getDITRITO(),suc.getIS_CLOSED()));
    		}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		return listSucursalesPorSucResponse;
	}



	@Override
	public List<AutoTasaResponseDTO> ObtenerRegCampTasa(AutoTasaBEDTO request)  throws GenericException, IOException{ //si
		List<AutoTasaResponseDTO> listObtenerRegCampTasas = new  ArrayList<AutoTasaResponseDTO>();
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			LOGGER.debug( request.getId_tasauto() );
		BigInteger id_tasa = new BigInteger(request.getId_tasauto());
		listAutoTasa = autoTasaRepo.ObtenerRegCampTasa(id_tasa );
		LOGGER.debug( request.getId_tasauto()  );
		for(AutoTasa autTasa : listAutoTasa) {
				listObtenerRegCampTasas.add(new AutoTasaResponseDTO(
						autTasa.getID_TASAUTO(),
						objSDF2.format(autTasa.getFECHA_SOLIC()), 
					    objSDF2.format(autTasa.getFECHA_ESTATUS()), 
						objSDF2.format(autTasa.getFECHA_PROCESS()), 
						autTasa.getESTATUS(),
						autTasa.getSUC_SOLIC(), 
						autTasa.getDIVISION(),
						autTasa.getNUM_CTE(), 
						autTasa.getNOM_CTE(), 
						autTasa.getCONTRATO(), 
						autTasa.getNOMINA(), 
						autTasa.getNOMEJEC(), 
						autTasa.getMONTO(), 
						autTasa.getPLAZO(),
						autTasa.getTASA_AUTORI(),
						autTasa.getNUM_AUTORI_UEC(),
						autTasa.getOBSERVA_WEB(), 
						autTasa.getJUSTIFICACION(),			
						autTasa.getTIPO_AUTORI(),
						autTasa.getSOEID_ASIG(), 
						autTasa.getSOEID_PROC(), 
						autTasa.getSOEID_OPE(), 
						autTasa.getIS_PROCESS()));		
		}
		
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return listObtenerRegCampTasas;	
		
	}



	@Override
	public String Guardar_Autorizacion(TbAutorizadoresElegidosBEDTO request) throws GenericException, IOException {//si
		String mensaje = null ;
		
		try {
		int salida = 0;
		BigInteger id_aut = new BigInteger(request.getId_TasaAuto());
		salida = tbAutorizadoresElegidosRepo.Guardar_Autorizacion(id_aut,request.getAutorizadores().replace("-", "|"));
		if(salida > 0) {
			mensaje ="Guardado";	
			
		}else {
			mensaje = "Error";	
			throw new GenericException("Error");
		}
		}catch (GenericException ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return mensaje;
	}




	@Override
	public String UPDATE_Autorizador_Solicitud(AutoTasaUpdateRequest request)throws GenericException, IOException {// si
		String mensaje =null;
		try {
		int salidaUp = 0;
		BigInteger id_tasa = new BigInteger(request.getId_TasAuto());
		salidaUp = autoTasaRepo.UPDATE_Autorizador_Solicitud(id_tasa,
				request.getSoeid_Autori(),
				request.getInic_Autori());

		if(salidaUp > 0) {
			mensaje="Actualizo";	
		}else {
			throw new GenericException("Error","Parametro no encontrado");	
		}
		}catch (GenericException ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return mensaje;
	}
	@Override
	public List<ObtenerRegAutoTasaResposeDTO> ObtenerRegAutoTasa(AutoTasaBEDTO request) throws GenericException, IOException{ //si
		List<ObtenerRegAutoTasaResposeDTO> obtenerRegAutoTasaRespose = new  ArrayList<ObtenerRegAutoTasaResposeDTO>();
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
		String autorizadores = null;
		try {
			BigInteger id_tasa = new BigInteger(request.getId_tasauto());
			listAutoTasa = autoTasaRepo.ObtenerRegAutoTasa(id_tasa );
			for(AutoTasa autTasa : listAutoTasa) {		
				if(autTasa.getAUTORIZADORES().isEmpty()) {
					lstAut = autorizadoresRepo.ObtenerAutorizadoresDivisionales(autTasa.getAUTORIZADORES().split("|").toString());
					for(Autorizadores aut : lstAut) {
						autorizadores =	aut.getDivision()+
									aut.getNombre()+
									aut.getInic()+
									objSDF2.format(aut.getFecha_Inicio())+
									objSDF2.format(aut.getFecha_Termino())+
									aut.getAlta()+
									aut.getId_nivel_auto()+
									aut.getCorreo();
					}
				}

				
				obtenerRegAutoTasaRespose.add(new ObtenerRegAutoTasaResposeDTO(
					autTasa.getID_TASAUTO(),
					objSDF2.format(autTasa.getFECHA_SOLIC()), 
					objSDF2.format(autTasa.getFECHA_AUTORI()),
					objSDF2.format(autTasa.getFECHA_PROCESS()), 
					objSDF2.format(autTasa.getFECHA_ESTATUS()), 
					autTasa.getESTATUS(),
					autTasa.getSUC_SOLIC(), 
					autTasa.getDIVISION(),
					autTasa.getNUM_CTE(), 
					autTasa.getNOM_CTE(), 
					autTasa.getCONTRATO(), 
					autTasa.getNOMINA(), 
					autTasa.getNOMEJEC(), 
					autTasa.getMONTO(), 
					autTasa.getPLAZO(),
					autTasa.getTASA_AUTORI(),
					autTasa.getTIPO_AUTORI(),
					autTasa.getSOEID_AUTORI(),
					autTasa.getSOEID_ASIG(),
					autTasa.getINIC_AUTORI(),
					autTasa.getNUM_AUTORI_UEC(),
					autTasa.getCETE(),
					autTasa.getPORCEN_CETE(),
					autTasa.getOBSERVA_WEB(), 
					autTasa.getJUSTIFICACION(),	
					autTasa.getIS_PROCESS(), 
					objSDF2.format(autTasa.getFECHA_SOLIC_CANCEL()),
					autTasa.getNOMINA_CANCEL(),
					autTasa.getNOMEJEC_CANCEL(),
					autTasa.getJUSTIFICACION_CANCEL(),
					autorizadores));		
				
                           

				
			}			
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		return obtenerRegAutoTasaRespose;
	}
	@Override
	public List<ObtenerAutoDivisionalResposeDTO> ObtenerAutoDivisional(ObtenerAutoDivisionalBEDTO request) throws GenericException, IOException { //probar
		List<ObtenerAutoDivisionalResposeDTO> obtenerAutoDivisionalRespose = new  ArrayList<ObtenerAutoDivisionalResposeDTO>();
		try {
			
		if((request.getTipo().isEmpty()) || (request.getTipo() == null)) {
			//listAutoDivisionales = tb_Auto_AutoDivisionalesRepo.ObtenerAutoDivisionalAll(request.getSOEID());
			//for(Tb_Auto_AutoDivisionales auto: listAutoDivisionales) {
		//		obtenerAutoDivisionalRespose.add(new ObtenerAutoDivisionalResposeDTO(auto.getSoeid(), null, null, auto.getDivision(), auto.getNombre(), auto.getInic(), auto.getFecha_Inicio(), auto.getFecha_Termino(), auto.getAlta(), auto.getCorreo(), null, null, null, auto.getTIPO()));
		//	}
			listAutoDivisionales = tb_Auto_AutoDivisionalesRepo.ObtenerDivisional(request.getSOEID());
			for(Tb_Auto_AutoDivisionales auto: listAutoDivisionales) {
				obtenerAutoDivisionalRespose.add(new ObtenerAutoDivisionalResposeDTO(auto.getSoeid(), null, null, auto.getDivision(), auto.getNombre(), auto.getInic(), auto.getFecha_Inicio(), auto.getFecha_Termino(), auto.getAlta(), auto.getCorreo(), null, auto.getIs_cetes100(), auto.getIs_campesp(), auto.getTIPO()));
			}
			listAutoRegionales = tb_Auto_AutoRegionalesRepo.ObtenerRegionales(request.getSOEID());
			for(Tb_Auto_AutoRegionales auto: listAutoRegionales) {
				obtenerAutoDivisionalRespose.add(new ObtenerAutoDivisionalResposeDTO(auto.getSoeid(), auto.getSoeid_Divisional(), null, auto.getDivision(), auto.getNombre(), auto.getInic(), auto.getFecha_Inicio(), auto.getFecha_Termino(), auto.getAlta(), auto.getCorreo(), auto.getRegion(), auto.getIs_cetes100(), auto.getIs_campesp(), "Regional"));
			}
			listAutoFacultados = tb_Auto_AutoFacultadosRepo.ObtenerFacultados(request.getSOEID());
			for(Tb_Auto_AutoFacultados auto: listAutoFacultados) {
				obtenerAutoDivisionalRespose.add(new ObtenerAutoDivisionalResposeDTO(auto.getSoeid(), auto.getSoeid_Divisional(), auto.getSoeid_Regional(), auto.getDivision(), auto.getNombre(), auto.getInic(), auto.getFecha_Inicio(), auto.getFecha_Termino(), auto.getAlta(), auto.getCorreo(), auto.getRegion(), auto.getIs_cetes100(), auto.getIs_campesp(), "Facultado"));
			}
		}else if(request.getTipo().equals("Divisional")) {
			listAutoDivisionales = tb_Auto_AutoDivisionalesRepo.ObtenerDivisional(request.getSOEID());
			for(Tb_Auto_AutoDivisionales auto: listAutoDivisionales) {
				obtenerAutoDivisionalRespose.add(new ObtenerAutoDivisionalResposeDTO(auto.getSoeid(), null, null, auto.getDivision(), auto.getNombre(), auto.getInic(), auto.getFecha_Inicio(), auto.getFecha_Termino(), auto.getAlta(), auto.getCorreo(), null, auto.getIs_cetes100(), auto.getIs_campesp(), auto.getTIPO()));
			}
		}else if(request.getTipo().equals("Regional")) {
			listAutoRegionales = tb_Auto_AutoRegionalesRepo.ObtenerRegionales(request.getSOEID());
			for(Tb_Auto_AutoRegionales auto: listAutoRegionales) {
				obtenerAutoDivisionalRespose.add(new ObtenerAutoDivisionalResposeDTO(auto.getSoeid(), auto.getSoeid_Divisional(), null, auto.getDivision(), auto.getNombre(), auto.getInic(), auto.getFecha_Inicio(), auto.getFecha_Termino(), auto.getAlta(), auto.getCorreo(), auto.getRegion(), auto.getIs_cetes100(), auto.getIs_campesp(), "Regional"));
			}
			
		}else if(request.getTipo().equals("Facultado")) {
			listAutoFacultados = tb_Auto_AutoFacultadosRepo.ObtenerFacultados(request.getSOEID());
			for(Tb_Auto_AutoFacultados auto: listAutoFacultados) {
				obtenerAutoDivisionalRespose.add(new ObtenerAutoDivisionalResposeDTO(auto.getSoeid(), auto.getSoeid_Divisional(), auto.getSoeid_Regional(), auto.getDivision(), auto.getNombre(), auto.getInic(), auto.getFecha_Inicio(), auto.getFecha_Termino(), auto.getAlta(), auto.getCorreo(), auto.getRegion(), auto.getIs_cetes100(), auto.getIs_campesp(), "Facultado"));
			}
		}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		return obtenerAutoDivisionalRespose;
	}
	@Override
	public String UPDATE_VOBO_AUTOTASAS(AutoTasaUpdateVOBOBEDTO request) throws GenericException, IOException {
		String mensaje = null;
		try {
			int salidaUp = 0;
			Timestamp timestamp = Timestamp.valueOf(request.getFecha_Autori());
			Timestamp timestampE = Timestamp.valueOf(request.getFecha_Estatus());
			BigInteger id_tasa = new BigInteger(request.getId_Tasauto());

			salidaUp = autoTasaRepo.UPDATE_VOBO_AUTOTASAS(request.getSoeid_Autori(), id_tasa, request.getEstatus(), request.getSoeid_Asig(), request.getObserva_Web(), timestamp,timestampE, request.getInic_Autori());


			if(salidaUp > 0) {
				mensaje="Actualizo";	
			}else {
				throw new GenericException("Error");
			}
			}catch (GenericException ex) {
				System.out.println("ex ->" + ex.getMessage());
				System.out.println("ex ->" + ex.getCause());
			}
			
		return mensaje;		
	}
	@Override
	public String CalcularSoeidAsignado() throws GenericException, IOException{ //si
		String soeidAsignado = "";
		try {
		listAsignacion = tb_AsignacionesRepo.ObtenerAsignaciones();
     
		// obtenemos el ultimo soeid asignado
		String soeid_asig_ant  = autoTasaRepo.ObtenerUltSoeidAsignado();
		LOGGER.debug( soeid_asig_ant);
		// obtenemos la posicion en el arreglo del elemento
		int pos  = IntStream.range(0, listAsignacion.size())
				.filter(x -> soeid_asig_ant.equals(listAsignacion.get(x)) )
				.findFirst().orElse(-1);

		//int pos  = Integer.parseInt(listAsignacion.stream().filter(x -> x.getSOEID().equals(soeid_asig_ant) ).findFirst().get().toString());
		LOGGER.debug( pos);
		LOGGER.debug( listAsignacion.size() );
		String val = "";
		if (listAsignacion.size() == 0) {
			return val;
		}

		for (int i = pos; i < listAsignacion.size() - 1; i++)
        {
            if (listAsignacion.get(i+1) != null)
            {
                if (listAsignacion.get(i+1).getONLINE_() == 1) { 
                	soeidAsignado = listAsignacion.get(i+1).getSOEID(); 
                	i = listAsignacion.size(); 
                	}
            }
        }
		LOGGER.debug( soeidAsignado);
		if ((soeidAsignado.isEmpty()) || (soeidAsignado.equals(null)) || (soeidAsignado.equals("")))
        {
            for (int i = -1; i < listAsignacion.size(); i++)
            {
                if (listAsignacion.get(i+1) != null)
                {
                    if (listAsignacion.get(i+1).getONLINE_() == 1) {
                    	soeidAsignado = listAsignacion.get(i+1).getSOEID();
                    	i = listAsignacion.size(); 
                    	}
                }
            }
        }
		LOGGER.debug( soeidAsignado);
	} catch (Exception ex) {
		System.out.println("ex ->" + ex.getMessage());
		System.out.println("ex ->" + ex.getCause());
	}
		
		return soeidAsignado;
	}
	@Override
	public List<AutoCetesResponseDTO> ObtenerAutoCetes() throws GenericException, IOException{ //si
		List<AutoCetesResponseDTO> autoCetesResponse = new ArrayList<AutoCetesResponseDTO>();
		try{
			listCetes = autoCetesRepo.ObtenerAutoCetes();
    		for(AutoCetes cetes : listCetes) {
    			autoCetesResponse.add(new AutoCetesResponseDTO(cetes.getId_Plazo(), cetes.getCete()));
    		}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
	
		return autoCetesResponse;
	}
	@Override
	public List<TasaPorsentajeResponceDTO> ObtenerListaPlazos(TasaPorsentajeBEDTO request) throws GenericException, IOException{ //si
		List<TasaPorsentajeResponceDTO> tasaPorsentajeResponce = new ArrayList<TasaPorsentajeResponceDTO>();
		try{
        	listPorsentaje = tasaPorsentajeRespo.sacarPorsentaje(request.getCampana());
        	for(TasaPorsentaje porcentaje : listPorsentaje) {
    			tasaPorsentajeResponce.add(new TasaPorsentajeResponceDTO(porcentaje.getId_tasa_porc(), porcentaje.getPlazo(), porcentaje.getPorcentaje(), porcentaje.getCampana()));
    		}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return tasaPorsentajeResponce;
	}
	@Override
	public List<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO> ObtenerRegistrosAutoTasasPorEjecutivo(
			ObtenerRegistrosAutoTasasPorEjecutivoRequest request) {
		List<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO> PorsentajeResponce = new ArrayList<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO>();
		try {
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
		String FECHA_SOLIC ;
		String FECHA_AUTORI ;
		String FECHA_ESTATUS ;
		//puesto = (au.getDivision().equals("Gerencia")) ? "Gerencia:":"Divisional:";
		listAutoTasaPor = obtenerRegistrosAutoTasasPorEjecutivoRepo.ObtenerRegistrosAutoTasasPorEjecutivo(request.getNomina(), request.getNum_cte(), request.getYear());
		for(AutoTasasPorEjecutivo porcentaje : listAutoTasaPor) {
			
			FECHA_SOLIC = (porcentaje.getTas_FECHA_SOLIC()== null) ?  "" : objSDF2.format(porcentaje.getTas_FECHA_SOLIC());
			FECHA_AUTORI = (porcentaje.getTas_FECHA_AUTORI()== null) ?  "" : objSDF2.format(porcentaje.getTas_FECHA_AUTORI());
			FECHA_ESTATUS = (porcentaje.getTas_FECHA_ESTATUS() == null) ?  "" : objSDF2.format(porcentaje.getTas_FECHA_ESTATUS());
			System.out.println("ext ->" + FECHA_ESTATUS);
			PorsentajeResponce.add(new ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO(
					porcentaje.getTas_ID_TASAUTO(),
					porcentaje.getTas_ESTATUS(), 
					porcentaje.getTas_NUM_AUTORI_UEC(), 
					FECHA_SOLIC, 
					FECHA_AUTORI, 
					FECHA_ESTATUS, 
					porcentaje.getTas_SUC_SOLIC(), 
					porcentaje.getSuc(), 
					porcentaje.getTas_NUM_CTE(), 
					porcentaje.getTas_NOM_CTE(), 
					porcentaje.getTas_CONTRATO(), 
					porcentaje.getTas_NOMINA(), 
					porcentaje.getTas_MONTO(),
					porcentaje.getTas_PLAZO(), 
					porcentaje.getTas_TASA_AUTORI(), 
					porcentaje.getTas_TIPO_AUTORI(), 
					porcentaje.getTas_SOEID_AUTORI(), 
					porcentaje.getTas_SOEID_ASIG(), 
					porcentaje.getTas_SOEID_OPE(), 
					porcentaje.getTas_INIC_AUTORI(), 
					porcentaje.getTas_CETE(), 
					porcentaje.getTas_PORCEN_CETE(), 
					porcentaje.getEleg_autorizadores(), 
					porcentaje.getTas_OBSERVA_WEB(), 
					porcentaje.getCertificado_fisico(), 
					porcentaje.getCertificado_moral(),
					FECHA_SOLIC,
					porcentaje.getID_CAMPANA()));
		}
	}catch (Exception ex) {
		System.out.println("ex ->" + ex.getMessage());
		System.out.println("ex ->" + ex.getCause());
	}
		return PorsentajeResponce;
	}
	
	@Override
	public String UPDATE_SOLIC_CANCEL_CAMPTASAS(AutoTasaUpdateCamTasasRequest request)throws GenericException, IOException{
		String mensaje = null;
		try {
			int salidaUp = 0;
			Timestamp timestamp = Timestamp.valueOf(request.getFecha_Solic_Cancel());
			BigInteger id_tasa = new BigInteger(request.getId_Tasauto());
			salidaUp = autoTasaRepo.UPDATE_SOLIC_CANCEL_CAMPTASAS(request.getSoeid_Asig(), request.getSoeid_Ope(), request.getNomina_Cancel(), request.getNomejec_Cancel(), request.getJustificacion_Cancel(), timestamp, id_tasa);


			if(salidaUp > 0) {
				mensaje = "Actualizo";	
			}else {
				throw new GenericException("Error");
			}
			}catch (GenericException ex) {
				System.out.println("ex ->" + ex.getMessage());
				System.out.println("ex ->" + ex.getCause());
			}
			
		return mensaje;		
	}
	@Override
	public Long ExisteFolioBancanet() throws GenericException, IOException {
		Long folio = null;
		try{
			
			folio = autoTasaRepo.existe_folio_bancanet();

		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return folio;
	}









}
