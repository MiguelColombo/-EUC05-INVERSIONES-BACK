package com.citi.euces.solicitudes.infra.utils;

import com.citi.euces.solicitudes.infra.dto.EnviarPHPBEDTO;

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
     
     public String BodySolicitudAutorizadorUEC(EnviarPHPBEDTO request, String sucursal, String strAceptada, String strRechadaza) {
 		String body = null;
 		String folioPortabilidad = "";
 		
     	if(request.getTipo_Autori().equals("PORTAESPNOM") && !request.getFolioBantanet().isEmpty()) {
     		folioPortabilidad = "         <tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Folio Bancanet de Portabilidad:</td></tr> " +
                             "         <tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size=8pt'><b>" + request.getFolioBantanet() + "</b></td></tr>";
     	}
     			
     		body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
     				+ "<html xmlns =\"http://www.w3.org/1999/xhtml\">"
     				+ "<head><meta http - equiv =\"Content-Type\" content=\"text/html; charset="+"UTF-8"+"/>"
     				+ "<title> Form Confirmation </title> </head>"
     				+ "</head>"
     				+ "<body>"
     				+ "<b style = 'font-family: Verdana, Arial, Helvetica, sans-serif; '> Aviso. </b><br /><br />"
     				+ "<table width = '50%' style='border:solid 2px #1A5B97; background:#1A5B97; font-family: Verdana, Arial, Helvetica, sans-serif'> "	
     		        + "<tr> <td style='font-size:20;font-weight:bold;color:#FFFFFF' align = 'center'>Estimado(a):"+request.getNombre_Autori() + " <br /></td></tr>"
     		        + "<tr> <td style='text-align:right;color:#FFFFFF'; font-size = 8pt'>Fecha:<b>"+ request.getFecha_Solic()+"</b> <br/><br/></td> </tr> "
     		        + "<tr> <td style='text-align:left;font-size: 10px;font-weight:bold;color:#FFFFFF';> Se ha generado una solicitud de tasa: ESPECIAL,"+  request.getTipo_Autori()+" con la siguiente información:<br/><br/></td></tr>"
     		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>1.-Núm.y Suc.Operadora: </td></tr>"
     		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+sucursal+ "</b></td></tr>" //request.getSuc_Solic() 
     		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>2.-Nombre de Cliente:</td></tr> "
     		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getNom_Cte()+"</b> </td> </tr>"
     		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>3.-Número de Cliente:</td></tr> "
     		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getNum_Cte() +"</b> </td></tr>"
     		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>4.-Número de Contrato:</td></tr>"
     		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b>"+request.getContrato() +"</b> </td> </tr>"
     		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>5.-Monto:</td></tr> "
     		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b>"+request.getMonto()+ "</b> </td> </tr>"
     		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>6.-Plazo:</td></tr> "
     		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getPlazo() +"</b> </td></tr>"
     		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>7.-Tasa Bruta Solic:</td> </tr>         "
     		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getTasa_Autori() +"</b> %</td></tr>"
     		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Justificación de solicitud:</td></tr> "
     		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getJustificacion() +"</b></td></tr>"
     		        + ""+folioPortabilidad +""
     		        + "<tr> <td> <br/> </td></tr>"
     		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size=8pt'>Nombre del solicitante:</td></tr> "
     		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b> "+request.getNomejec() +"</b> </td> </tr>"
     		        + "<tr> <td><br /></td></tr> "
     		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'> Para Confirmar o Rechazar La solicitud, haga Clic en los siguientes botónes:<br/><br/></td> </tr>"
     		        + "<tr> <td style='background-color:#E3F6CE;text-align:left;font-size:10px;font-weight:bold;color:#5E610B'></td> </tr>"
     		        + "<tr> <td align='center' style='text-align:center;font-size:8pt'>"
     		        + "    <a href='http://10.224.80.191:91/TasasAuto/VoBoTasaAuto.aspx?SOEID="+request.getSoeid()+"&TASA="+request.getId_AutoTasa()+"&ESTATUS= "+strAceptada+"' style='background-color:#7CC3C6; font-size:18px; font-weight:300; font-family:Verdana, Helvetica,sans-serif; color:#ffffff; text-decoration:none'> -Autorizar -</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
     		        + "    <a href='http://10.224.80.191:91/TasasAuto/VoBoTasaAuto.aspx?SOEID="+request.getSoeid()+"&TASA="+request.getId_AutoTasa()+"&ESTATUS= "+strRechadaza+"' style='background-color:#EC8153; font-size:18px; font-weight:300; font-family:Verdana, Helvetica, sans-serif; color:#ffffff; text-decoration:none'> -Rechazar -</a>"
     		        + "</td> </tr>"
     		        + "<tr> <td style='background-color:#F2F2F2;text-align:center;font-size:6px;font-weight:bold;color:#5377A9'> Gracias por su atención. (Unidad Especializada de Comercialización.) </td></tr> "
     		        + " </table> "
     		        + "</body>"
     		        + "</html>";
 		return body;
 	}
     
     public String BodySolicitud(EnviarPHPBEDTO request, String sucursal, String strAceptada, String strRechadaza) {
  		String body = null;
  		String folioPortabilidad = "";
  		
      	if(request.getTipo_Autori().equals("PORTAESPNOM") && !request.getFolioBantanet().isEmpty()) {
      		folioPortabilidad = "         <tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Folio Bancanet de Portabilidad:</td></tr> " +
                              "         <tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size=8pt'><b>" + request.getFolioBantanet() + "</b></td></tr>";
      	}
      			
      		body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
      				+ "<html xmlns =\"http://www.w3.org/1999/xhtml\">"
      				+ "<head><meta http - equiv =\"Content-Type\" content=\"text/html; charset="+"UTF-8"+"/>"
      				+ "<title> Form Confirmation </title> </head>"
      				+ "</head>"
      				+ "<body>"
      				+ "<b style = 'font-family: Verdana, Arial, Helvetica, sans-serif; '> Aviso. </b><br /><br />"
      				+ "<table width = '50%' style='border:solid 2px #1A5B97; background:#1A5B97; font-family: Verdana, Arial, Helvetica, sans-serif'> "	
      		        + "<tr> <td style='font-size:20;font-weight:bold;color:#FFFFFF' align = 'center'>Estimado(a):"+request.getNombre_Autori() + " <br /></td></tr>"
      		        + "<tr> <td style='text-align:right;color:#FFFFFF'; font-size = 8pt'>Fecha:<b>"+ request.getFecha_Solic()+"</b> <br/><br/></td> </tr> "
      		        + "<tr> <td style='text-align:left;font-size: 10px;font-weight:bold;color:#FFFFFF';> Se ha generado una solicitud de tasa: ESPECIAL,"+  request.getTipo_Autori()+" con la siguiente información:<br/><br/></td></tr>"
      		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>1.-Núm.y Suc.Operadora: </td></tr>"
      		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+sucursal+ "</b></td></tr>" //request.getSuc_Solic() 
      		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>2.-Nombre de Cliente:</td></tr> "
      		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getNom_Cte()+"</b> </td> </tr>"
      		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>3.-Número de Cliente:</td></tr> "
      		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getNum_Cte() +"</b> </td></tr>"
      		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>4.-Número de Contrato:</td></tr>"
      		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b>"+request.getContrato() +"</b> </td> </tr>"
      		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>5.-Monto:</td></tr> "
      		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b>"+request.getMonto()+ "</b> </td> </tr>"
      		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>6.-Plazo:</td></tr> "
      		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getPlazo() +"</b> </td></tr>"
      		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>7.-Tasa Bruta Solic:</td> </tr>         "
      		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getTasa_Autori() +"</b> %</td></tr>"
      		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Justificación de solicitud:</td></tr> "
      		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getJustificacion() +"</b></td></tr>"
      		        + ""+folioPortabilidad +""
      		        + "<tr> <td> <br/> </td></tr>"
      		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size=8pt'>Nombre del solicitante:</td></tr> "
      		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b> "+request.getNomejec() +"</b> </td> </tr>"
      		        + "<tr> <td><br /></td></tr> "
      		        + "<tr> <td style='background-color:#F2F2F2;text-align:center;font-size:6px;font-weight:bold;color:#5377A9'> Gracias por su atención. (Unidad Especializada de Comercialización.) </td></tr> "
      		        + " </table> "
      		        + "</body>"
      		        + "</html>";
  		return body;
  	}


}
