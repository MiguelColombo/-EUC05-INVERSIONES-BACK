package com.citi.euces.solicitudes.infra.dto;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class MarcaAguaEvent extends  PdfPageEventHelper {
	
	private Image imagen;
	
    /**
     * Constructor de la clase, inicializa la imagen que se utilizara en el membrete
     */
    public MarcaAguaEvent()
    {
    }
    
    /**
     * Manejador del evento onEndPage, usado para generar el encabezado onStartPage
     */
    @Override
    public void onEndPage(PdfWriter writer, Document document) {

        try{            
            document.add(this.imagen);            
         }catch(Exception doc)
         {
             doc.printStackTrace();
         }        
     }

	/**
	 * @return the imagen
	 */
	public Image getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
    
    
}