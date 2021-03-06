package com.citi.euces.solicitudes.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.citi.euces.solicitudes.infra.dto.InfoPdfEstandar;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import java.util.Base64;
import org.springframework.http.HttpStatus;


import com.citi.euces.solicitudes.entities.AutoCetes;
import com.citi.euces.solicitudes.entities.AutoTasa;
import com.citi.euces.solicitudes.entities.AutoTasaBody;
import com.citi.euces.solicitudes.entities.AutoTasasPorEjecutivo;
import com.citi.euces.solicitudes.entities.Autorizadores;
import com.citi.euces.solicitudes.entities.DiasFestivos;
import com.citi.euces.solicitudes.entities.EjecutivoSucursal;
import com.citi.euces.solicitudes.entities.Oferta;
import com.citi.euces.solicitudes.entities.TasaPorsentaje;
import com.citi.euces.solicitudes.entities.Autorango;
import com.citi.euces.solicitudes.entities.TbAutorizadoresElegidos;
import com.citi.euces.solicitudes.entities.Tb_Asignaciones;
import com.citi.euces.solicitudes.entities.Tb_Auto_AutoDivisionales;
import com.citi.euces.solicitudes.entities.Tb_Auto_AutoFacultados;
import com.citi.euces.solicitudes.entities.Tb_Auto_AutoRegionales;
import com.citi.euces.solicitudes.entities.TipoSolicitud;
import com.citi.euces.solicitudes.entities.Sucursales;
import com.citi.euces.solicitudes.entities.SucursalesConsulta;
import com.citi.euces.solicitudes.infra.dto.AutoCetesResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaInsertBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaInsertResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaUpdateVOBOBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutorangoResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutorizadoresBEDTO;
import com.citi.euces.solicitudes.infra.dto.AutorizadoresDivisionalesResponseDTO;
import com.citi.euces.solicitudes.infra.dto.AutorizadoresResponseDTO;
import com.citi.euces.solicitudes.infra.dto.CatFolioDTO;
import com.citi.euces.solicitudes.infra.dto.CatPDFEspecial;
import com.citi.euces.solicitudes.infra.dto.Cat_SucBEDTO;
import com.citi.euces.solicitudes.infra.dto.ConfigPdfDTO;
import com.citi.euces.solicitudes.infra.dto.DiasFestivosBEDTO;
import com.citi.euces.solicitudes.infra.dto.DiasFestivosResponseDTO;
import com.citi.euces.solicitudes.infra.dto.EjecutivoSucursalResponseDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerAutoDivisionalBEDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerAutoDivisionalResposeDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerRegAutoTasaResposeDTO;
import com.citi.euces.solicitudes.infra.dto.ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO;
import com.citi.euces.solicitudes.infra.dto.OfertaBEDTO;
import com.citi.euces.solicitudes.infra.dto.OfertaResponseDTO;
import com.citi.euces.solicitudes.infra.dto.PlantillaPdfDTO;
import com.citi.euces.solicitudes.infra.dto.SucursalesBEDTO;
import com.citi.euces.solicitudes.infra.dto.SucursalesConsultaResponseDTO;
import com.citi.euces.solicitudes.infra.dto.SucursalesPorSucResponseDTO;
import com.citi.euces.solicitudes.infra.dto.TasaPorsentajeBEDTO;
import com.citi.euces.solicitudes.infra.dto.TasaPorsentajeResponceDTO;
import com.citi.euces.solicitudes.infra.dto.TipoSolicitudRespoceDTO;
import com.citi.euces.solicitudes.infra.dto.AutoTasaUpdateCamTasasRequest;
import com.citi.euces.solicitudes.infra.dto.AutoTasaUpdateRequest;
import com.citi.euces.solicitudes.infra.dto.ObtenerRegistrosAutoTasasPorEjecutivoRequest;
import com.citi.euces.solicitudes.infra.dto.EnviarPHPBEDTO;
import com.citi.euces.solicitudes.infra.dto.EnviarPHPDTO;
import com.citi.euces.solicitudes.infra.dto.ImpresionResponse;
import com.citi.euces.solicitudes.infra.dto.MarcaAguaEvent;
import com.citi.euces.solicitudes.infra.exceptions.GenericException;
import com.citi.euces.solicitudes.infra.utils.BodyMail;
import com.citi.euces.solicitudes.infra.utils.FormatUtils;
import com.citi.euces.solicitudes.repositories.AutoCetesRepo;
import com.citi.euces.solicitudes.repositories.AutoTasaBodyRepo;
import com.citi.euces.solicitudes.repositories.AutoTasaRepo;
import com.citi.euces.solicitudes.repositories.AutorizadoresRepo;
import com.citi.euces.solicitudes.repositories.DiasFestivosRepo;
import com.citi.euces.solicitudes.repositories.EjecutivoSucursalRepo;
import com.citi.euces.solicitudes.repositories.ImprimirPDFsRepository;
import com.citi.euces.solicitudes.repositories.ObtenerRegistrosAutoTasasPorEjecutivoRepo;
import com.citi.euces.solicitudes.repositories.OfertaRepo;
import com.citi.euces.solicitudes.repositories.SucursalesConsultaRepo;
import com.citi.euces.solicitudes.repositories.SucursalesRepo;
import com.citi.euces.solicitudes.repositories.TasaPorsentajeRespo;
import com.citi.euces.solicitudes.repositories.AutorangoRepo;
import com.citi.euces.solicitudes.repositories.TbAutorizadoresElegidosRepo;
import com.citi.euces.solicitudes.repositories.Tb_AsignacionesRepo;
import com.citi.euces.solicitudes.repositories.Tb_Auto_AutoDivisionalesRepo;
import com.citi.euces.solicitudes.repositories.Tb_Auto_AutoFacultadosRepo;
import com.citi.euces.solicitudes.repositories.Tb_Auto_AutoRegionalesRepo;
import com.citi.euces.solicitudes.repositories.TipoSolicitudRepo;
import com.citi.euces.solicitudes.repositories.solicitudCampanaJDBCRepository;
import com.citi.euces.solicitudes.services.api.ServiceSolicitudInversion;

@Service 
public class ServiceSolicitudInversionImp implements ServiceSolicitudInversion {
	private static final Logger LOGGER = LogManager.getLogger(ServiceSolicitudInversionImp.class);

	List<Autorizadores> lstAut = null;
	List<DiasFestivos> lstdias = null;
	List<DiasFestivosResponseDTO> diasFestivosResponse = new ArrayList<DiasFestivosResponseDTO>();
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
	List<EjecutivoSucursal> listEjecutivoSucursal = null;
	List<SucursalesConsulta> listSucursalesConsulta = null;
	List<Oferta> listOferta = null;
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
	AutoTasaBodyRepo autoTasaBodyRepo;
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
	@Autowired
	EjecutivoSucursalRepo ejecutivoSucursalRepo;
	@Autowired
	SucursalesConsultaRepo sucursalesConsultaRepo;
	@Autowired
	OfertaRepo ofertaRepo;  
	@Autowired
	ImprimirPDFsRepository imprimirPDFsRepository;
	@Autowired
	private solicitudCampanaJDBCRepository solicitudCampanaJDBCRepository;

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
		
		switch (t.getId()) {
		
		case 7:		
			responce.setId_Oferta("DIVISIONALES");
			responce.setId_Campana("AUT.DIVISIONAL");
		break;
		case 8:
			responce.setId_Oferta("DISTRITALES");
			responce.setId_Campana("AUT.DISTRITAL");
		break;	
		default:
			responce.setId_Oferta("EXCEPGERENCIA");
			responce.setId_Campana("EXCEPCION GERENCIA");
		break; 			
	    }
		
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
					lstAut = autorizadoresRepo.ObtenerAutorizadoresDivisionalesXDivision(request.getDivision(),"");
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
	public AutoTasaInsertResponseDTO Solicitar(AutoTasaInsertBEDTO request) throws GenericException, IOException, SQLException{ 
         String mensaje = null ;
         AutoTasaInsertResponseDTO autoTasaInsertResponseDTO =  new AutoTasaInsertResponseDTO();
		try {
		int salidaAutori = 0;
		BigInteger id_Tasa =new BigInteger(IdAutotsa().toString()); 
		salidaAutori = tbAutorizadoresElegidosRepo.Guardar_Autorizacion(id_Tasa,request.getAutorizadores().replace("-", "|"));	
		if(salidaAutori > 0) {
			mensaje ="Guardado";	
			int salida = 0;
			Timestamp timestamp = Timestamp.valueOf(request.getFecha_Solic());
			BigInteger contrato =new BigInteger(request.getContrato().toString()); 
			BigInteger num_cli =new BigInteger(request.getNum_Cte().toString()); 
		//	BigInteger monto =new BigInteger(request.getMonto().toString());
			salida = autoTasaRepo.SAVE_AUTOTASAS(id_Tasa, 
					//request.getFecha_Solic(), 
					timestamp,
					request.getEstatus(), 
					request.getSuc_Solic(), 
					request.getDivicion(), 
					num_cli, 
					request.getNom_Cte(), 
					request.getSoeid_Asig(), 
					contrato, 
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
					request.getPorta(),
					request.getTasa_Campana(),
					request.getPlazo_Sin_Calculo());
			if(salida > 0) {
				autoTasaInsertResponseDTO.setMensaje(mensaje);
				autoTasaInsertResponseDTO.setId_TasaAuto(id_Tasa);
				autoTasaInsertResponseDTO.setEnviarCorreo(true);
			}else {
				mensaje = "Error en el Id_AutoTasa ya existe en autorizadores ";	
				throw new GenericException("Error");
			}
			
		}else {
			mensaje = "Error en el Id_AutoTasa ya existe en autorizadores";	
			throw new GenericException("Error");
		}	
		}catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error en el Id_AutoTasa ya existe en autorizadores ",
					HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return autoTasaInsertResponseDTO;
		
	}



	@Override
	public List<DiasFestivosResponseDTO> ObtenerDiasFeriados(DiasFestivosBEDTO request) throws GenericException, IOException {
		//.intValue()
		SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy"); 
		Date  actual=  new Date();
		Date  actuals=  new Date();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy"); 
		int aumento = 0;
		int aument2 = 0;
		int plazo = 0;
		int validacion = 0;
		int a = 0;
		int p = request.getPlazo();
		lstdias = diasFestivosRepo.obtenerListaFechas();
		List<DiasFestivosResponseDTO> diasFestivosResponse = new ArrayList<DiasFestivosResponseDTO>();
		try{
		    c.setTime(actual);
	        c.add(Calendar.DATE, p); //4  12 ->20 13 21
	        actual = c.getTime();
	        objSDF.applyLocalizedPattern("E");
	        System.out.println( "1 :: "+objSDF2.format(actual).toString());
	        /////////////
	        
	        if(objSDF.format(actual).toString().equals("s??b") || objSDF.format(actual).toString().equals("Sat")) {
				c.setTime(actual);
				aumento = 2;
				c.add(Calendar.DATE, aumento);  //22
				actual = c.getTime();
				plazo = p +aumento; //12+2 14
				 System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actual));
			//	 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actual)));
				System.out.println("e3");
				aumento= 0;
				p= plazo;
			}else if (objSDF.format(actual).toString().equals("dom") || objSDF.format(actual).toString().equals("Sun")) {
				c.setTime(actual);
				aumento = 1;
				c.add(Calendar.DATE, aumento); //21 +1 22
				actual = c.getTime();
				plazo = p +aumento; //13+1 14
				 System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actual));
			//	 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actual)));
				System.out.println("e4");
				aumento= 0;
				p= plazo;
			}else {
				 System.out.println("plazo "+p+" fecha "+objSDF2.format(actual));
				 plazo = p;
				// diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(request.getPlazo()), objSDF2.format(actual)));
				System.out.println("e5");

			}
	        
	        
	        
	        
	        ////////////////
			for(DiasFestivos dia : lstdias) {
		        System.out.println( "2 ::: "+objSDF2.format(actual).toString());
				c.setTime(actual);
		        c.add(Calendar.DATE,0); //12  15 16   
		       actual = c.getTime();
		       System.out.println( "56 ::: "+objSDF2.format(actual).toString());
				if(objSDF2.format(actual).toString().equals(objSDF2.format(dia.getFECHA()))) {
					 System.out.println( ":: "+objSDF2.format(dia.getFECHA()).toString());
			            validacion =1;
			            
			            aumento++;	//1 //2 //3 // 1
			           
			            plazo = aument2+p +aumento; // 0+4+1 = 5  2+4+2 =8  2+4+3 = 9   0+14+1 15
						c.setTime(actual);// 12 15 16 //22
			            c.add(Calendar.DATE, +1); // 13 16 17 //23
			            actual = c.getTime();
			            System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actual));
			            
			            if(objSDF.format(actual).toString().equals("s??b") || objSDF.format(actual).toString().equals("Sat")) {
			            	c.setTime(actual); //13 
			            	aument2 = 2;
			                c.add(Calendar.DATE, 2); //15
			                actual = c.getTime();
			                plazo = p+aument2+aumento; // 4+1+2 = 7
			                System.out.println("e1");
			                System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actual)); //7 15
			                a =1;
			              //  diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actual)));
			            }else if (objSDF.format(actual).toString().equals("dom") || objSDF.format(actual).toString().equals("Sun")) {
							c.setTime(actual);
							//aumento = 1;
							c.add(Calendar.DATE, aumento);
							actual = c.getTime();
							plazo = (p+aumento)+1;
							 System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actual));
						//	 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actual)));
							System.out.println("e4");
						}
			            //	a =1;
			            //	aumento++;	
			            	System.out.println("aumento "+ aumento); //1
			            	
			            	
				}
			}
			
			 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actual)));

			System.out.println(aumento+ " :: " +objSDF2.format(actual));

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
			//
			SimpleDateFormat objSDF5 = new SimpleDateFormat("yyyy/dd/MM");
			Date  fechaAct=  new Date();
			objSDF5.format(fechaAct);
			Calendar cs = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"));
			cs.setTime(fechaAct);
			//
			id_Tasa_long = autoTasaRepo.ObtenerUltFolioAutoTasas(objSDF5.format(cs.getTime()));
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
	public List<SucursalesPorSucResponseDTO> ObtenerSucursalesPorSuc(SucursalesBEDTO request) throws GenericException, IOException { //si
		List<SucursalesPorSucResponseDTO> listSucursalesPorSucResponse = new  ArrayList<SucursalesPorSucResponseDTO>();
	  	BigInteger idS = new BigInteger(request.getId());
    	LOGGER.debug(idS);
    	listSucursal = sucursalesRepo.ObtenerSucursalesPorSuc(idS);
		try{
      
        	LOGGER.debug(listSucursal.size() );
    		for(Sucursales suc : listSucursal) {
    			LOGGER.debug(suc.getSIRH()+" - "+ suc.getSUCURSAL()+" - "+ suc.getDIVISION()+suc.getSIRH()+suc.getDITRITO()+suc.getIS_CLOSED());
    				listSucursalesPorSucResponse.add(new SucursalesPorSucResponseDTO(suc.getSIRH()+" - "+ suc.getSUCURSAL()+" - "+ suc.getDIVISION(),suc.getSIRH(),suc.getDITRITO(),suc.getIS_CLOSED()));
    		}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		return listSucursalesPorSucResponse;
	}

	public String ObtenerSucursalesPorSuc(Long request) throws GenericException, IOException {
		String respuesta = new String();
		List<Cat_SucBEDTO> cte = new ArrayList<Cat_SucBEDTO>();

		try {
			cte = solicitudCampanaJDBCRepository.GetItem(Long.parseLong(request+""));
			respuesta = cte.get(0).getNUMSUC() + " - " + cte.get(0).getSUCURSAL() + " - " + cte.get(0).getDIVISION();
		} catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return respuesta;
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



/*	@Override
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
	}*/




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
			ObtenerRegistrosAutoTasasPorEjecutivoRequest request) throws GenericException {
		List<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO> PorsentajeResponce = new ArrayList<ObtenerRegistrosAutoTasasPorEjecutivoResposeDTO>();
		try {
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat objSDF3 = new SimpleDateFormat("yyyy,MM,dd");
		String FECHA_SOLIC ;
		String FECHA_AUTORI ;
		String FECHA_ESTATUS ;
		String FECHA_FIN ;
		Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
		//puesto = (au.getDivision().equals("Gerencia")) ? "Gerencia:":"Divisional:";
        System.out.println(request.getNum_cte()+ ""+request.getNomina());
        if(request.getNomina().isEmpty() && !request.getNum_cte().isEmpty()) {
    		listAutoTasaPor = obtenerRegistrosAutoTasasPorEjecutivoRepo.ObtenerRegistrosAutoTasasPorEjecutivo2(request.getNomina(), request.getNum_cte(), request.getYear());
       System.out.println("1 entro");
        }else if(!request.getNomina().isEmpty() && request.getNum_cte().isEmpty() ) {
    		listAutoTasaPor = obtenerRegistrosAutoTasasPorEjecutivoRepo.ObtenerRegistrosAutoTasasPorEjecutivo(request.getNomina(), request.getNum_cte(), request.getYear());
    	 System.out.println("2 entro");
        }else if(request.getNomina().isEmpty() && request.getNum_cte().isEmpty()) {
        	PorsentajeResponce = null;
        }else if(!request.getNomina().isEmpty() && !request.getNum_cte().isEmpty()) {
    		listAutoTasaPor = obtenerRegistrosAutoTasasPorEjecutivoRepo.ObtenerRegistrosAutoTasasPorEjecutivo3(request.getNomina(), request.getNum_cte(), request.getYear());
    		 System.out.println("3 entro");
        } 
        
        System.out.println("tama??o "+listAutoTasaPor.size());
		for(AutoTasasPorEjecutivo porcentaje : listAutoTasaPor) {
			 System.out.println("1:: "+porcentaje.getTas_ID_TASAUTO());
			FECHA_SOLIC = (porcentaje.getTas_FECHA_SOLIC()== null) ?  "" : objSDF2.format(porcentaje.getTas_FECHA_SOLIC());
			System.out.println("2:: "+FECHA_SOLIC);
			FECHA_AUTORI = (porcentaje.getTas_FECHA_AUTORI()== null) ?  "" : objSDF2.format(porcentaje.getTas_FECHA_AUTORI());
			System.out.println("3:: "+FECHA_AUTORI);
			FECHA_ESTATUS = (porcentaje.getTas_FECHA_ESTATUS() == null) ?  "" : objSDF2.format(porcentaje.getTas_FECHA_ESTATUS());
			System.out.println("4:: "+FECHA_ESTATUS);
			FECHA_FIN = (porcentaje.getCAMPANIAS_FIN() == null) ?  "" :objSDF3.format(porcentaje.getCAMPANIAS_FIN()); 
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
					porcentaje.getID_CAMPANA(),
					porcentaje.getOFERTA_SIGUIENTE_PASO(),
					porcentaje.getOFERTA_PDF_ESPECIAL_ID(),
					porcentaje.getNOMEJEC(),
					porcentaje.getGATNOMINAOFER(),
					porcentaje.getGATREALOFER(),
					porcentaje.getRENDIMIENTOBRUTO(),
					FECHA_FIN));
		}
	}catch (Exception e) {
		e.printStackTrace();
		throw new GenericException("Error :: ",
				HttpStatus.NOT_FOUND.toString());
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
	@Override
	public List<EjecutivoSucursalResponseDTO> getEjecutivo(SucursalesBEDTO request)
			throws GenericException, IOException {
		List<EjecutivoSucursalResponseDTO> ejecutivoSucursalResponseDTO = new ArrayList<EjecutivoSucursalResponseDTO>();
		try {
		listEjecutivoSucursal = ejecutivoSucursalRepo.getEjecutivo(request.getSoeid());
		LOGGER.debug(listEjecutivoSucursal.size());
		for(EjecutivoSucursal eje : listEjecutivoSucursal) {
			ejecutivoSucursalResponseDTO.add(new EjecutivoSucursalResponseDTO(eje.getSOIED(),
					eje.getNOMINA(), 
					eje.getSIRH_SUCURSAL(), 
					eje.getSUCURSAL(), 
					eje.getDIVISION(), 
					eje.getDISTRITO(), 
					eje.getNOMBRE()));
			LOGGER.debug(eje.getNOMINA());
		}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return ejecutivoSucursalResponseDTO;
	}
	@Override
	public List<SucursalesConsultaResponseDTO> GetItem(SucursalesBEDTO request) throws GenericException, IOException {		
		List<SucursalesConsultaResponseDTO> sucursalesConsultaResponseDTO = new ArrayList<SucursalesConsultaResponseDTO>();
		try {
		BigInteger sirh = new BigInteger(request.getId());
		listSucursalesConsulta  =  sucursalesConsultaRepo.GetItem(sirh);
		for(SucursalesConsulta suc : listSucursalesConsulta) {
			sucursalesConsultaResponseDTO.add(new SucursalesConsultaResponseDTO(suc.getSIRH(),
					suc.getSUCURSAL(), 
					suc.getCODDIV(), 
					suc.getDIVISION(), 
					suc.getCODDIST(), 
					suc.getDISTRITO(), 
					suc.getEJECUTIVOS(), 
					suc.getEJECUTIVOS_PRIORITY(), 
					suc.getIS_CLOSED()));
			
		}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		return sucursalesConsultaResponseDTO;
	}
	@Override
	public EnviarPHPDTO EnviarPHP(EnviarPHPBEDTO request)
			throws GenericException, IOException {
		
		EnviarPHPDTO response = new EnviarPHPDTO();
		try {
			List<AutorizadoresDivisionalesResponseDTO> listadoAutorizadores = request.getListadoAutorizadores();
			BigInteger folio = new BigInteger(request.getFolio());
			Integer oferta = 0;
			//AutoTasa solicitud = autoTasaRepo.buscarId(folio);
			AutoTasaBody solicitud = autoTasaBodyRepo.buscarId(folio);
			
			System.out.println("288 solicitud->" + solicitud);
			
			if (solicitud == null) {
	            throw new GenericException(
	                    "No se encontro informacion en SolicitudesTarifasEspeciales con folio  :: " + folio,
	                    HttpStatus.NOT_FOUND.toString());
	        }
			
			String[] linkAutorizas = request.getLinkAutoriza().split(",");
	        String[] linkRechazas = request.getLinkRechaza().split(",");
			BodyMail detailMail = new BodyMail();
			String body = "";
			int i = 0;
			int plazo = 0;
			String cadenaIds = "";
			String title = "";
			String strAceptada = "StrAceptada";
			String strRechadaza = "StrRechadaza";
			boolean TieneError = false;
			System.out.println("288 TieneError->" + TieneError);
			BigInteger id = new BigInteger(solicitud.getSUC_SOLIC().toString());
        	
//			listSucursal = sucursalesRepo.ObtenerSucursalesPorSuc(id);
//    		
//        	String sucursal = null;
//    		
//    		for(Sucursales suc : listSucursal) {
//    			sucursal = suc.getSUCURSAL();
//    			LOGGER.debug( sucursal);
//    		}
			
			
			String suc;
			try {
				suc = ObtenerSucursalesPorSuc(solicitud.getSUC_SOLIC());
			} catch (Exception e) {
				throw new GenericException("Error al obtener ObtenerSucursalesPorSuc:: ",
						HttpStatus.INTERNAL_SERVER_ERROR.toString());
			}
			
    		
    		String MensajeHorror = "Error de Solicitud";
    		if(solicitud.getCONTRATO() == null || solicitud.getNUM_CTE() == null || solicitud.getTIPO_AUTORI() == null ){
    			TieneError = true;
    		}else {
    			TieneError = false;
    		}  	
    		
    		String tasa = solicitud.getTASA_AUTORI() + "";
    		if (tasa.length() > 5){
                TieneError = true;
                MensajeHorror = "Error de Solicitud, Tasa Autorizada: " + tasa;
            }
    		System.out.println("288 tasa y MensajeHorror -> " + tasa + "  " + MensajeHorror);
    		
    		if (TieneError) {
    			for (AutorizadoresDivisionalesResponseDTO item : listadoAutorizadores) {
    	    		title += detailMail.GetTitleSolicitud() + "|";
    	            cadenaIds += item.getSoeid() + "|";
    	            solicitud.getNUM_CTE();

    	            if(item.getSoeid().equals("VN86003")) {
    	            	try{
    	            		System.out.println("entro 1103");
    	            		body += detailMail.BodySolicitudAutorizadorUEC(solicitud.getFECHA_SOLIC(), solicitud.getIS_PORTABILIDAD(),
    	            				solicitud.getTIPO_AUTORI(),oferta, solicitud.getJUSTIFICACION(), solicitud.getNOMEJEC(),
    	            				solicitud.getNOM_CTE(),   solicitud.getNUM_CTE().longValue(), solicitud.getCONTRATO().longValue(),
    	            				solicitud.getMONTO().toString()+ "",Integer.parseInt(solicitud.getPLAZO().toString()), solicitud.getTASA_AUTORI() + "",
    	            				solicitud.getID_TASAUTO() + "", strAceptada, strRechadaza, suc, MensajeHorror, item.getSoeid())
    							+ "|";
    	            	} catch (Exception e) {
    						throw new GenericException("Error al obtener BodySolicitudAutorizadorUEC:: ",
    								HttpStatus.INTERNAL_SERVER_ERROR.toString());
    					}
                    }
    			}
                
    			System.out.println("288 body->" + body);
                if (i > 0)
                {
        			title = title.substring(0, title.length() - 1);
        			body = body.substring(0, body.length() - 1);
        			cadenaIds = cadenaIds.substring(0, cadenaIds.length() - 1);
                }
                
                System.out.println("288 title y cadenaIds->" + title + "     " + cadenaIds);
                response.setSoeidEnc(cadenaIds);
    			response.setTitleEnc(title);
    			response.setInformeEnc(body);
    			response.setAcountEnc(detailMail.GetBuzon());
               // enviarPHPDTO.add(new EnviarPHPDTO(cadenaIds,title,body, detailMail.GetBuzon()));
                System.out.println("288 response->" + response);
    			return response;
    		}

    		int x = 0;
    		System.out.println("288 listadoAutorizadores->" + listadoAutorizadores);
    		for (AutorizadoresDivisionalesResponseDTO item : listadoAutorizadores) {
    			title += detailMail.GetTitleSolicitud() + "|";
	            cadenaIds += item.getSoeid() + "|";
	            if(item.getSoeid().equals("VN86003")) {
	            	try{
	            		System.out.println("entro 1136");
	            		body += detailMail.BodySolicitudAutorizadorUEC(solicitud.getFECHA_SOLIC(), solicitud.getIS_PORTABILIDAD(),
	            				solicitud.getTIPO_AUTORI(),oferta, solicitud.getJUSTIFICACION(), solicitud.getNOMEJEC(),
	            				solicitud.getNOM_CTE(), solicitud.getNUM_CTE().longValue(), solicitud.getCONTRATO().longValue(),
	            				solicitud.getMONTO().toString() + "", Integer.parseInt(solicitud.getPLAZO().toString()), solicitud.getTASA_AUTORI() + "",
	            				solicitud.getID_TASAUTO() + "", strAceptada, strRechadaza, suc, item.getNombre(), item.getSoeid())
							+ "|";
	            	} catch (Exception e) {
						throw new GenericException("Error al obtener BodySolicitudAutorizadorUEC:: ",
								HttpStatus.INTERNAL_SERVER_ERROR.toString());
					}
                }else {
                	if (!body.contains(item.getNombre())) {
                		try {
                			System.out.println("entro 1150");
    						body += detailMail.BodySolicitud(solicitud.getFECHA_SOLIC(), solicitud.getIS_PORTABILIDAD(),
    								solicitud.getTIPO_AUTORI(),oferta, solicitud.getJUSTIFICACION(), solicitud.getNOMEJEC(),
    								solicitud.getNOM_CTE(), solicitud.getNUM_CTE().longValue(), solicitud.getCONTRATO().longValue(),
    								solicitud.getMONTO().toString() + "",  Integer.parseInt(solicitud.getPLAZO().toString()), solicitud.getTASA_AUTORI() + "",
    								solicitud.getID_TASAUTO() + "", strAceptada, strRechadaza, suc, item.getNombre(),
    								item.getSoeid(), request.getUrlRedirect(), linkAutorizas[x], linkRechazas[x]) + "|";
    					} catch (Exception e) {
    						throw new GenericException("Error al obtener BodySolicitud:: ",
    								HttpStatus.INTERNAL_SERVER_ERROR.toString());
    					}
                	}
                	
                }
	            x++;
    		}
    		System.out.println("288 body->" + body);

    		if (i > 0) {
    			title = title.substring(0, title.length() - 1);
    			body = body.substring(0, body.length() - 1);
    			cadenaIds = cadenaIds.substring(0, cadenaIds.length() - 1);
    		}
    		System.out.println("288 title y cadenaIds->" + title + "     " + cadenaIds);
            response.setSoeidEnc(cadenaIds);
			response.setTitleEnc(title);
			response.setInformeEnc(body);
			response.setAcountEnc(detailMail.GetBuzon());
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		return response;
	}
	@Override
	public List<OfertaResponseDTO> ObtenerOferta(OfertaBEDTO request) throws GenericException, IOException {
		List<OfertaResponseDTO> ofertaResponseDTO= new ArrayList<OfertaResponseDTO>();
		try {
			listOferta = ofertaRepo.ObtenerOferta(request.getId_Oferta());
			for(Oferta ofe : listOferta) {
				ofertaResponseDTO.add(new OfertaResponseDTO(ofe.getOFERTA_ID(),
						ofe.getOFERTA_BAU(),
						ofe.getOFERTA_CAMPANIA_ID(), 
						ofe.getOFERTA_CLIENTE_TIPO_PERSONA(), 
						ofe.getOFERTA_DIAS_CLIENTE(),
						ofe.getOFERTA_DIGITAL(), 
						ofe.getOFERTA_DINERO_NUEVO_MAX(), 
						ofe.getOFERTA_DINERO_NUEVO_MIN(), 
						ofe.getOFERTA_ECM(),
						ofe.getOFERTA_GUIA_INFORMATIVA_ID(), 
						ofe.getOFERTA_INFORMATIVA_FONDOS(), 
						ofe.getOFERTA_MONTO_DESDE(), 
						ofe.getOFERTA_MONTO_HASTA(),
						ofe.getOFERTA_NOMBRE_LARGO(),
						ofe.getOFERTA_NTD(), 
						ofe.getOFERTA_NTM(), 
						ofe.getOFERTA_NTP(), 
						ofe.getOFERTA_PARTICIPACION_UNICA(), 
						ofe.getOFERTA_PDF_ESPECIAL_ID(),
						ofe.getOFERTA_PLAZO_MAXIMO(),
						ofe.getOFERTA_PLAZO_MINIMO(), 
						ofe.getOFERTA_PRIMERA_BUSQUEDA(), 
						ofe.getOFERTA_SECCION(),
						ofe.getOFERTA_SEGMENTO(), 
						ofe.getOFERTA_SEGUNDA_BUSQUEDA(), 
						ofe.getOFERTA_SIGUIENTE_PASO(),
						ofe.getOFERTA_TASA_ID(), 
						ofe.getOFERTA_TIPO_DIRIGIDA()));
				
			}
			
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		// TODO Auto-generated method stub listOferta  ofertaRepo
		return ofertaResponseDTO;
	}
	@Override
	public ImpresionResponse pdfEspecial(PlantillaPdfDTO request) throws GenericException, IOException {
		ImpresionResponse arc = new ImpresionResponse();
		String folio = "";
		List<ConfigPdfDTO> confPdf = new ArrayList<ConfigPdfDTO>();
		List<CatPDFEspecial> tipoPdf = new ArrayList<CatPDFEspecial>();
		List<CatFolioDTO> folioEspecial = new ArrayList<CatFolioDTO>();
		List<CatFolioDTO> folioEspecialExiste = new ArrayList<CatFolioDTO>();

		tipoPdf = imprimirPDFsRepository.getPlantillaPdf(request.getPdfEspecial());

		if (tipoPdf.isEmpty() || tipoPdf == null || tipoPdf.size() == 0) {
			throw new GenericException("La tabla de PdfEspecial no encontro la plantilla o imagen.",
					HttpStatus.NOT_FOUND.toString());
		}

		System.out.println("580 linea codigo tipoPdf->" + tipoPdf);
		confPdf = imprimirPDFsRepository.getConfigPdf(tipoPdf.get(0).getIdPdfEspecial());

		if (confPdf.isEmpty() || confPdf == null || confPdf.size() == 0) {
			throw new GenericException("La tabla de configuracion de pdf no encontro datos en base de datos.",
					HttpStatus.NOT_FOUND.toString());
		}

		System.out.println("580 linea codigo confPdf->" + confPdf);
		if (confPdf.get(0).getPdfTipo() == 1) {

			folioEspecialExiste = imprimirPDFsRepository.getFolioEspUtilizado(confPdf.get(0).getFolioId(),
					request.getNum_cli());
			if (folioEspecialExiste.isEmpty() || folioEspecialExiste == null || folioEspecialExiste.size() == 0) {

				folioEspecial = imprimirPDFsRepository.getFolioEsp(confPdf.get(0).getFolioId());
				if (folioEspecial.isEmpty() || folioEspecial == null || folioEspecial.size() == 0) {
					throw new GenericException(
							"No se puede acceder a al PDF debido a que no existen folios para asignar.",
							HttpStatus.NOT_FOUND.toString());
				}

				System.out.println("580 linea codigo folioEspecial->" + folioEspecial);
				folio = folioEspecial.get(0).getFolioValor();

				System.out.println("580 linea codigo xxxxxxxxxxxxx folio->" + folio);
				arc = pdfFoleado(request, folio, tipoPdf);

				System.out.println("580 linea codigo arc->" + arc);
				imprimirPDFsRepository.actualizaCatFolio(folioEspecial.get(0).getFolioValor(), request.getNum_cli());

				System.out.println("580 linea codigo folio->" + folio);

			} else {
				System.out.println("5801 linea codigo folioEspecialExiste->" + folioEspecialExiste);
				folio = folioEspecialExiste.get(0).getFolioValor();

				System.out.println("5801 linea codigo xxxxxxxxxxxxx folio->" + folio);
				arc = pdfFoleado(request, folio, tipoPdf);
			}

		} else if (confPdf.get(0).getPdfTipo() == 0) {
			arc = pdfNoFoleado(request, tipoPdf);
		}
		return arc;

	}
	
	
	public ImpresionResponse pdfFoleado(PlantillaPdfDTO request, String folio, List<CatPDFEspecial> tipoPdf)
			throws GenericException, IOException {
		ImpresionResponse arc = new ImpresionResponse();
		Document documento = new Document(PageSize.A4, 36, 0, 108, 108);
		FileOutputStream archivo;
		InputStream ima1, ima2;
		Blob blob1, blob2;
		Path file1, file2;
		URL liga1;
		try {

//			file2 = getImagen(8);
			file2 = tipoPdf.get(0).getArchivo();
//			System.out.println("54 linea codigo file1->" + file1);
			Path testFile = Files.createTempFile("PDFestandarFoleado", ".pdf");
			archivo = new FileOutputStream(testFile.toFile());
			PdfWriter.getInstance(documento, archivo);
			System.out.println("58 linea codigo request->" + request);
			documento.open();
//			System.out.println("60 linea codigo file1->" + file1);
//			System.out.println("60 linea codigo file1->" + file1.toString());

			Image imagenGen2 = Image.getInstance(file2.toFile().getAbsolutePath());
			System.out.println("62 linea codigo imagenGen2->" + imagenGen2);
			imagenGen2.setAbsolutePosition(0f, 0f);
			imagenGen2.scaleAbsolute(595f, 840f);
			documento.add(imagenGen2);

//			Image imagenGen1 = Image.getInstance(file1.toString());
//			imagenGen1.setAbsolutePosition(0f, 780f);
//			imagenGen1.scaleAbsolute(595f, 66f);
//			imagenGen1.setAlignment(Chunk.ALIGN_CENTER);
//			documento.add(imagenGen1);

			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(Chunk.NEWLINE);
			Font ff = new Font();
			ff.setStyle(Font.BOLD);
			Paragraph p7 = new Paragraph();
			p7.setFont(ff);
//			p7.setAlignment(Element.ALIGN_RIGHT);
			p7.add("                                      " + fechaActual(new Date()));
			Paragraph p8 = new Paragraph();
			p8.setFont(ff);
			p8.add(request.getNombreCliente());
			Paragraph p9 = new Paragraph();
			p9.setFont(ff);
			p9.add(folio);

			// We create the table (Creamos la tabla).
			PdfPTable tableInfo = new PdfPTable(2);
			// Ahora llenamos la tabla del PDF
			tableInfo.setWidthPercentage(100);
			tableInfo.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell columnHeader1Info = new PdfPCell(new Paragraph(""));
//			columnHeader1Info.setFixedHeight(30f);
			columnHeader1Info = new PdfPCell(new Paragraph(""));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_LEFT);
			columnHeader1Info.setFixedHeight(28f);
			columnHeader1Info.setBorder(PdfPCell.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Phrase(p7));
//			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_CENTER);
			columnHeader1Info.setBorder(PdfPCell.NO_BORDER);
			columnHeader1Info.setFixedHeight(28f);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Paragraph("                     " + request.getNombreCliente()));
			columnHeader1Info.setBorder(PdfPCell.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Phrase(""));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_RIGHT);
			columnHeader1Info.setBorder(PdfPCell.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);

			documento.add(tableInfo);

//			
//			documento.add(Chunk.NEWLINE);
//			documento.add(new Paragraph(p7));
//			documento.add(Chunk.NEWLINE);
//
//			documento.add(new Paragraph("                      " + request.getNombreCliente()));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(new Paragraph("          \n"));
			documento.add(Chunk.NEWLINE);
			documento.add(Chunk.NEWLINE);

			documento.add(Chunk.NEWLINE);
			documento.add(new Paragraph("                      " + folio));
//			List<PlantillaPdfDTO> avisoPdf = imprimirPDFsRepository.getAvisoPdf();

			documento.close();
			String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(testFile.toFile()));

			testFile.toFile().delete();
			file2.toFile().delete();
			arc.setTipo_pdf_especial("pdfEspecial Foleado");
			arc.setArchivo(ecoder);
			arc.setCode("200");
		} catch (Exception ex) {
			throw new GenericException("Error al guardar datos Respuesta pdfEspecial Foleado:: " + ex.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return arc;
	}	

	public String fechaActual(Date date) {
//		Date date = new Date();
		String fechaComplete = "";

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"));
		TimeZone timeZone = cal.getTimeZone();
		System.out.println("Time zone ID: " + timeZone.getID());
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String dia = day + "";
		String mes = FormatUtils.formatMesLetra(date);
		String anio = FormatUtils.formatAnio(date);
		fechaComplete = dia + " de " + mes + " de " + anio;
		return fechaComplete;
	}
	
	public ImpresionResponse pdfNoFoleado(PlantillaPdfDTO request, List<CatPDFEspecial> tipoPdf)
			throws GenericException, IOException {
		ImpresionResponse arc = new ImpresionResponse();
		Document documento = new Document();
		MarcaAguaEvent marcEvent = new MarcaAguaEvent();
		FileOutputStream archivo;
		InputStream ima1, ima2;
		Blob blob1, blob2;
		Path file1, file2, file3;
		URL liga1;
		try {
//			blob1 = getImagen(6);
//			blob2 = getImagen(7);
//			ima1 = blob1.getBinaryStream();
//			ima2 = blob2.getBinaryStream();

//			int blobLength = (int) blob2.length();
//			byte[] blobasbytes = blob2.getBytes(1, blobLength);
//			ImageIcon icon = new ImageIcon((byte[]) blobasbytes);
			file1 = getImagen("header");// imagen heeader
			file2 = getImagen("marcaAgua");// imagen gota de agua
//			file3 = getImagen(8); //imagen para foleado
//			file3 = getImagen(9); // imagen para no foleado dentro del texto
			file3 = tipoPdf.get(0).getArchivo();

			Image imagenGen2 = Image.getInstance(file2.toFile().getAbsolutePath());
			System.out.println("62 linea codigo imagenGen2->" + imagenGen2);
			imagenGen2.setAbsolutePosition(0f, 0f);
			imagenGen2.scaleAbsolute(600f, 785f);
			imagenGen2.setTransparency(new int[] { 0x00, 0x60 });
			marcEvent.setImagen(imagenGen2);

			System.out.println("54 linea codigo file1->" + file1);
			Path testFile = Files.createTempFile("PDFestandar", ".pdf");
			archivo = new FileOutputStream(testFile.toFile());
//			PdfWriter.getInstance(documento, archivo);

			// generar los eventos con el pdf
			PdfWriter writer = PdfWriter.getInstance(documento, archivo);
			// indicamos que objecto manejara los eventos al escribir el Pdf
			writer.setPageEvent(marcEvent);

			System.out.println("58 linea codigo request->" + request);
			documento.open();
			System.out.println("60 linea codigo file1->" + file1);
			System.out.println("60 linea codigo file1->" + file1.toString());

//			Image imagenGen2 = Image.getInstance(file2.toFile().getAbsolutePath());
//			System.out.println("62 linea codigo imagenGen2->" + imagenGen2);
//			imagenGen2.setAbsolutePosition(0f, 0f);
//			imagenGen2.scaleAbsolute(600f, 785f);
//			imagenGen2.setTransparency(new int[] { 0x00, 0x10 });
//			marcEvent.setImagen(imagenGen2);
//			documento.add(imagenGen2);

			Image imagenGen1 = Image.getInstance(file1.toFile().getAbsolutePath());
			imagenGen1.setAbsolutePosition(0f, 780f);
			imagenGen1.scaleAbsolute(595f, 66f);
			imagenGen1.setAlignment(Chunk.ALIGN_CENTER);
			documento.add(imagenGen1);

			Image imagenGen3 = Image.getInstance(file3.toFile().getAbsolutePath());
//			imagenGen3.setAbsolutePosition(0f, 780f);
			imagenGen3.scaleAbsolute(520f, 400f);
			imagenGen3.setAlignment(Chunk.ALIGN_CENTER);

			documento.add(new Paragraph("          \n"));
			documento.add(Chunk.NEWLINE);

			documento.add(Chunk.NEWLINE);
			System.out.println("64 linea codigo request->" + request);
//			documento.add(new Paragraph("Monto para inversi??n: " + request.getMontoCliente()));
			System.out.println("66 linea codigo documento->" + documento.toString());

			Font tit = new Font();
			tit.setStyle(Font.BOLD);
			tit.setSize(14);
			Paragraph titulo = new Paragraph();
			titulo.setFont(tit);
			titulo.add("Monto para inversi??n: $" + request.getMontoCliente() + "\n"
					+ "Productos Banco Garantizados por IPAB");
			titulo.setAlignment(1);
			documento.add(titulo);

			int numColumns = 4;
			int numRows = request.getListaPdfEstan().size();

			// We create the table (Creamos la tabla).
			PdfPTable table = new PdfPTable(numColumns);
			// Ahora llenamos la tabla del PDF
			PdfPCell columnHeader1, columnHeader2, columnHeader3, columnHeader4;
			// Fill table rows (rellenamos las filas de la tabla).
			Font fuente = new Font();
			fuente.setColor(BaseColor.WHITE);
			fuente.setStyle(Font.BOLD);
			tit.setSize(10);
			columnHeader1 = new PdfPCell(new Phrase("Productos", fuente));
			columnHeader1.setHorizontalAlignment(Element.ALIGN_CENTER);
			columnHeader1.setBackgroundColor(new BaseColor(58, 0, 204));
			table.addCell(columnHeader1);
			columnHeader2 = new PdfPCell(new Phrase("Tasa Bruta", fuente));
			columnHeader2.setHorizontalAlignment(Element.ALIGN_CENTER);
			columnHeader2.setBackgroundColor(new BaseColor(58, 0, 204));
			table.addCell(columnHeader2);
			columnHeader3 = new PdfPCell(new Phrase("Plazo", fuente));
			columnHeader3.setHorizontalAlignment(Element.ALIGN_CENTER);
			columnHeader3.setBackgroundColor(new BaseColor(58, 0, 204));
			table.addCell(columnHeader3);
			columnHeader4 = new PdfPCell(new Phrase("Rendimiento Bruto", fuente));
			columnHeader4.setHorizontalAlignment(Element.ALIGN_CENTER);
			columnHeader4.setBackgroundColor(new BaseColor(58, 0, 204));
			table.addCell(columnHeader4);
			table.setSpacingBefore(10f);
//			table.setSpacingAfter(10f);
			Font fuen = new Font();
			fuen.setStyle(Font.BOLD);

			if (numRows > 0) {
				Font fnt = new Font();
				fnt.setSize(10);
				fnt.setStyle(Font.BOLD);
				for (InfoPdfEstandar path : request.getListaPdfEstan()) {
					columnHeader1 = new PdfPCell(new Phrase(path.getNombreOferta(), fnt));
					columnHeader1.setHorizontalAlignment(Element.ALIGN_CENTER);
					columnHeader1.setBackgroundColor(new BaseColor(192, 192, 192));
					table.addCell(columnHeader1);
					columnHeader2 = new PdfPCell(new Phrase(formatNumber(path.getTasaOfer()) + "%", fnt));
					columnHeader2.setHorizontalAlignment(Element.ALIGN_CENTER);
					columnHeader2.setBackgroundColor(new BaseColor(192, 192, 192));
					table.addCell(columnHeader2);
					columnHeader3 = new PdfPCell(new Phrase(path.getPlazoOfer() + " dias", fnt));
					columnHeader3.setHorizontalAlignment(Element.ALIGN_CENTER);
					columnHeader3.setBackgroundColor(new BaseColor(192, 192, 192));
					table.addCell(columnHeader3);
					columnHeader4 = new PdfPCell(new Phrase("$" + formatNumber(path.getRendimientoBruto()), fnt));
					columnHeader4.setHorizontalAlignment(Element.ALIGN_CENTER);
					columnHeader4.setBackgroundColor(new BaseColor(192, 192, 192));
					table.addCell(columnHeader4);
				}
			}
			documento.add(table);
//			parte de abajo de la tabla
			Font f = new Font();
//			f.setFamily(FontFamily.COURIER.name());
			f.setStyle(Font.BOLD);
			f.setSize(7);
			Paragraph p3 = new Paragraph();
			p3.setFont(f);
			p3.add("Productos garantizados por el IPAB hasta por 400,000 Unidades de Inversi??n (UDIs) por persona y por banco");
			p3.setAlignment(1);
			documento.add(p3);

			documento.add(Chunk.NEWLINE);
			Paragraph p4 = new Paragraph();
			p4.add("Importante: Las condiciones presentadas en esta propuesta son v??lidas ??nicamente al d??a "
					+ fechaActual(new Date()));
			documento.add(p4);

			documento.add(Chunk.NEWLINE);

//			// We create the table (Creamos la tabla).
//			PdfPTable tableimg = new PdfPTable(1);
////			tableimg.setTotalWidth(550);
//			tableimg.setWidthPercentage(100);
//			tableimg.setHorizontalAlignment(Element.ALIGN_CENTER);
//			// Ahora llenamos la tabla del PDF
//			PdfPCell columnHeaderimg1;
//			columnHeaderimg1 = new PdfPCell(imagenGen3, true);
//			columnHeaderimg1.setBorder(PdfPCell.NO_BORDER);
//			columnHeaderimg1.setFixedHeight(400f);
//			tableimg.addCell(columnHeaderimg1);
//			documento.add(tableimg);
////			parte de abajo de la tabla

			documento.add(imagenGen3);
//			documento.add(imagenGen2);
			documento.add(new Paragraph("          \n"));
			if (numRows > 0) {
				for (int i = 0; i < request.getListaPdfEstan().size(); i++) {
					InfoPdfEstandar path = request.getListaPdfEstan().get(i);
					diasFestivosResponse = ObtenerDiasFeriados(path.getPlazoOfer());
					documento.add(new Paragraph(path.getNombreOferta(), fuen));
					documento.add(new Paragraph(
							"GAT Nominal " + formatNumber(path.getGatNominalOfer()) + "%  GAT Real " + formatNumber(path.getGatRealOfer()) + "%",
							fuen));
					documento.add(new Paragraph("Antes de impuestos, desde $" + path.getMontoOfer() + " a "
							+ path.getPlazoOfer() + " d??as, calculado el " + fechaActual(new Date()) + ","
							+ " y vigente al " + fechaActual(new Date())
							+ ". La GAT Real es el rendimiento que obtendr??a despu??s de descontar la inflaci??n estimada. "
							+ "La tasa de rendimiento se aplicar?? conforme a las disposiciones fiscales vigentes al vencimiento. "
							+ "La tasa de inter??s anual es fija. Consulte requisitos de contrataci??n y condiciones en www.citibanamex.com.  \r\n"
							+ "Producto ofrecido por Banco Nacional de M??xico, S.A. integrante del Grupo Financiero Banamex y garantizado por el IPAB hasta "
							+ "400 mil UDIs por persona, por banco. www.gob.mx/ipab.\r\n"));
					documento.add(Chunk.NEWLINE);
				}
			}

//tabla info complementarioa
			int numColumnsInfo = 2;
			int numRowsInfo = 4;

//			documento.add(Chunk.NEWLINE);
			// We create the table (Creamos la tabla).
			PdfPTable tableInfo = new PdfPTable(numColumnsInfo);
			// Ahora llenamos la tabla del PDF
			tableInfo.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell columnHeader1Info = new PdfPCell(new Paragraph(""));
			columnHeader1Info.setColspan(2);
			Font ff = new Font();
			ff.setStyle(Font.BOLD);
			Paragraph p5 = new Paragraph();
			p5.setFont(ff);
			p5.add("Fuiste Atendido por: ");
			Paragraph p6 = new Paragraph();
			p6.setFont(ff);
			p6.add("Sucursal: ");
			Paragraph p7 = new Paragraph();
			p7.setFont(ff);
			p7.add("Fecha: ");
			columnHeader1Info = new PdfPCell(new Paragraph(p5));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_LEFT);
			columnHeader1Info.setBorder(Rectangle.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Phrase(request.getNombreEjec()));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_LEFT);
			columnHeader1Info.setBorder(Rectangle.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Paragraph(p6));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_LEFT);
			columnHeader1Info.setBorder(Rectangle.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Phrase(request.getSirh().toString()));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_LEFT);
			columnHeader1Info.setBorder(Rectangle.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Phrase(""));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_LEFT);
			columnHeader1Info.setBorder(Rectangle.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Phrase(request.getSucursal()));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_LEFT);
			columnHeader1Info.setBorder(Rectangle.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Paragraph(p7));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_LEFT);
			columnHeader1Info.setBorder(Rectangle.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);
			columnHeader1Info = new PdfPCell(new Phrase(fechaActual(new Date())));
			columnHeader1Info.setHorizontalAlignment(Element.ALIGN_LEFT);
			columnHeader1Info.setBorder(Rectangle.NO_BORDER);
			tableInfo.addCell(columnHeader1Info);

			documento.add(tableInfo);

			List<PlantillaPdfDTO> avisoPdf = imprimirPDFsRepository.getAvisoPdf();

			if (avisoPdf.isEmpty() || avisoPdf == null || avisoPdf.size() == 0) {
				throw new GenericException("La tabla de avisoPdf est?? vac??a.", HttpStatus.NOT_FOUND.toString());
			}

			int numColumnsAviso = 1;
			int numRowsAviso = avisoPdf.size();
			String validaVacio = quitaSpacios(avisoPdf.get(0).getParametroAviso());
			System.out.println("289 linea codigo avisoPdf.get(0).getParametroAviso() ->"
					+ avisoPdf.get(0).getParametroAviso() + "mre");
			documento.add(Chunk.NEWLINE);
			if (avisoPdf.get(0).getParametroAviso() == null || avisoPdf.get(0).getParametroAviso().equals("")
					|| validaVacio.equals("")) {
				System.out.println("289 linea codigo request->" + request);
			} else {
				// We create the table (Creamos la tabla).
				System.out.println("289 linea codigo request->" + request);
				PdfPTable tableAviso = new PdfPTable(numColumnsAviso);
				// Ahora llenamos la tabla del PDF
				PdfPCell columnHeader1Aviso;
				// Fill table rows (rellenamos las filas de la tabla).
				Font fuenteAviso = new Font();
				fuenteAviso.setColor(BaseColor.WHITE);
				fuenteAviso.setSize(16);
				columnHeader1Aviso = new PdfPCell(new Phrase("AVISO IMPORTANTE", fuenteAviso));
				columnHeader1Aviso.setHorizontalAlignment(Element.ALIGN_CENTER);
				columnHeader1Aviso.setBackgroundColor(new BaseColor(58, 0, 204));
				tableAviso.addCell(columnHeader1Aviso);

				System.out.println("289 linea codigo request->" + request);
				if (numRowsAviso > 0) {
					for (PlantillaPdfDTO path : avisoPdf) {
						columnHeader1 = new PdfPCell(new Phrase(path.getParametroAviso()));
						columnHeader1.setHorizontalAlignment(Element.ALIGN_CENTER);
						columnHeader1.setBackgroundColor(new BaseColor(192, 192, 192));
						tableAviso.addCell(columnHeader1);
					}
				}
				System.out.println("289 linea codigo avisoPdf->" + avisoPdf);

				documento.add(tableAviso);
			}
			System.out.println("289 linea codigo documento->" + documento);
			documento.close();
			System.out.println("289 linea codigo documento->" + documento);
			writer.close();
			System.out.println("289 linea codigo documento->" + documento);
			String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(testFile.toFile()));

			System.out.println("289 linea codigo ecoder->" + ecoder);
			testFile.toFile().delete();
			file1.toFile().delete();
			file2.toFile().delete();
			file3.toFile().delete();
			arc.setTipo_pdf_especial("pdfEspecial no Foleado");
			arc.setArchivo(ecoder);
			arc.setCode("200");
		} catch (Exception ex) {
			throw new GenericException("Error al generar el pdfEspecial no Foleado:: " + ex.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return arc;
	}
	
	public Path getImagen(String tipo) throws GenericException, IOException, ParseException {

		List<CatPDFEspecial> tipoPdf = new ArrayList<CatPDFEspecial>();

		tipoPdf = imprimirPDFsRepository.getPlantillaPdf(tipo);

		if (tipoPdf.isEmpty() || tipoPdf == null || tipoPdf.size() == 0) {
			throw new GenericException("La tabla de PdfEspecial no encontro la plantilla o imagen.",
					HttpStatus.NOT_FOUND.toString());
		}
		return tipoPdf.get(0).getArchivo();
	}
	
	public List<DiasFestivosResponseDTO> ObtenerDiasFeriados(int request) throws GenericException, IOException {
		//.intValue()
		SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy"); 
		Date  actual=  new Date();
		Date  actuals=  new Date();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy"); 
		int aumento = 0;
		int plazo = 0;
		int validacion = 0;
		int a = 0;
		int p = request;
		lstdias = diasFestivosRepo.obtenerListaFechas();
		List<DiasFestivosResponseDTO> diasFestivosResponse = new ArrayList<DiasFestivosResponseDTO>();
		try{
		    c.setTime(actual);
	        c.add(Calendar.DATE, p);
	        actual = c.getTime();
	        objSDF.applyLocalizedPattern("E");
	        System.out.println( "1 :: "+objSDF2.format(actual).toString());
			for(DiasFestivos dia : lstdias) {
		        System.out.println( "2 ::: "+objSDF2.format(actual).toString());
				c.setTime(actual);
		        c.add(Calendar.DATE, aumento);
		       actual = c.getTime();
		       System.out.println( "56 ::: "+objSDF2.format(actual).toString());
				if(objSDF2.format(actual).toString().equals(objSDF2.format(dia.getFECHA()))) {
					 System.out.println( ":: "+objSDF2.format(dia.getFECHA()).toString());
			            validacion =1;
			            if(objSDF.format(actual).toString().equals("s??b") || objSDF.format(actual).toString().equals("Sat")) {
			            	c.setTime(actual);
			            	aumento = 2;
			                c.add(Calendar.DATE, 2);
			                actual = c.getTime();
			                plazo = p +aumento;
			                System.out.println("e1");
			                System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actual));
			                diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actual)));
			            }else if (objSDF.format(actual).toString().equals("dom") || objSDF.format(actual).toString().equals("Sun")) {
							c.setTime(actual);
							aumento = 1;
							c.add(Calendar.DATE, aumento);
							actual = c.getTime();
							plazo = p+aumento;
							 System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actual));
							 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actual)));
							System.out.println("e4");
						}
			            	a =1;
			            	aumento++;	
			            	System.out.println("aumento "+ aumento);
				}
			}
			if(a == 1) {
				plazo = p +aumento;
				c.setTime(actuals);
	            c.add(Calendar.DATE, (p +aumento));
	            actuals = c.getTime();
	            if(objSDF.format(actuals).toString().equals("s??b") || objSDF.format(actuals).toString().equals("Sat")) {
	            	c.setTime(actuals);
	            	aumento = 2;
	                c.add(Calendar.DATE, 2);
	                actuals = c.getTime();
	                plazo = p +aumento;
	                System.out.println("e1");
	                System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actuals));
	                diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actuals)));
	            }else if (objSDF.format(actuals).toString().equals("dom") || objSDF.format(actuals).toString().equals("Sun")) {
					c.setTime(actuals);
					aumento = 1;
					c.add(Calendar.DATE, aumento);
					actuals = c.getTime();
					plazo = p+aumento;
					 System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actuals));
					 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actuals)));
					System.out.println("e4");
				}else {
					 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actuals)));
				}
	      

			}

			System.out.println(aumento+ " :: " +objSDF2.format(actual));
			if(validacion == 0) {
				if(objSDF.format(actual).toString().equals("s??b") || objSDF.format(actual).toString().equals("Sat")) {
					c.setTime(actual);
					aumento = 2;
					c.add(Calendar.DATE, aumento);
					actual = c.getTime();
					plazo = p +aumento;
					 System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actual));
					 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actual)));
					System.out.println("e3");
				}else if (objSDF.format(actual).toString().equals("dom") || objSDF.format(actual).toString().equals("Sun")) {
					c.setTime(actual);
					aumento = 1;
					c.add(Calendar.DATE, aumento);
					actual = c.getTime();
					plazo = p +aumento;
					 System.out.println("plazo "+Long.valueOf(plazo)+" fecha "+objSDF2.format(actual));
					 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo), objSDF2.format(actual)));
					System.out.println("e4");
				}else {
					 System.out.println("plazo "+p+" fecha "+objSDF2.format(actual));
					 diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(request), objSDF2.format(actual)));
					System.out.println("e5");

				}
				
			}
			
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		return diasFestivosResponse;
	}
	
	public String quitaSpacios(String args) {
		String result = "";
		System.out.println("911 line codigo args ->" + args + "dotos");
		if (args != null) {
			result = args.replaceAll("\\s+", "");
			System.out.println("911 line codigo result ->" + result + "dotos");
		}
		return result;
	}
    
    private BigDecimal formatNumber(double monto) {		
		BigDecimal formatNumber = new BigDecimal(monto);
		formatNumber = formatNumber.setScale(2, RoundingMode.HALF_UP);
    return formatNumber;
    }
    
    
	
	public BigInteger IdAutotsa() throws GenericException, IOException {
		  String mensaje = null ;
	         SimpleDateFormat objSDF2 = new SimpleDateFormat("yyMMdd");
	         Date  fecha=  new Date();
	         BigInteger id_Tasa_long_n =new BigInteger("1"); 
	         BigInteger folio; 
			try {
			
			//
			SimpleDateFormat objSDF5 = new SimpleDateFormat("yyyy/dd/MM");
			Date  fechaAct=  new Date();
			objSDF5.format(fechaAct);
			Calendar cs = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"));
			cs.setTime(fechaAct);
			//
			id_Tasa_long = autoTasaRepo.ObtenerUltFolioAutoTasas(objSDF5.format(cs.getTime()));
			LOGGER.debug( id_Tasa_long.toString());
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
			
			folio = res;

			}catch (Exception ex) {
				throw new GenericException("Error",
						HttpStatus.INTERNAL_SERVER_ERROR.toString());
			}
			return folio;
	}
/*	@Override
	public BigInteger CrearIdAutotsa() throws GenericException, IOException {
		// TODO Auto-generated method stub
		return null;
	}*/
}
