package com.citi.euces.solicitudes.infra.utils;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import com.citi.euces.solicitudes.infra.exceptions.GenericException;

public class BodyMail {
	
	 public String GetKey()
     {
         return "Citibanamex2018X";
     }

     public String GetBuzon()
     {
         return "uec";
         //return "sr55081";
     }

     public String GetMailUEC()
     {
        return "uec@banamex.com";
        //return "sr55081@imcla.lac.nsroot.net";
     }

     public String GetTitleSolicitud()
     {
         return "Solicitud de Aprobación de Tasa Especial";
     }
     
     public String BodySolicitudAutorizadorUEC(Timestamp fecha_solic, String Folio_BancaNet, String TIPO_AUTORI,
 			String JUSTIFICACION, String NOMEJEC, String NOM_CTE, BigInteger NUM_CTE, BigInteger CONTRATO, String MONTO, Long PLAZO,
 			String TASA_AUTORI, String idtasaEncrypt, String strAceptada, String strRechadaza, String suc,
 			String nombre_autorizador, String soeidEncrypt)  throws GenericException, IOException {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 		String fechaComoCadena = sdf.format(fecha_solic);
 		String body = null;
 		try {
 			String folioPortabilidad = "";
 		
 			if(TASA_AUTORI.equals("PORTAESPNOM") && !Folio_BancaNet.isEmpty()) {
 				folioPortabilidad = "         <tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Folio Bancanet de Portabilidad:</td></tr> "
						+ "         <tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size=8pt'><b>"
						+ Folio_BancaNet + "</b></td></tr>";
 			}
     			
 			body =  "<html xmlns =\"http://www.w3.org/1999/xhtml\">"
	                + "<head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /> "
					+ "<title> Form Confirmation </title> </head>" + "<body>"
					+ "<b style = 'font-family: Verdana, Arial, Helvetica, sans-serif; '> Aviso. </b><br /><br />"
					+ "<table width = '50%' style='border:solid 2px #1A5B97; background:#1A5B97; font-family: Verdana, Arial, Helvetica, sans-serif'> "
					+ "<tr> <td style='font-size:20;font-weight:bold;color:#FFFFFF' align = 'center'>Estimado(a):"
					+ nombre_autorizador + " <br /></td></tr>"
					+ "<tr> <td style='text-align:right;color:#FFFFFF'; font-size = 8pt'>Fecha:<b>" + fechaComoCadena
					+ "</b> <br/><br/></td> </tr> "
					+ "<tr> <td style='text-align:left;font-size: 10px;font-weight:bold;color:#FFFFFF';> Se ha generado una solicitud de tasa: ESPECIAL,"
					+ TIPO_AUTORI + " con la siguiente información:<br/><br/></td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>1.-Núm.y Suc.Operadora: </td></tr>"
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ suc + "</b></td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>2.-Nombre de Cliente:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ NOM_CTE + "</b> </td> </tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>3.-Número de Cliente:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ NUM_CTE + "</b> </td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>4.-Número de Contrato:</td></tr>"
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b>"
					+ CONTRATO + "</b> </td> </tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>5.-Monto:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b>"
					+ MONTO + "</b> </td> </tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>6.-Plazo:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ PLAZO + "</b> </td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>7.-Tasa Bruta Solic:</td> </tr>         "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ TASA_AUTORI + "</b> %</td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Justificación de solicitud:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ JUSTIFICACION + "</b></td></tr>" + "" + folioPortabilidad + "" + "<tr> <td> <br/> </td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size=8pt'>Nombre del solicitante:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b> "
					+ NOMEJEC + "</b> </td> </tr>" + "<tr> <td><br /></td></tr> "
					+ "<tr> <td style='background-color:#F2F2F2;text-align:center;font-size:6px;font-weight:bold;color:#5377A9'> Gracias por su atención. (Unidad Especializada de Comercialización.) </td></tr> "
					+ " </table> " + "</body>" + "</html>";


 		} catch (Exception ex) {
 			System.out.println("ex ->" + ex.getMessage());
 			System.out.println("ex ->" + ex.getCause());
 		}

 		return body;
 	}
     
     public String BodySolicitud(Timestamp fecha_solic, String Folio_BancaNet, String TIPO_AUTORI, String JUSTIFICACION,
 			String NOMEJEC, String NOM_CTE, BigInteger NUM_CTE, BigInteger CONTRATO, String MONTO, Long PLAZO, String TASA_AUTORI,
 			String idtasaEncrypt, String strAceptada, String strRechadaza, String suc, String nombre_autorizador,
 			String soeidEncrypt, String urlRedirect, String linksAutoriza, String linksRechazas)  throws GenericException, IOException {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 		String fechaComoCadena = sdf.format(fecha_solic);
 		String body = null;
 			try {
 				String folioPortabilidad = "";
 				if (TIPO_AUTORI.equals("PORTAESPNOM") && !Folio_BancaNet.isEmpty()) {
 					folioPortabilidad = "         <tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Folio Bancanet de Portabilidad:</td></tr> "
 							+ "         <tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size=8pt'><b>"
 							+ Folio_BancaNet + "</b></td></tr>";
 				}

 				body = "<html xmlns =\"http://www.w3.org/1999/xhtml\">"
 		                + "<head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /> "
 						+ "<title> Form Confirmation </title> </head>" + "<body>"
 						+ "<b style = 'font-family: Verdana, Arial, Helvetica, sans-serif; '> Aviso. </b><br /><br />"
 						+ "<table width = '50%' style='border:solid 2px #1A5B97; background:#1A5B97; font-family: Verdana, Arial, Helvetica, sans-serif'> "
 						+ "<tr> <td style='font-size:20;font-weight:bold;color:#FFFFFF' align = 'center'>Estimado(a):"
 						+ nombre_autorizador + " <br /></td></tr>"
 						+ "<tr> <td style='text-align:right;color:#FFFFFF'; font-size = 8pt'>Fecha:<b>" + fechaComoCadena
 						+ "</b> <br/><br/></td> </tr> "
 						+ "<tr> <td style='text-align:left;font-size: 10px;font-weight:bold;color:#FFFFFF';> Se ha generado una solicitud de tasa: ESPECIAL,"
 						+ TIPO_AUTORI + "," + idtasaEncrypt + " con la siguiente información:<br/><br/></td></tr>"
 						+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>1.-Núm.y Suc.Operadora: </td></tr>"
 						+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
 						+ suc + "</b></td></tr>"
 						+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>2.-Nombre de Cliente:</td></tr> "
 						+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
 						+ NOM_CTE + "</b> </td> </tr>"
 						+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>3.-Número de Cliente:</td></tr> "
 						+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
 						+ NUM_CTE + "</b> </td></tr>"
 						+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>4.-Número de Contrato:</td></tr>"
 						+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b>"
 						+ CONTRATO + "</b> </td> </tr>"
 						+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>5.-Monto:</td></tr> "
 						+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b>"
 						+ MONTO + "</b> </td> </tr>"
 						+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>6.-Plazo:</td></tr> "
 						+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
 						+ PLAZO + "</b> </td></tr>"
 						+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>7.-Tasa Bruta Solic:</td> </tr>         "
 						+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
 						+ TASA_AUTORI + "</b> %</td></tr>"
 						+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Justificación de solicitud:</td></tr> "
 						+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
 						+ JUSTIFICACION + "</b></td></tr>" + "" + folioPortabilidad + "" + "<tr> <td> <br/> </td></tr>"
 						+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size=8pt'>Nombre del solicitante:</td></tr> "
 						+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b> "
 						+ NOMEJEC + "</b> </td> </tr>" + "<tr> <td><br /></td></tr> "
 						+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'> Para Confirmar o Rechazar La solicitud, haga Clic en los siguientes botónes:<br/><br/></td> </tr>"
 						+ "<tr> <td style='background-color:#E3F6CE;text-align:left;font-size:10px;font-weight:bold;color:#5E610B'></td> </tr>"
 						+ "<tr> <td align='center' style='text-align:center;font-size:8pt'>" + 
 						"  <a href = '" + urlRedirect + "?data=" + linksAutoriza
 		                        + "' style = 'background-color:#7CC3C6; font-size:18px; font-weight:300; font-family:Verdana, Helvetica, sans-serif;  color:#ffffff;  text-decoration:none' > -Autorizar -</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; "
 		                        + "    <a href = '" + urlRedirect + "?data=" + linksRechazas
 		                        + "' style = 'background-color:#EC8153; font-size:18px; font-weight:300; font-family:Verdana, Helvetica, sans-serif;  color:#ffffff;  text-decoration:none' > -Rechazar -</a> "
 						+ "<tr> <td style='background-color:#F2F2F2;text-align:center;font-size:6px;font-weight:bold;color:#5377A9'> Gracias por su atención. (Unidad Especializada de Comercialización.) </td></tr> "
 						+ " </table> " + "</body>" + "</html>";


 			} catch (Exception ex) {
 				System.out.println("ex ->" + ex.getMessage());
 				System.out.println("ex ->" + ex.getCause());
 			}
 			return body;
  	}


}
