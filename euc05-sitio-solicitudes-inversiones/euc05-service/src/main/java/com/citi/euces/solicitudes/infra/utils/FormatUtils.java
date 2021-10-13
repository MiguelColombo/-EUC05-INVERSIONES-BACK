package com.citi.euces.solicitudes.infra.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormatUtils {

static final Logger log = LoggerFactory.getLogger(FormatUtils.class);
	
	public static Date stringToDate(String fecha) throws ParseException {
        String pattern = "dd/MM/yyyy";
        Date formatFecha = new SimpleDateFormat(pattern).parse(fecha);
        return formatFecha;
    }
	
	public static String formatDateymd(Date fecha) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatFecha = simpleDateFormat.format(fecha);
        return formatFecha;

    }

    public static String formatDatedmy(Date fecha) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatFecha = simpleDateFormat.format(fecha);
        return formatFecha;
    }

    public static String formatDateSinEspacios(Date fecha) {
        String pattern = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatFecha = simpleDateFormat.format(fecha);
        return formatFecha;
    }

    public static String formatDateSinEspacios1(Date fecha) {
        String pattern = "yyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatFecha = simpleDateFormat.format(fecha);
        return formatFecha;
    }

    public static String formatDateSinEspacios2(Date fecha) {
        String pattern = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatFecha = simpleDateFormat.format(fecha);
        return formatFecha;
    }
    
    public static Date DateCobros(String fecha) throws ParseException{
    	String pattern = "yyyyMMdd";
		Date format = new SimpleDateFormat(pattern).parse(fecha);
        return format; 
    }
    
    public static String formatFecCompActual() {
    	String pattern = "dd_MM_yyyy HH_mm_ss aaa";
    	Date fecha = new Date();
    	SimpleDateFormat format = new SimpleDateFormat(pattern);
    	return format.format(fecha); 
    }
    
    public static String formatFecActual () {
    	String pattern = "yyyy-MM-dd";
    	Date fecha = new Date();
    	SimpleDateFormat format = new SimpleDateFormat(pattern);
    	return format.format(fecha);
    }

    public static String formatMes(Date fecha) {
    	SimpleDateFormat formatFecha = new SimpleDateFormat("MM");
    	String mes = null;
    	switch (formatFecha.format(fecha)){
    		case "01": mes = "ENE";
    			break;
    		case "02": mes = "FEB";
    			break;
    		case "03": mes = "MAR";
    			break;
    		case "04": mes = "ABR";
    			break;
    		case "05": mes = "MAY";
    			break;
    		case "06": mes = "JUN";
    			break;
    		case "07": mes = "JUL"; 
    			break;
    		case "08": mes = "AGO";
    			break;
    		case "09": mes = "SEP";
    			break;
    		case "10": mes = "OCT";
    			break; 
    		case "11": mes = "NOV";
    			break;
    		case "12": mes = "DIC";
    			break;
    		default: mes = "Error en el mes";
            	break;
    	}
    	return mes;
    }
    
    public static String formatMesLetra(Date fecha) {
    	SimpleDateFormat formatFecha = new SimpleDateFormat("MM");
    	String mes = null;
    	switch (formatFecha.format(fecha)){
    		case "01": mes = "Enero";
    			break;
    		case "02": mes = "Febrero";
    			break;
    		case "03": mes = "Marzo";
    			break;
    		case "04": mes = "Abril";
    			break;
    		case "05": mes = "Mayo";
    			break;
    		case "06": mes = "Junio";
    			break;
    		case "07": mes = "Julio"; 
    			break;
    		case "08": mes = "Agosto";
    			break;
    		case "09": mes = "Septiembre";
    			break;
    		case "10": mes = "Octubre";
    			break; 
    		case "11": mes = "Noviembre";
    			break;
    		case "12": mes = "Diciembre";
    			break;
    		default: mes = "Error en el mes";
            	break;
    	}
    	return mes;
    }
    
    public static String formatAnio(Date fecha) {
    	SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy");
    	return formatFecha.format(fecha);
    }
    
    public static String formatFecFin(Date fecha) {
    	SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
    	return formatoSalida.format(fecha);
    }


    public static String formatFateFileExcel(){
        SimpleDateFormat df = new SimpleDateFormat("dd_MM_yyyy hh_mm_ss a");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"));
        calendar.setTime(new Date());
        return df.format(calendar.getTime());
    }

	// Suma los días recibidos a la fecha  
	 public static Date sumarRestarDiasFecha(Date fecha, int dias){
	      Calendar calendar = Calendar.getInstance();
	      
	      calendar.setTime(fecha); // Configuramos la fecha que se recibe
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
	 
	      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	 }

	 public static String createEncryptStringNomina(String dataString) {
			try {
				String valor = StringUtilsCiti.encrypt(dataString, ConstantUtils.SECRET_KEY);
				return valor;
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}

	 public static String createEncryptStringNumCliente(String dataString) {
			try {
				String valor = StringUtilsCiti.encrypt(dataString, ConstantUtils.SECRET_KEY);
				return valor;
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
	 
		public static String desencryptData(String dataString) {
			try {
				String userJSON = StringUtilsCiti.decrypt(dataString, ConstantUtils.SECRET_KEY);
				return userJSON;
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
}
