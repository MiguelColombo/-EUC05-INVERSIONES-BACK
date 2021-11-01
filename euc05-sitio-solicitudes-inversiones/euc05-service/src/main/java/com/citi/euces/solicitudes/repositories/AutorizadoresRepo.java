package com.citi.euces.solicitudes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.*;

public interface AutorizadoresRepo extends JpaRepository<Autorizadores, String> {
	//SE CAMBIO NO LLEVAVA FECHA
	@Query(value = " SELECT a.SOEID, a.NOMBRE,a.SOEID_DIVISIONAL,a.SOEID_DISTRITAL,a.DIVISION,a.DISTRISTO,a.INIC "
			      + " ,a.FECHA_INICIO,a.FECHA_TERMINO,a.ALTA,a.CORREO,a.IS_CETE100,a.IS_CAMPESP,a.ID_NIVEL_AUTO "
			      + " FROM UEC_CATALOGO_AUTORIZADORES2021 a "
			      + " where  a.SOEID like %:SOEID% " 
			      + " and a.DIVISION like %:DIVISION% and ID_NIVEL_AUTO = 1  and a.ALTA = 1 AND TO_CHAR(a.FECHA_TERMINO,'DD/MM/YYYY') >= TO_CHAR(sysdate,'DD/MM/YYYY') ",nativeQuery = true )
	List<Autorizadores> ObtenerAutorizadoresDivisionalesXDivision(@Param("DIVISION") String DIVISION,@Param("SOEID") String SOEID);

	@Query(value = " SELECT a.SOEID, a.NOMBRE,a.SOEID_DIVISIONAL,a.SOEID_DISTRITAL,a.DIVISION,a.DISTRISTO,a.INIC "
		      + " ,a.FECHA_INICIO,a.FECHA_TERMINO,a.ALTA,a.CORREO,a.IS_CETE100,a.IS_CAMPESP,a.ID_NIVEL_AUTO "
		      + " FROM UEC_CATALOGO_AUTORIZADORES2021 a "
		      + " where  a.DISTRISTO like %:DISTRISTO% AND TO_CHAR(a.FECHA_TERMINO,'DD/MM/YYYY') >= TO_CHAR(sysdate,'DD/MM/YYYY') and a.ALTA = 1 ",nativeQuery = true )
    List<Autorizadores> ObtenerAutorizadoresDistritoFacultados(@Param("DISTRISTO") String DISTRISTO);
	
	@Query(value = " SELECT * "
		          + " FROM UEC_CATALOGO_AUTORIZADORES2021 a "
		          + " where  a.SOEID like %:SOEID% ",nativeQuery = true )
	List<Autorizadores> ObtenerAutorizadoresDivisionales(@Param("SOEID") String SOEID);
	
	@Query(value = " SELECT * "
	          + " FROM UEC_CATALOGO_AUTORIZADORES2021 a "
	          + " where  a.SOEID ='SABAUTO' and a.ID_NIVEL_AUTO = 5 ",nativeQuery = true )
	List<Autorizadores> ObtenerAutorizadorAutomatico();
	
	@Query(value = " SELECT * "
	          + " FROM UEC_CATALOGO_AUTORIZADORES2021 a "
	          + " where  a.ALTA =1 and a.ID_NIVEL_AUTO = 5 ",nativeQuery = true )
	List<Autorizadores> ObtenerAutorizadoresGerencia();
}
