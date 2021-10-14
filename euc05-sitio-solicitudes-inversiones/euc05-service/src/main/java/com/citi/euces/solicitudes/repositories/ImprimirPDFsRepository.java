package com.citi.euces.solicitudes.repositories;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.FileUtils;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.solicitudes.infra.dto.CatFolioDTO;
import com.citi.euces.solicitudes.infra.dto.CatPDFEspecial;
import com.citi.euces.solicitudes.infra.dto.ConfigPdfDTO;
import com.citi.euces.solicitudes.infra.dto.PlantillaPdfDTO;
import com.citi.euces.solicitudes.infra.exceptions.GenericException;



@Repository
public class ImprimirPDFsRepository {


	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(ImprimirPDFsRepository.class);
	
	public ImprimirPDFsRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//	@Transactional
//	public List<PdfImagenDto> getImagen(Integer tipo) throws GenericException
//	{
//		List<PdfImagenDto> lista = new ArrayList<PdfImagenDto>();
//		Statement stmt = null;
//		FileOutputStream output = null;
//		InputStream input = null;
//		Integer input2 = null;
//		Integer input3 = null;
//		try {
//			String sql = "SELECT IMAGEN,ID_IMAGEN,TIPO_SLIDER FROM PER_CAT_IMAGENES WHERE TIPO_SLIDER = " + tipo;
//			Connection conn = jdbcTemplate.getDataSource().getConnection();
//            stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            
//            
//            while(rs.next()) {
//            	PdfImagenDto archivo = new PdfImagenDto();
//            	Path testFile = Files.createTempFile("imagen"+tipo, ".png");
//                output = new FileOutputStream(testFile.toFile());
//                input = rs.getBinaryStream("IMAGEN");
//            	input2 = rs.getInt("ID_IMAGEN");
//            	input3 = rs.getInt("TIPO_SLIDER");
//            	
//            	byte[] buffer = new byte[1024];
//                while (input.read(buffer) > 0) {
//                    output.write(buffer);
//                }
//                System.out.println("> Archivo guardado en : " + testFile.getFileName());
//                String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(testFile.toFile()));
//                archivo.setIdImagen(input2);
//                archivo.setImagen(testFile);
//                archivo.setTipoSlider(input3);
//                lista.add(archivo);
////                testFile.toFile().delete();
//            }
//            
//            return lista;
//		}catch (Exception e) {
//			e.getStackTrace();
//            throw new GenericException( "Error al obtener las imagenes :: " , HttpStatus.NOT_FOUND.toString());
//        }
//	}
//	
	
	@Transactional
	public List<PlantillaPdfDTO> getAvisoPdf()throws GenericException {
		try {

			String sql = "SELECT PARAMETRO_VALOR FROM PER_CAT_PARAMETROS WHERE PARAMETRO_NOM = 'AVISO PDF' ";

			System.out.println("QUERY_SQL_ getAvisoPdf :: ejecute:: " + sql);

			return jdbcTemplate.query(sql, (rs, rowNum) -> new PlantillaPdfDTO(rs.getString("PARAMETRO_VALOR")));
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar getAvisoPdf :: ",
					HttpStatus.NOT_FOUND.toString());
		}
	}
	

	@Transactional
	public List<ConfigPdfDTO> getConfigPdf(String pdfEspecial)throws GenericException {
		try {

			String sql = "SELECT PDF_ID, PDF_NOMBRE, PDF_TIPO, FOLIO_ID FROM PER_CAT_CONFIGURACION_PDF WHERE PDF_ID = '"+pdfEspecial+"' ";

			System.out.println("QUERY_SQL_ getConfigPdf :: ejecute:: " + sql);

			return jdbcTemplate.query(sql, (rs, rowNum) -> new ConfigPdfDTO(rs.getString("PDF_ID"),rs.getString("PDF_NOMBRE"),
					rs.getInt("PDF_TIPO"),rs.getString("FOLIO_ID")));
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar getConfigPdf :: ",
					HttpStatus.NOT_FOUND.toString());
		}
	}
	
	@Transactional
	public List<CatPDFEspecial> getPlantillaPdf(String tipo) throws GenericException
	{
		List<CatPDFEspecial> lista = new ArrayList<CatPDFEspecial>();
		Statement stmt = null;
		FileOutputStream output = null;
		InputStream input = null;
		String input2 = null;
		String input3 = null;
		try {
			String sql = "SELECT PDF_ESPECIAL_ARCHIVO, PDF_ESPECIAL_OFERTA_ID, PDF_ESPECIAL_NOMBRE FROM PER_CAT_PDF_ESPECIAL WHERE PDF_ESPECIAL_OFERTA_ID = '" + tipo + "'";
			Connection conn = jdbcTemplate.getDataSource().getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            
            while(rs.next()) {
            	CatPDFEspecial archivo = new CatPDFEspecial();
            	Path testFile = Files.createTempFile("imagen"+tipo, ".png");
                output = new FileOutputStream(testFile.toFile());
                input = rs.getBinaryStream("PDF_ESPECIAL_ARCHIVO");
            	input2 = rs.getString("PDF_ESPECIAL_OFERTA_ID");
            	input3 = rs.getString("PDF_ESPECIAL_NOMBRE");
            	
            	byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                System.out.println("> Archivo guardado en : " + testFile.getFileName());
                String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(testFile.toFile()));
                archivo.setIdPdfEspecial(input2);
                archivo.setArchivo(testFile);
                archivo.setNombrePdfEspecial(input3);
                lista.add(archivo);
//                testFile.toFile().delete();
            }
            
            return lista;
		}catch (Exception e) {
			e.getStackTrace();
            throw new GenericException( "Error al obtener las imagenes :: " , HttpStatus.NOT_FOUND.toString());
        }
	}
	

	@Transactional
	public List<CatFolioDTO> getFolioEsp(String folioId)throws GenericException {
		try {

			String sql = "SELECT PDF_FOLIO_VALOR, PDF_FOLIO_ESPECIAL_OFERTA_ID, PDF_FOLIO_ID_CLIENTE, PDF_FOLIO_ESTATUS"
					+ " FROM PER_CAT_FOLIO WHERE PDF_FOLIO_ESPECIAL_OFERTA_ID = '"+folioId+"' AND PDF_FOLIO_ESTATUS = 0 AND rownum <= 10";

			System.out.println("QUERY_SQL_ getFolioEsp :: ejecute:: " + sql);

			return jdbcTemplate.query(sql, (rs, rowNum) -> new CatFolioDTO(rs.getString("PDF_FOLIO_VALOR"),rs.getString("PDF_FOLIO_ESPECIAL_OFERTA_ID"),
					rs.getLong("PDF_FOLIO_ID_CLIENTE"),rs.getInt("PDF_FOLIO_ESTATUS")));
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar getFolioEsp :: ",
					HttpStatus.NOT_FOUND.toString());
		}
	}
	
	@Transactional
	public void actualizaCatFolio(String folioPdfEspecial, Long num_cli) {
	    String query = "UPDATE PER_CAT_FOLIO SET PDF_FOLIO_ID_CLIENTE = " + num_cli + ", PDF_FOLIO_ESTATUS = 1 WHERE PDF_FOLIO_VALOR = '" + folioPdfEspecial+"'";
        jdbcTemplate.execute(query);
	}
}
