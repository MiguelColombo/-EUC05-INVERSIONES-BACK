package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.Tb_Auto_AutoFacultados;
public interface Tb_Auto_AutoFacultadosRepo extends JpaRepository<Tb_Auto_AutoFacultados, String>  {
	
	@Query(value = " Select * from UEC_TB_AUTO_AUTOFACULTADOS a where SOEID like %:SOEID% ",nativeQuery = true )
	List<Tb_Auto_AutoFacultados> ObtenerFacultados(@Param("SOEID") String SOEID);

}
